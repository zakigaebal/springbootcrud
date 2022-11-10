package com.example.springbootcrud.service;

import com.example.springbootcrud.dao.MemberDao;
import com.example.springbootcrud.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVO> selectAllMembers() {
		return memberDao.selectAll();
	}

	@Override
	public void insertMember(MemberVO member) {
		memberDao.insert(member);
	}

	@Override
	public void updateMember(int id, MemberVO updateMember) {
		MemberVO member = memberDao.selectById(id);
		if(member!=null){
			member.setName(updateMember.getName());
			member.setJob(updateMember.getJob());
			memberDao.update(member);
		} else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}

	@Override
	public void deleteMember(int id) {
		if(memberDao.selectById(id)!=null){
			memberDao.delete(id);
		} else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}

}
