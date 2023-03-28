package com.memberfunc.proj.memberyifan.dao;

import java.util.List;

import com.memberfunc.proj.memberyifan.entity.Transaction;
import com.memberfunc.proj.memberyifan.entity.TransactionDetail;

public interface TransactionDao {
	public abstract int insert(Transaction transaction, List<TransactionDetail> transactionDetail);
	public abstract int updateByTransactionid(Transaction transaction);
	public abstract Boolean delete(Integer transactionid);
	public abstract List<Transaction> selectAll();
	
}
