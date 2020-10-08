package com.article.mongoarticel.service;

import com.article.mongoarticel.dao.CommentRepository;
import com.article.mongoarticel.po.Comment;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xingguanghui002
 * @Date 2020/10/8 3:22 下午
 * @Version 1.0
 */
@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Page<Comment> findByParentId(String parentId, Pageable pageable) {
        return commentRepository.findByParentId(parentId, pageable);
    }

    public void incLikeNum(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("likeNum");
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Comment.class);
    }
}
