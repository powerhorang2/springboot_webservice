package com.jojoldu.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.jojoldu.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이고, Entity 클래스임
 * JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기 보다는, 이 Entity(Posts) 클래스 수정을 통해 작업함
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

	@Id
	@GeneratedValue // 기본 값이 AUTO
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
