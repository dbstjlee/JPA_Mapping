package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// 양방향
@Entity(name = "tb_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	@Id //PK 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 코드 -> db로 위임
	private Long id;
	private String text;
	
	// 밑의 코드가 없으면 단방향 매핑
	// 양방향 매핑
	// 관계 설정(다대다, 일대다 등)
	@ManyToOne
	@JoinColumn(name = "post_id") // 조인 컬럼 생성
	private Post post;
	
}
