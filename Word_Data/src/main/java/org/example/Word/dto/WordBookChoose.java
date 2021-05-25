package org.example.Word.dto;

import lombok.Data;

/**
 * @des:
 * @package: org.example.Word.dto
 * @author: xsg
 * @date: 2021/5/17
 **/
@Data
public class WordBookChoose {
    private Long id;

    private String bookname;

    private Integer wordcount;

    private String ranges;

    private boolean isChoose;
}
