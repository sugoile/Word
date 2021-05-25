package org.example.Word.service;

import org.example.Word.dto.CorrectWord;
import org.example.Word.dto.Study_Word;
import org.example.Word.model.WWord;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.service
 * @author: xsg
 * @date: 2021/5/10
 **/
public interface StudyService {
    List<List<Study_Word>> StudyWordList(long uid, long bid, int wordnum);

    int setStudyBook(long bid, long uid);

    int commitLearnedWord(List<CorrectWord> words, long bid, long uid);

    List<Long> getLearnedWords(long uid, long bid);

    int setStudyBookList(List<Long> bid, long uid);

    List<List<Study_Word>> LastReciteWord(long uid);

    List<List<Study_Word>> RandomTest();
}
