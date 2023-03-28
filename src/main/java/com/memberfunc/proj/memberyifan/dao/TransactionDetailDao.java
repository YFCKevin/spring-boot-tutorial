package com.memberfunc.proj.memberyifan.dao;

import com.memberfunc.proj.memberyifan.entity.Transaction;

public interface TransactionDetailDao {
	public abstract Boolean delete(Integer transactionid);
	public abstract int updateDetailByTransactionid(Transaction transaction);
	
}
