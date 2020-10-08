package com.article.mongoarticel.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author xingguanghui002
 * @Date 2020/10/8 3:12 下午
 * @Version 1.0
 */
@Data
@Document(collection = "comment")
public class Comment implements Serializable {
    @Id
    private String id;
    private String content;
    @Indexed
    private String userId;
    private String nickName;
    private LocalDateTime ctime;
    private Integer likeNum;
    private Integer replayNum;
    private String state;
    private String parentId;
    private String articleId;
    private Date publishTime;



}
