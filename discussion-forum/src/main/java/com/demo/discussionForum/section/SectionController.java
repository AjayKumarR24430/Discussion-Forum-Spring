package com.demo.discussionForum.section;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.discussionForum.user.Role;
import com.demo.discussionForum.user.User;
import com.demo.discussionForum.topic.Topic;
import com.demo.discussionForum.topic.TopicService;
import com.demo.discussionForum.user.UserService;
import com.demo.discussionForum.user.exception.SectionNotFoundException;


@RestController
@RequestMapping("/section")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;
    
    @Autowired
    private TopicService topicService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/display", method = RequestMethod.GET)
    public Set<Topic> getTopicsFromSection(@RequestParam("id") int id){
        Section selectedSection;
        try {
        	selectedSection = sectionService.findOne(id);
        } catch (NoSuchElementException e) {
            throw new SectionNotFoundException();
        }
        Set<Topic> listOfTopics = topicService.findBySection(selectedSection);
        return listOfTopics;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Section> getSections() {
        return sectionService.findAll();
    }
    
    @PostMapping("/newSection")
    public String processAndAddNewSection(@RequestBody Section newSection
    		) {

        Section section = new Section();
        section.setName(newSection.getName());
        section.setDescription(newSection.getDescription());
        section = sectionService.save(section);
        return "New Section added successfully";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") int id) {
        try {
        	sectionService.delete(id);
        } catch (NoSuchElementException e) {
            throw new SectionNotFoundException();
        }                
        return "Section deleted successfully";
    }
    
}
