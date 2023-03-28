package com.memberfunc.proj.memberyifan.entity;

import java.time.LocalDateTime;

public class MemberDto {
	    private String username;
		private String password;
	    private String email;
	    private String nickname;
		private String memberid;
	    private LocalDateTime registerDate;

	    public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getMemberid() {
			return memberid;
		}
		public void setMemberid(String memberid) {
			this.memberid = memberid;
		}
		public LocalDateTime getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(LocalDateTime registerDate) {
			this.registerDate = registerDate;
		}
	
}
