package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// @OneToOne(fetch = FetchType.LAZY)
	// OneToOne -> User, Address 엔티티 간의  1:1 관계를 매핑한다. 
	// FetchType.LAZY : 지연 로딩 전략을 사용함. (getAddress())
	@OneToOne(fetch = FetchType.LAZY)
	
	//@JoinColumn : 외래키(FK)를 설정하는 어노테이션이다.
	// address_id라는 이름 외래키 컬럼이 User 테이블에 추가된다.
	@JoinColumn(name = "address_id")
	private Address address;
	
}
