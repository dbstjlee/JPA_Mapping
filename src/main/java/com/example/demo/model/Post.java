package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	@Id //PK 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 코드 -> db로 위임
	private Long id;
	private String title;
	private String content;
	
	// mappdeBy : post - 연관관계의 주인인 Comment 엔티티의 post(속성) 필드임을 나타낸다.
	// 객체 필드 기준으로 생각해야 한다. 
	// CascadeType.ALL : 제약을 설정하게 되면 Post 엔티티에 대한 모든 상태 변경(저장, 삭제 등)이
	// 관련된 Comment 엔티티에 전파된다. 
	// 다대다 -> 중간 테이블 사라지도록 함.(post = 1, comment = N)
	// entity 명("post") 입력(하나의 컬럼이 아닌 포함관계로 선언한 거)
	 @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) 
//	 @OneToMany 
	private List<Comment> comments; // 연관 관계의 주인은 comment
}
