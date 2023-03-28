package com.memberfunc.proj.memberyifan.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberfunc.proj.memberyifan.entity.Member;

@SpringBootTest
public class MemberServiceImplTests {
	@Autowired
	private MemberService memberService;
	
	@Test
	public void Test() {
		Member member = new Member();
		member.setUsername("test");
		memberService.register(member);
	}
}
