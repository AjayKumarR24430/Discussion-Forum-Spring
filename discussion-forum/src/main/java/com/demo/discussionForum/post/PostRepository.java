package com.demo.discussionForum.post;

import com.demo.discussionForum.topic.Topic;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.discussionForum.user.User;


public interface PostRepository extends JpaRepository<Post, Integer> {
    
    Set<Post> findByUser(User user);
    
    Set<Post> findByTopic(Topic topic);
    
    Set<Post> findAllByOrderByCreationDateDesc();
    
    Set<Post> findTop5ByOrderByCreationDateDesc();
}
