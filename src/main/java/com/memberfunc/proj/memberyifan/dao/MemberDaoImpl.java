package com.memberfunc.proj.memberyifan.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.memberfunc.proj.memberyifan.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}

    @Override
    public int insert(Member member) {
        if(member != null) {
        	Member temp = this.getSession().get(Member.class, member.getMemberid());
        	if(temp == null) {
        		this.getSession().save(member);
        		// 回傳primary key
        		Integer key = member.getMemberid();
        		return key;
        	}
        }
        return 0;
    }

	@Override
	public int updateByMemberId(Member member) {
		if(member != null && member.getMemberid() != 0) {
			Member temp = this.getSession().get(Member.class, member.getMemberid());
			if(temp != null) {
				CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
			    CriteriaUpdate<Member> criteria = builder.createCriteriaUpdate(Member.class);
			    Root<Member> root = criteria.from(Member.class);

			    criteria.set(root.get("username"), member.getUsername());
			    criteria.set(root.get("email"), member.getEmail());
			    criteria.set(root.get("nickname"), member.getNickname());
			    criteria.set(root.get("password"), member.getPassword());
			    criteria.where(builder.equal(root.get("memberid"), member.getMemberid()));
				
			    Query query = this.getSession().createQuery(criteria);
			    return query.executeUpdate();
				
			}
		}
		return 0;
	}

	@Override
	public int delete(Integer memberid) {
		if(memberid != null) {
			Member temp = this.getSession().get(Member.class, memberid);
			if(temp != null) {
				this.getSession().delete(temp);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public List<Member> select() {
		return this.getSession().createQuery("from Member", Member.class).list();
	}

	@Override
	public Member select(Integer memberid) {
		if(memberid != null) {
			return this.getSession().get(Member.class, memberid);
		}
		return null;
	}

	@Override
	public Member findByEmail(Member member) {
		if(member != null) {
			Query<Member> temp = this.getSession().createNativeQuery("SELECT * FROM member WHERE email = :email AND password = :password", Member.class);
			temp.setParameter("email", member.getEmail());
			temp.setParameter("password", member.getPassword());
				return temp.getSingleResult();
		}
		return null;
	}

	@Override
	@Transactional
	public int updateByPut(Member member, Integer memberid) {
		if(memberid != 0) {
			System.out.println(memberid);
			System.out.println(member.toString());
			Member temp = this.getSession().get(Member.class, memberid);
			if(temp != null) {
				CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
			    CriteriaUpdate<Member> criteria = builder.createCriteriaUpdate(Member.class);
			    Root<Member> root = criteria.from(Member.class);

			    if (member.getUsername() != null) {
			    	criteria.set(root.get("username"), member.getUsername());
				}
			    if (member.getEmail() != null) {
			    	criteria.set(root.get("email"), member.getEmail());					
				}
			    if (member.getNickname() != null) {
			    	criteria.set(root.get("nickname"), member.getNickname());					
				}
			    if (member.getPassword() != null) {
			    	criteria.set(root.get("password"), member.getPassword());					
				}
			    criteria.where(builder.equal(root.get("memberid"), memberid));
				
			    Query query = this.getSession().createQuery(criteria);
			    return query.executeUpdate();
				
			}
		}
		return 0;
	}


}
