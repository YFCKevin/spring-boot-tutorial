package com.memberfunc.proj.memberyifan.service;

import java.util.List;

import com.memberfunc.proj.memberyifan.entity.Transaction;

public interface TransactionService {
	public abstract int create(Transaction transaction);
	public abstract Boolean update(Transaction transaction);
	public abstract Boolean delete(Integer transactionid);
	public abstract List<Transaction> getAll();
}
