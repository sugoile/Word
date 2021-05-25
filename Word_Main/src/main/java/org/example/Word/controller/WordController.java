package org.example.Word.controller;

import org.example.Word.api.REData;
import org.example.Word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @des:
 * @package: org.example.Word.controller
 * @author: xsg
 * @date: 2021/4/19
 **/
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/bookList")
    public REData BookList(){
        return REData.success("查询成功", wordService.BookList());
    }

    @GetMapping("/learningBook/{uid}")
    public REData learingBook(@PathVariable(value = "uid") long uid){
        return REData.success("正在学习的单词书查询成功", wordService.learingBook(uid));
    }

    @GetMapping("/classificationList/{uid}")
    public REData ClassificationList(@PathVariable("uid") long uid){
        return REData.success("查询成功", wordService.ClassificationList(uid));
    }

    @GetMapping("/classificationAndUserBook/{uid}")
    public REData classificationAndUserBook(@PathVariable(value = "uid") long uid){
        return REData.success("用户勾选的单词书分类查询成功", wordService.classificationAndUserBook(uid));
    }

}
