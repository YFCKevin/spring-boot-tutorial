package com.memberfunc.proj.memberyifan.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberfunc.proj.memberyifan.entity.Member;

@SpringBootTest
public class MemberDaoImplTests {
	@Autowired
	private MemberDao dao;
	@Test
	public void Test() {
		// insert
		Member insert = new Member();
//		insert.setMemberid(3);
		insert.setUsername("444");
		insert.setEmail("zzz.gmail.com");
		insert.setNickname("www");
		insert.setPassword("hohoho");
		System.out.println(insert.toString());
		int resultInsert = dao.insert(insert);
		System.out.println("result= "+resultInsert);
		
//		// update
//		Member update = new Member();
//		update.setMemberid(1);
//		update.setUsername("Test");
//        update.setPassword("123456");
//        update.setEmail("test@test.com");
//		int resultUpdate = dao.updateByMemberId(update);
//		System.out.println("result= "+resultUpdate);
//
//		// delete
//		Integer del = 3;
//		Integer resultDelete = dao.delete(del);
//		System.out.println("result= "+resultDelete);
//		
//		// select by memberid
//		Integer getAll = 1;
//		Member memberGetOne = dao.select(getAll);
//		System.out.println("result= " + memberGetOne.toString());
//		
//		// select All
//		List<Member> resultGetAll = dao.select();
//		System.out.println("result= " + resultGetAll.toString());
	}
}
