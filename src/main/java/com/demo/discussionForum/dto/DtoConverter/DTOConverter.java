package com.demo.discussionForum.dto.DtoConverter;

import com.demo.discussionForum.model.Comment;
import com.demo.discussionForum.model.Post;
import com.demo.discussionForum.model.User;
import com.demo.discussionForum.dto.CommentDTO;
import com.demo.discussionForum.dto.PostDTO;
import com.demo.discussionForum.dto.UserDTO;

public final class DTOConverter {

    public static CommentDTO commentToDto(final Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getContent(),
                comment.getDateTimeOfComment(),
                comment.getUser(),
                comment.getPost()
        );
    }

    public static PostDTO postToDto(final Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getDateTimeOfPost(),
                post.getImageUrl(),
                post.getCategories(),
                post.getRatingPoints(),
                userToDto(post.getUser())
                );
    }

    public static UserDTO userToDto(final User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsActive(),
                user.getAvatarUrl(),
                user.getDateOfSignUp(),
                user.getRoles()
        );
    }

}
