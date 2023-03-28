package com.memberfunc.proj.memberyifan.service;

import java.util.List;

import com.memberfunc.proj.memberyifan.entity.Member;
import com.memberfunc.proj.memberyifan.entity.MemberDto;

public interface MemberService {
	public abstract int register(Member member);
	public abstract int update(Member member);
	public abstract int updatePut(Member member, Integer memberid);
	public abstract int delete(Integer memberid);
	public abstract List<Member> select();
	public abstract Member select(Integer memberid);
	public abstract Member login(Member member);
}
