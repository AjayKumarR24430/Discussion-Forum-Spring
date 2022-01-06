package com.demo.discussionForum.service;

import com.demo.discussionForum.model.Comment;
import com.demo.discussionForum.dto.DtoConverter.DTOConverter;
import com.demo.discussionForum.model.Post;
import com.demo.discussionForum.dto.PostDTO;
import com.demo.discussionForum.exceptions.PostException;
import com.demo.discussionForum.repository.CommentRepository;
import com.demo.discussionForum.repository.PostRepository;
import com.demo.discussionForum.repository.PostSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostSearch postSearch;

    @Autowired
    public PostService(final PostRepository postRepository, final CommentRepository commentRepository, final PostSearch postSearch) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postSearch = postSearch;
    }

    public PostDTO create(final Post post) {
        this.postRepository.save(post);
        return DTOConverter.postToDto(post);
    }

    public Collection<PostDTO> getAll() {

        Collection<Post> posts = this.postRepository.findAllSortedByDateReverse();
        return posts.stream()
                .map(DTOConverter::postToDto)
                .collect(Collectors.toList());
    }

    public PostDTO getById(final Long id) {
        Post post = this.postRepository.findById(id).orElseThrow(
                () -> new PostException("Can't get. Post not found!"));
        return DTOConverter.postToDto(post);
    }

    public Collection<PostDTO> getAllPaginated(final Integer pageNumber) {
        Integer index = pageNumber - 1;
        Page<Post> posts = this.postRepository.findAll(PageRequest.of(index, 10));
        return posts.stream().map(DTOConverter::postToDto).collect(Collectors.toList());
    }

    public PostDTO update(final Post post) {
        this.postRepository.findById(post.getId()).orElseThrow(
                () -> new PostException("Can't update. Post not found!")
        );
        this.postRepository.save(post);
        return DTOConverter.postToDto(post);
    }

    public void delete(final Long id) {
        Collection<Comment> relatedComments = commentRepository.findByPost_Id(id);
        if (relatedComments.size() > 0) {
            for (Comment comment : relatedComments) {
                commentRepository.deleteById(comment.getId());
            }
        }
        this.postRepository.deleteById(id);
    }

    public void uploadImage(final MultipartFile file) throws IOException {
        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
        File convertFile = new File("/home/ajay_kumar30/Documents/Townscript/Demo-app/Frontend/Forum/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
        System.out.println(convertFile);
        Post foundPost = postRepository.findFirstByOrderByIdDesc();
        foundPost.setImageUrl("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
        System.out.println(foundPost);
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        postRepository.save(foundPost);
    }

    public void rate(final Long id, final Integer buttonState) {
        Post foundPost = postRepository.findById(id).get();
        if (buttonState.equals(0)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() - 1);
        } else if (buttonState.equals(1)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() + 1);
        }
        postRepository.save(foundPost);
    }

    @SuppressWarnings("unchecked")
    public Collection search(final String query) {
        Collection<Post> searchResults;
        try {
            searchResults = postSearch.search(query);
            return searchResults.stream().map(DTOConverter::postToDto).collect(Collectors.toList());
        } catch (Exception ignored) {

        }
        return null;
    }
}
