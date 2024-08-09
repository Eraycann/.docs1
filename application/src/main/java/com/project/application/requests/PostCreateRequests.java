package com.project.application.requests;

import lombok.Data;

@Data
public class PostCreateRequests {

	Long id;
	String text;
	String title;
	Long userId;
}
