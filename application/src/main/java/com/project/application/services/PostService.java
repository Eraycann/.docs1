package com.project.application.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.application.entities.Post;
import com.project.application.entities.User;
import com.project.application.repos.PostRepository;
import com.project.application.requests.PostCreateRequests;
import com.project.application.requests.PostUpdateRequest;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequests newPostRequest) {
		// Post atacak User listede var mı kontrol için, User'in servisine bağlanacağız.
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user == null)
			return null;
		// newPostRequest'i Post'a çevirmem lazımki Save edebileyim. 
		// (Zaten Post içindeki User sıkıntıydı onuda Databaseden getirdiğimiz User'i atıcaz.)
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);	
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(long postId) {
		postRepository.deleteById(postId);
	}
	
	
}
