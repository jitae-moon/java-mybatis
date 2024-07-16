package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Comment implements Serializable {

    private Long id;
    private String userId;
    private Date regDate;
    private String content;

}
