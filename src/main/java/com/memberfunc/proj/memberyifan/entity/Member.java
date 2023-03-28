package com.memberfunc.proj.memberyifan.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private Integer memberid;
	@Column(name = "username", unique = true)
	private String username;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "register_date", updatable = false)
	@CreationTimestamp
	private LocalDateTime registerDate;
	@OneToMany(mappedBy = "payer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TransactionDetail> transactions;
	


	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", nickname=" + nickname + ", registerDate=" + registerDate + "]";
	}


	public Member(Integer memberid, String username, String email, String password, String nickname,
			LocalDateTime registerDate) {
		super();
		this.memberid = memberid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.registerDate = registerDate;
	}


	public int getMemberid() {
		return memberid;
	}


	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public LocalDateTime getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}	
	
	public Member() {
	}
}