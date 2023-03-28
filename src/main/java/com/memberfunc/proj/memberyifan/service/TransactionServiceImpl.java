package com.memberfunc.proj.memberyifan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberfunc.proj.memberyifan.dao.TransactionDao;
import com.memberfunc.proj.memberyifan.dao.TransactionDetailDao;
import com.memberfunc.proj.memberyifan.entity.Transaction;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private TransactionDetailDao transactionDetailDao;

	@Override
	public int create(Transaction transaction) {
		int result = -1;
		if (transaction != null && transaction.getTransactionDetails() != null) {
			result = transactionDao.insert(transaction, transaction.getTransactionDetails());
		}
		return result;
	}

	@Override
	public Boolean update(Transaction transaction) {
		if (transaction != null && transaction.getTransactionid() != null && transaction.getTransactionDetails() != null
				&& !transaction.getTransactionDetails().isEmpty()) {
			int result1 = 0;
			int result2 = 0;
			System.out.println(10);
			result1 = transactionDao.updateByTransactionid(transaction);
			result2 = transactionDetailDao.updateDetailByTransactionid(transaction);
			if (result1 > 0 && result2 > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean delete(Integer transactionid) {
		Boolean result1 = false;
		Boolean result2 = false;
		if (transactionid != null) {
			result1 = transactionDao.delete(transactionid);
			result2 = transactionDetailDao.delete(transactionid);
		}
		if (result1 == true && result2 == true) {
			return true;
		}
		return false;
	}

	@Override
	public List<Transaction> getAll() {
		return transactionDao.selectAll();
	}

}
