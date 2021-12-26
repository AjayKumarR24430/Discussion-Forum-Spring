package com.demo.discussionForum.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.discussionForum.topic.Topic;


@RestController
@RequestMapping(value = "/post")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @RequestMapping(value="/getPosts", method=RequestMethod.GET)
    public List<Post> getPosts() {
    	return postService.findAll();
    }   
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestBody String name, @RequestParam("id") int id
                         ) {
        Post post = postService.findOne(id);
        
        if (post == null) {
            return "No post found";
        }
        
        if (!name.contentEquals(post.getUser().getUsername())) {
            return "Cannot delete this Post";
        }
        
        postService.delete(post);
        
        return "Post successfully deleted";
    }
}
