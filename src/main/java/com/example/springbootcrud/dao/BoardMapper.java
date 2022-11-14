package com.example.springbootcrud.dao;



import com.example.springbootcrud.domain.Board;
import com.example.springbootcrud.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
	public boolean addBoard(Board b);
	public List<Board> getBoard();
	public Board getBoardOne(int idx);
	public boolean addReply(Reply r);
	public List<Reply> getReply(int boardIdx);

	void delete(int id);
	
}
