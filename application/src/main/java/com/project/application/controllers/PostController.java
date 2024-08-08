package com.project.application.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.entities.Post;
import com.project.application.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;
	
		public PostController(PostService postService) {
		this.postService = postService;
	}

// Optional vasıtsıyla parametreli yada parametresiz çalışacak ve ikiside bu endpointi tetikleyecektir.
//		İşlev: Tüm Post nesnelerini ya da belirli bir userId'ye sahip Postları döndürür.
//		@RequestParam     // URL'den ?userId=123 gibi sorgu parametresini alır
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}

//	İşlev: Belirli bir postId'ye sahip tek bir Post nesnesini döndürür.
//	@PathVariable	// URL'den /posts/123 gibi yol parametresini alır
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
//	@RequestParam: Query string parametreleri (?key=value) alır ve opsiyoneldir.
//	@PathVariable: URL yolundaki dinamik segmentleri (/path/{variable}) alır ve genellikle zorunludur.

	@PostMapping
	public Post createOnePost(@RequestBody Post newPost) {
		return postService.createOnePost(newPost);
	}
}
