package com.example.springbootcrud.dao;

import com.example.springbootcrud.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
	List<MemberVO> selectAll();
	MemberVO selectById(int id);
	void insert(MemberVO member);
	void update(MemberVO member);
	void delete(int id);
}
