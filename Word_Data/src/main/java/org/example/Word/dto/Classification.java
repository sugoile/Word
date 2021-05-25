package org.example.Word.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Word.Po.WBookChoose_PO;
import org.example.Word.model.WBook;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.dto
 * @author: xsg
 * @date: 2021/4/19
 **/
@AllArgsConstructor
@Getter
@Setter
public class Classification {
    private long cid;

    private String classification;

    private List<WBookChoose_PO> wBooks;

}
