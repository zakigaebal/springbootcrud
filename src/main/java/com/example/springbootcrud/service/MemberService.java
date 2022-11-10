package com.example.springbootcrud.service;

import com.example.springbootcrud.vo.MemberVO;

import java.util.List;

public interface MemberService {

	List<MemberVO> selectAllMembers();

	void insertMember(MemberVO member);

	void updateMember(int id, MemberVO member);

	void deleteMember(int id);
	
}
