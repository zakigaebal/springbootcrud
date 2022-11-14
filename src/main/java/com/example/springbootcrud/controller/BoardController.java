package com.example.springbootcrud.controller;


import com.example.springbootcrud.domain.Board;
import com.example.springbootcrud.domain.Reply;
import com.example.springbootcrud.service.BoardService;
import com.example.springbootcrud.vo.MemberVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Api(tags = {"대댓글게시판"})
@Controller
public class BoardController {

    @Autowired
    private BoardService s;

    @GetMapping("/")
    public String root() {
        return "board";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }

    @PostMapping("/writeAction")
    public String writeAction(
            @RequestParam("title")String title,
            @RequestParam("contents")String contents) throws IllegalStateException, IOException {
        s.addBoard(new Board(0, title, contents
                , null
        ));
        return "board";
    }

    @GetMapping("/boardList")
    @ResponseBody
    public List<Board> boardList(){
        return s.getBoard();
    }
    @GetMapping("/boardView")
    @ResponseBody
    public Board boardList(@RequestParam("idx")int idx){
        return s.getBoardOne(idx);
    }


    //    게시글 삭제
    @DeleteMapping("/board/del/{idx}")
    public String deleteMember(@PathVariable int idx){
        s.deleteMember(idx);
        return "board";
    }





    @GetMapping("/replyList")
    @ResponseBody
    public List<Reply> replyList(@RequestParam("idx")int boardIdx){
        return s.getReply(boardIdx);
    }

    @PostMapping("/writeReply")
    public String writeReply(
            @RequestParam("idx")int idx,
            @RequestParam("replyIdx")int replyIdx,
            @RequestParam("contents")String contents) {
        s.addReply(new Reply(0, idx,replyIdx, contents));
        return "redirect:view?idx=" + idx;
    }



}
