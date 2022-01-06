package com.demo.discussionForum.controller;

import com.demo.discussionForum.dto.PostDTO;
import com.demo.discussionForum.model.Post;
import com.demo.discussionForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody final Post post) {
        return new ResponseEntity<>(this.postService.create(post), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<PostDTO>> getAllPosts() {
        return new ResponseEntity<>(this.postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.postService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PostDTO> updatePost(@RequestBody final Post post) {
        return new ResponseEntity<>(this.postService.update(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePostById(@PathVariable final Long id) {
        this.postService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadImageOnServer(@RequestParam("file") MultipartFile file) throws IOException {
        this.postService.uploadImage(file);
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}/rate")
    public ResponseEntity<PostDTO> ratePost(@PathVariable final Long id, @RequestBody final Integer buttonState) {
        this.postService.rate(id, buttonState);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<Collection<PostDTO>> getPostsPaginated(@PathVariable final Integer pageNumber) {
        return new ResponseEntity<>(this.postService.getAllPaginated(pageNumber), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Collection<PostDTO>> searchPost(String q) {
        return new ResponseEntity<>(this.postService.search(q), HttpStatus.OK);
    }
}