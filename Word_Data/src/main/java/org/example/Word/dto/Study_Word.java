package org.example.Word.dto;

import lombok.Data;
import lombok.Setter;

/**
 * @des:
 * @package: org.example.Word.dto
 * @author: xsg
 * @date: 2021/5/12
 **/
@Data
public class Study_Word {
    private Long id;

    private String spell;

    private String meaningstr;

    private boolean isTrueWord;
}
