package com.memberfunc.proj.memberyifan.dao;

import java.util.List;

import com.memberfunc.proj.memberyifan.entity.Member;
import com.memberfunc.proj.memberyifan.entity.MemberDto;

public interface MemberDao {
	public abstract int insert(Member member);
	public abstract int updateByMemberId(Member member);
	public abstract int updateByPut(Member member, Integer memberid);
	public abstract int delete(Integer memberid);
	public abstract List<Member> select();
	public abstract Member select(Integer memberid);
	public abstract Member findByEmail(Member member);
	
	
}
