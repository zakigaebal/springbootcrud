package com.example.springbootcrud.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private int idx;
    private int boardIdx;
    private int replyIdx;
    private String contents;
}
