package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

//    void like(Comment comment);

    void save(Comment comment);

    Comment findById(Integer id);
}
