package org.example.Word.controller;

import org.example.Word.api.REData;
import org.example.Word.dto.CorrectWord;
import org.example.Word.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.controller
 * @author: xsg
 * @date: 2021/5/10
 **/
@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @GetMapping("/studyWordList")
    public REData StudyWordList(@RequestParam("bid") long bid, @RequestParam(value = "wordnum", defaultValue = "10") int wordnum){
        return REData.success("查询需要学习的单词成功", studyService.StudyWordList(bid, wordnum));
    }

    //设置成堆提交（ishide属性（隐藏某一本的状态））没有ishide属性
    @GetMapping("/setStudyBook/{uid}")
    public REData setStudyBook(@RequestParam("bid") long bid, @PathVariable("uid")long uid){
        int res = studyService.setStudyBook(bid, uid);
        if(res > 0){
            return REData.success("设置学习的单词书成功", res);
        }else if(res == -1){
            return REData.failed("学习的单词书不存在");
        }else if(res == -2){
            return REData.failed("该用户不存在");
        }else{
            return REData.failed("设置学习的单词书失败");
        }
    }

    //设置成堆提交（ishide属性（隐藏某一本的状态））
    @PostMapping("/setStudyBookList/{uid}")
    public REData setStudyBookList(@RequestParam("bid") List<Long> bid, @PathVariable("uid")long uid){
        int res = studyService.setStudyBookList(bid, uid);
        if(res > 0){
            return REData.success("设置学习的单词书成功", res);
        }else if(res == -1){
            return REData.failed("学习的单词书不存在");
        }else if(res == -2){
            return REData.failed("该用户不存在");
        }else{
            return REData.failed("设置学习的单词书失败");
        }
    }

    @PostMapping("/commitLearnedWord/{uid}")
    public REData commitLearnedWord(@RequestBody List<CorrectWord> words, @RequestParam("bid") long bid, @PathVariable("uid")long uid){
        return REData.success("提交学过的单词成功", studyService.commitLearnedWord(words, bid, uid));
    }
}
