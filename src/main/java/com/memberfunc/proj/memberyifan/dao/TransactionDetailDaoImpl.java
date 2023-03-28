package com.memberfunc.proj.memberyifan.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.memberfunc.proj.memberyifan.entity.Status;
import com.memberfunc.proj.memberyifan.entity.Transaction;
import com.memberfunc.proj.memberyifan.entity.TransactionDetail;

@Repository
public class TransactionDetailDaoImpl implements TransactionDetailDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	@Override
	public Boolean delete(Integer transactionid) {
		if (transactionid != null) {
			Query query = getSession().createQuery(
					"update TransactionDetail td set td.status = :status where td.transaction.transactionid = :transactionId");
			query.setParameter("status", Status.Delete);
			query.setParameter("transactionId", transactionid);
			int result = query.executeUpdate();
			return result > 0;
		}
		return false;
	}

	@Override
	public int updateDetailByTransactionid(Transaction transaction) {
		if (transaction.getTransactionDetails() != null && transaction.getTransactionid() != null && !transaction.getTransactionDetails().isEmpty()) {
			String hql = "update TransactionDetail set payer = :payer, debtor = :debtor, amount = :amount where transaction_id = :transaction_id and transactionDetailid = :transactionDetailid";
			Query query = this.getSession().createQuery(hql);
			int result = 0;
			List<TransactionDetail> details = transaction.getTransactionDetails();
			for (int i = 0; i < details.size(); i++) {
				query.setParameter("amount", details.get(i).getAmount());
				query.setParameter("payer", details.get(i).getPayer());
				query.setParameter("debtor", details.get(i).getDebtor());
				query.setParameter("transaction_id", transaction.getTransactionid());
				query.setParameter("transactionDetailid", transaction.getTransactionDetails().get(i).getTransactionDetailid());
				result += query.executeUpdate();
			}
			return result;
		}
		return 0;
	}

}
