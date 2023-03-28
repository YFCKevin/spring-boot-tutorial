package com.memberfunc.proj.memberyifan.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.memberfunc.proj.memberyifan.entity.Status;
import com.memberfunc.proj.memberyifan.entity.Transaction;
import com.memberfunc.proj.memberyifan.entity.TransactionDetail;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}

	@Override
	public int insert(Transaction transaction, List<TransactionDetail> transactionDetails) {
		if(transaction == null || transactionDetails == null || transactionDetails.isEmpty()) {
			return 0;
		}
		this.getSession().save(transaction);
		
		for (TransactionDetail details : transactionDetails) {
			details.setTransaction(transaction);
			this.getSession().save(details);
		}
		
		return transaction.getTransactionid();
	}

	@Override
	public List<Transaction> selectAll() {
//		String sql = "select * from transactions ts join transactions_detail tsd on ts.transaction_id = tsd.transaction_id order by ts.type;";
		String hql = "from Transaction ts join fetch ts.transactionDetails tsd order by ts.createDate";
		return this.getSession().createQuery(hql, Transaction.class).getResultList();
	}

	@Override
	public Boolean delete(Integer transactionid) {
		if(transactionid != null) {
			Transaction temp = this.getSession().get(Transaction.class, transactionid);
			if(temp != null) {
				temp.setStatus(Status.Delete);
				return true;
			}
		}
		return false;
	}

	@Override
	public int updateByTransactionid(Transaction transaction) {
		if (transaction != null && transaction.getTransactionid() != null) {
			getSession().update(transaction);
			
//			List<TransactionDetail> details = transaction.getTransactionDetails();
//			if(details != null && !details.isEmpty()) {
//				for(TransactionDetail detail : details) {
//					System.out.println(detail);
//					getSession().update(detail);
//				}
//			}
			return 1;
		}
		return 0;
	}
	
	
}
