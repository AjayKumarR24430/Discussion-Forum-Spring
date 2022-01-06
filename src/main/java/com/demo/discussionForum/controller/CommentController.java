package com.demo.discussionForum.controller;

import com.demo.discussionForum.dto.CommentDTO;
import com.demo.discussionForum.model.Comment;
import com.demo.discussionForum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody final Comment comment) {
        return new ResponseEntity<>(this.commentService.create(comment), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Collection<CommentDTO>> getCommentsByPostId(@PathVariable final Long id) {
        return new ResponseEntity<>(this.commentService.getAllByPostId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommentDTO> updateComment(@RequestBody final Comment comment) {
        return new ResponseEntity<>(this.commentService.update(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentById(@PathVariable final Long id) {
        this.commentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}