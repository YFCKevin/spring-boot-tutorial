package com.memberfunc.proj.memberyifan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transactions_detail")
public class TransactionDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_detail_id")
	private Integer transactionDetailid;
	
	@ManyToOne
	@JoinColumn(name = "payer_member_id", referencedColumnName = "member_id")
	private Member payer;
	
	@ManyToOne
	@JoinColumn(name = "debtor_member_id", referencedColumnName = "member_id")
	private Member debtor;
	
	@Column(name = "amount", nullable = false)
	private Integer amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    private Transaction transaction;

	public TransactionDetail() {
	}
	
	
	@Override
	public String toString() {
		return "TransactionDetail [transactionDetailid=" + transactionDetailid + ", amount=" + amount + ", status="
				+ status + "]";
	}


	public TransactionDetail(Integer transactionDetailid, Member payer, Member debtor, Integer amount,
			Transaction transaction) {
		super();
		this.transactionDetailid = transactionDetailid;
		this.payer = payer;
		this.debtor = debtor;
		this.amount = amount;
		this.transaction = transaction;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getTransactionDetailid() {
		return transactionDetailid;
	}

	public void setTransactionDetailid(Integer transactionDetailid) {
		this.transactionDetailid = transactionDetailid;
	}

	public Member getPayer() {
		return payer;
	}

	public void setPayer(Member payer) {
		this.payer = payer;
	}

	public Member getDebtor() {
		return debtor;
	}

	public void setDebtor(Member debtor) {
		this.debtor = debtor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
