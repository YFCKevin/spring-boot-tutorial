package com.memberfunc.proj.memberyifan.dao;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberfunc.proj.memberyifan.entity.Member;
import com.memberfunc.proj.memberyifan.entity.Status;
import com.memberfunc.proj.memberyifan.entity.Transaction;
import com.memberfunc.proj.memberyifan.entity.TransactionDetail;
import com.memberfunc.proj.memberyifan.entity.Type;

@SpringBootTest
public class TransactionDaoImplTests {
	@Autowired
	private TransactionDao dao;
	@Test
	public void Test() {
		// insert
//		Transaction insert = new Transaction();
//		List<TransactionDetail> detail = new ArrayList<TransactionDetail>();
//		Member m1 = new Member();
//		m1.setMemberid(1);
//		Member m2 = new Member();
//		m2.setMemberid(2);
//		Member m3 = new Member();
//		m3.setMemberid(3);
//		
//		TransactionDetail transactionDetail = new TransactionDetail();
//		transactionDetail.setPayer(m2);
//		transactionDetail.setDebtor(m2);
//		transactionDetail.setAmount(100);
//		transactionDetail.setStatus(Status.Create);
//		detail.add(transactionDetail);
//		
//		transactionDetail.setPayer(m2);
//		transactionDetail.setDebtor(m1);
//		transactionDetail.setAmount(20);
//		transactionDetail.setStatus(Status.Create);
//		detail.add(transactionDetail);
//			
//		TransactionDetail transactionDetail2 = new TransactionDetail();
//		transactionDetail2.setPayer(m2);
//		transactionDetail2.setDebtor(m3);
//		transactionDetail2.setAmount(10);
//		transactionDetail2.setStatus(Status.Create);
//		detail.add(transactionDetail2);
//
//		insert.setTransactionTitle("第二筆");
//		insert.setType(Type.Transportation);
//		insert.setSum(130);
//		insert.setTransactionDetails(detail);
//		insert.setStatus(Status.Create);
//		
//		int resultInsert = dao.insert(insert, detail);
//		System.out.println("result= "+resultInsert);
//		
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
		Integer del = 3;
		Boolean resultDelete = dao.delete(del);
		System.out.println("result= "+resultDelete);
//		
//		// select by memberid
//		Integer getAll = 1;
//		Member memberGetOne = dao.select(getAll);
//		System.out.println("result= " + memberGetOne.toString());
//		
//		// select All
//		List<Transaction> resultGetAll = dao.selectAll();
//		System.out.println("result= " + resultGetAll.toString());
	}
}
