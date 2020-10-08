package com.article.mongoarticel.service;

import com.article.mongoarticel.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author xingguanghui002
 * @Date 2020/10/8 3:25 下午
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTest {

    @Autowired
    CommentService commentService;


    @Test
    public void saveComment() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setArticleId("111");
            comment.setContent("xing zhen tm shuai");
            comment.setUserId("xgh" + i);
            comment.setCtime(LocalDateTime.now());
            comment.setLikeNum(i);
            comment.setState("1");
            comment.setParentId(i - 1 + "");
            commentService.saveComment(comment);
        }

    }


    @Test
    public void findAll() {
        List<Comment> all = commentService.findAll();
        System.out.printf("" + all.size());
    }

    @Test
    public void findByParentId() {
        String parentId = "1";
        int pageNo = 0;
        int pageSize = 5;
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Comment> byParentId = commentService.findByParentId(parentId, pageRequest);
        System.out.println(byParentId.getTotalElements());
    }

    @Test
    public void incLikeNum() {
        String id = "5f7ec2bc4d221935905687b1";
        commentService.incLikeNum(id);
    }
}