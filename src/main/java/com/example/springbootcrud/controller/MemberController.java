package com.example.springbootcrud.controller;

import com.example.springbootcrud.service.MemberServiceImpl;
import com.example.springbootcrud.vo.MemberVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Api 정보를 제공하는 Controller"})
@RestController
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;

	
	@GetMapping("/member/all")
	public List<MemberVO> selectAllMembers(){
		return memberService.selectAllMembers();
	}
	
	@PostMapping("/member/new")
	public List<MemberVO> insertMember(@RequestBody MemberVO member){
		memberService.insertMember(member);
		return memberService.selectAllMembers();
	}

	@PutMapping("/member/{id}")
	public List<MemberVO> updateMember(@PathVariable int id, @RequestBody MemberVO member){
		memberService.updateMember(id, member);
		return memberService.selectAllMembers();
	}

	@DeleteMapping("/member/{id}")
	public List<MemberVO> deleteMember(@PathVariable int id){
		memberService.deleteMember(id);
		return memberService.selectAllMembers();
	}
}
