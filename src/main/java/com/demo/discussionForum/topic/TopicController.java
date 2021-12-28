package com.demo.discussionForum.topic;

import com.demo.discussionForum.section.SectionService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.discussionForum.post.NewPostRequest;
import com.demo.discussionForum.post.Post;
import com.demo.discussionForum.post.PostService;
import com.demo.discussionForum.user.User;
import com.demo.discussionForum.user.UserService;


@RestController
@RequestMapping("/topic")
public class TopicController {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private TopicService topicService;
    
    @Autowired
    private SectionService sectionService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Topic getTopicById(@RequestParam("topicId") int topicId) {

        return topicService.findOne(topicId);
    }
    
    @RequestMapping(value="/getTopics", method = RequestMethod.GET)
    public List<Topic> getTopics() {
        return topicService.findAll();
    }
    
    @RequestMapping(value="/newPost", method = RequestMethod.POST)
    public String addPost(@RequestBody NewPostRequest newPost,
                          @RequestParam("topicId") int topicId
                          ) {
        
    	System.out.println(topicId);
        Post post = new Post();
        post.setContent(newPost.getContent());
        post.setTopic(topicService.findOne(topicId));
        post.setUser(userService.findByUsername(newPost.getName()));
        postService.save(post);
       
        return "Post added successfully";
    }

    @RequestMapping(value = "/newTopic", method = RequestMethod.POST)
    public String processAndAddNewTopic(@RequestBody NewTopicRequest newTopic) {
    	
        Topic topic = new Topic();
        topic.setUser(userService.findByUsername(newTopic.getUserName()));
        topic.setTitle(newTopic.getTitle());
        topic.setContent(newTopic.getContent());
        topic.setSection(sectionService.findOne(newTopic.getSectionId()));
        topicService.save(topic);
        
        return "Topic added successfully";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestBody String name, @RequestParam("id") int id
                         ) {
        Topic topic = topicService.findOne(id);
        
        if (topic == null) {
            return "No topic found";
        }
        System.out.println(name);
        System.out.println(name.contentEquals(topic.getUser().getUsername()));
        if (!name.contentEquals(topic.getUser().getUsername())) {
            return "Cannot delete this Topic";
        }
        
        topicService.delete(topic);
        
        return "Topic successfully deleted";
    }
    
}
