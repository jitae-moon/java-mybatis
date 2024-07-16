package org.example.repository.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.model.Comment;

import java.io.IOException;
import java.io.InputStream;

public class CommentSessionRepository {

    // MyBatis 객제 생성
    private SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Comment selectComment(Long id) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        try {
            String statement = "org.example.repository.session.CommentSessionRepository.selectComment";

            return sqlSession.selectOne(statement, id);
        } finally {
           sqlSession.close();
        }
    }

    public Integer insertComment(Comment comment) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        try {
            String statement = "org.example.repository.session.CommentSessionRepository.insertComment";
            int result = sqlSession.insert(statement, comment);

            if (result > 0) sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    public Integer updateComment(Comment comment) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        try {
            String statement = "org.example.repository.session.CommentSessionRepository.updateComment";
            int result = sqlSession.update(statement, comment);

            if (result > 0) sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    public Integer deleteComment(Long id) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        try {
            String statement = "org.example.repository.session.CommentSessionRepository.deleteComment";
            int result = sqlSession.delete(statement, id);

            if (result > 0) sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

}
