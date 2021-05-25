package org.example.Word.service;

import org.example.Word.dto.Classification;
import org.example.Word.dto.ClassificationChoose;
import org.example.Word.model.WBook;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.service
 * @author: xsg
 * @date: 2021/4/19
 **/
public interface WordService {
    List<WBook> BookList();

    List<Classification> ClassificationList();

    List<WBook> learingBook(long uid);

    List<ClassificationChoose> classificationAndUserBook(long uid);
}
