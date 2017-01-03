package com.smriti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smriti.model.PostModel;
import com.smriti.model.Posts;
import com.smriti.model.UserProfiles;
import com.smriti.services.ForumService;
import com.smriti.services.PostService;
import com.smriti.services.UserProfileService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
		
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ForumService forumService;
	
	@RequestMapping(value = "/post/all/{id}")
	public @ResponseBody Map<String,Object> getPosts(@PathVariable("id") String forumId) {	
		List<Posts> posts = this.postService.getPostsByForum(forumId);			
		List<PostModel> postModelList = new ArrayList<PostModel>();  		
		
		PostModel postModel = null;
		UserProfiles user = null;
		
		for(Posts post: posts) {			
			
			user = this.userProfileService.get(post.getUserId());
			postModel = new PostModel(post,user);
	//		postModel.setPostId(post.getId());
		//	postModel.setContent(post.getContent());
		//	postModel.setPostedAt(post.getPostedAt());
		//	postModel.setAvatar(user.getAvatar());					
		//	postModel.setUsername(user.getEmailAddress());
			postModelList.add(postModel);			
		}
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("forum", this.forumService.get(forumId));
		model.put("posts", postModelList);
		
		return model;				
	}
	

}
