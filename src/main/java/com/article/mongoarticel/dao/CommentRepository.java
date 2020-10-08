package com.article.mongoarticel.dao;

import com.article.mongoarticel.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author xingguanghui002
 * @Date 2020/10/8 3:20 下午
 * @Version 1.0
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentId(String parentId, Pageable pageable);
}
