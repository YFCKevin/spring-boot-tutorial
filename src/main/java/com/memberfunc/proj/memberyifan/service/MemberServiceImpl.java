package com.memberfunc.proj.memberyifan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberfunc.proj.memberyifan.dao.MemberDao;
import com.memberfunc.proj.memberyifan.entity.Member;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public int register(Member member) {
		int result = -1;
		if (member != null) {
			result = memberDao.insert(member);
		}
		return result;
	}

	@Override
	public int update(Member member) {
		int result = 0;
		if (member != null && member.getMemberid() != 0) {
			result = memberDao.updateByMemberId(member);
		}
		return result;
	}

	@Override
	public int delete(Integer memberid) {
		int result = 0;
		if (memberid != null) {
			result = memberDao.delete(memberid);
		}
		return result;
	}

	@Override
	public List<Member> select() {
		return memberDao.select();
	}

	@Override
	public Member select(Integer memberid) {
		Member result = new Member();
		if (memberid != null) {
			result = memberDao.select(memberid);
		}
		return result;
	}

	@Override
	public Member login(Member member) {
		Member result = memberDao.findByEmail(member);
		if(member == null || !member.getPassword().equals(result.getPassword())) {
			return null;
		}
		return result;
	}

	@Override
	public int updatePut(Member member, Integer memberid) {
		int result = 0;
		if (member != null && memberid != 0) {
			result = memberDao.updateByPut(member, memberid);
		}
		return result;
	}
}
