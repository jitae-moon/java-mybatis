package org.example.repository.session;

import org.assertj.core.api.Assertions;
import org.example.model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CommentSessionRepositoryTest {

    private CommentSessionRepository sut;

    @BeforeEach
    void beforeEach() {
        sut = new CommentSessionRepository();
    }

    @DisplayName("댓글 id가 주어지면 해당 댓글을 반환한다.")
    @Test
    void selectComment() {
        // Given
        Long id = 1L;

        // When
        Comment comment = sut.selectComment(id);

        // Then
        assertThat(comment.getId()).isEqualTo(1L);
    }

    @DisplayName("새로운 댓글 정보가 주어지면 새로운 댓글을 생성한다.")
    @Test
    void insertComment() {
        // Given
        Comment comment = Comment.builder()
                .userId("test")
                .regDate(new Date())
                .content("new content")
                .build();

        // When
        Integer result = sut.insertComment(comment);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("수정된 댓글 정보가 주어지면 해당 댓글의 내용을 수정한다.")
    @Test
    void updateComment() {
        // Given
        Long id = 1L;
        String content = "updated test comment";
        Comment updatedComment = Comment.builder()
                .id(id)
                .content(content)
                .build();

        // When
        Integer result = sut.updateComment(updatedComment);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("댓글 id가 주어지면 해당 댓글을 삭제한다.")
    @Test
    void deleteComment() {
        // Given
        Long id = 1L;

        // When
        Integer result = sut.deleteComment(id);

        // Then
        assertThat(result).isEqualTo(1);
    }

}