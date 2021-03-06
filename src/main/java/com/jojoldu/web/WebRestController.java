package com.jojoldu.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jojoldu.dto.posts.PostsSaveRequestDto;
import com.jojoldu.service.PostsService;

import lombok.AllArgsConstructor;

//@RestController 는 @ResponseBody 를 모든 메소드에 적용 해준다.
//hello 메소드의 결과는 HelloWorld 라는 문자열을 JSON 형태로 반환한다.
@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
}
