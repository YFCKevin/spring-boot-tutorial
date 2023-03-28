package com.memberfunc.proj.memberyifan.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Integer transactionid;

	@Column(name = "transaction_title", nullable = false)
	private String transactionTitle;

	@Column(name = "sum", nullable = false)
	private Integer sum;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "create_date", updatable = false)
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<TransactionDetail> transactionDetails;

	public Transaction() {
	}
	
	public Transaction(Integer transactionid, String transactionTitle, Integer sum, Type type,
			List<TransactionDetail> transactionDetails) {
		super();
		this.transactionid = transactionid;
		this.transactionTitle = transactionTitle;
		this.sum = sum;
		this.type = type;
		this.transactionDetails = transactionDetails;
	}

	
	
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactionTitle=" + transactionTitle + ", sum=" + sum
				+ ", type=" + type + ", status=" + status + ", createDate=" + createDate  + "]";
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransactionTitle() {
		return transactionTitle;
	}

	public void setTransactionTitle(String transactionTitle) {
		this.transactionTitle = transactionTitle;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<TransactionDetail> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
