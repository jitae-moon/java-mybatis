package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Reply implements Serializable {

    private Long id;
    private Long commentId;
    private String userId;
    private String content;
    private Date regDate;

}

