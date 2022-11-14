package com.example.springbootcrud.vo;

import lombok.Data;

@Data
public class BoardVO {
    private int idx;
    private String title;
    private String contents;
    private String image;
}
