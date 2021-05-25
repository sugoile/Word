package org.example.Word.dto;

import lombok.Data;
import org.example.Word.model.WBook;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.dto
 * @author: xsg
 * @date: 2021/5/17
 **/
@Data
public class ClassificationChoose {
    private long cid;

    private String classification;

    private List<WBook> wBooks;
}
