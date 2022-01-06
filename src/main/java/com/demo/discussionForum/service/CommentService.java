package com.demo.discussionForum.service;

import com.demo.discussionForum.model.Comment;
import com.demo.discussionForum.dto.DtoConverter.DTOConverter;
import com.demo.discussionForum.dto.CommentDTO;
import com.demo.discussionForum.exceptions.CommentException;
import com.demo.discussionForum.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDTO create(final Comment comment) {
        this.commentRepository.save(comment);
        return DTOConverter.commentToDto(comment);
    }

    public List<CommentDTO> getAllByPostId(final Long id) {
        Collection<Comment> foundComments = this.commentRepository.findByPost_Id(id);
        return foundComments.stream()
                .sorted(Comparator.comparing(Comment::getDateTimeOfComment).reversed())
                .map(DTOConverter::commentToDto)
                .collect(Collectors.toList());
    }

    public CommentDTO update(final Comment comment) {
        this.commentRepository.findById(comment.getId()).orElseThrow(
                () -> new CommentException("Can't update. Comment not found!")
        );
        this.commentRepository.save(comment);
        return DTOConverter.commentToDto(comment);
    }

    public void delete(final Long id) {
        this.commentRepository.deleteById(id);
    }
}