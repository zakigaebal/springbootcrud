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
public class IndexController {

    @Autowired
    private BoardService s;
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String root() {
        return "index";
    }
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value="/board", method=RequestMethod.GET)
    public String board() {
        return "board";
    }
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write() {
        return "write";
    }
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public String view() {
        return "view";
    }
    @RequestMapping(value="/writeAction", method=RequestMethod.POST)
    public String writeAction(
            HttpServletRequest req,@RequestParam("file") MultipartFile file,
            @RequestParam("title")String title,
            @RequestParam("contents")String contents) throws IllegalStateException, IOException {
        String PATH = req.getSession().getServletContext().getRealPath("/") + "resources/";
        if (!file.getOriginalFilename().isEmpty()) {
            file.transferTo(new File(PATH + file.getOriginalFilename()));
        }
        s.addBoard(new Board(0, title, contents, file.getOriginalFilename()));
        return "board";
    }
    @RequestMapping(value="/boardList", method=RequestMethod.GET)
    @ResponseBody
    public List<Board> boardList(){
        return s.getBoard();
    }
    @RequestMapping(value="/boardView", method=RequestMethod.GET)
    @ResponseBody
    public Board boardList(@RequestParam("idx")int idx){
        return s.getBoardOne(idx);
    }
    @RequestMapping(value="/replyList", method=RequestMethod.GET)
    @ResponseBody
    public List<Reply> replyList(@RequestParam("idx")int boardIdx){
        return s.getReply(boardIdx);
    }
    @RequestMapping(value="/writeReply", method=RequestMethod.POST)
    public String writeReply(
            @RequestParam("idx")int idx,
            @RequestParam("replyIdx")int replyIdx,
            @RequestParam("contents")String contents) {
        s.addReply(new Reply(0, idx,replyIdx, contents));
        return "redirect:view?idx=" + idx;
    }



}
