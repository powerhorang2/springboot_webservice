package com.jojoldu.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jojoldu.domain.posts.Posts;
import com.jojoldu.domain.posts.PostsRepository;
import com.jojoldu.dto.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}

	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("powerhorang2@naver.com")
				.content("테스트")
				.title("테스트 타이틀")
				.build();
		
		// when
		postsService.save(dto);
		
		// then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
}
