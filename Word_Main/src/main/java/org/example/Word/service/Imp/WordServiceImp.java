package org.example.Word.service.Imp;

import org.example.Word.dto.Classification;
import org.example.Word.dto.ClassificationChoose;
import org.example.Word.dto.WordBookChoose;
import org.example.Word.mapper.UAdminBookMapper;
import org.example.Word.mapper.WBookMapper;
import org.example.Word.mapper.WClassificationBookMapper;
import org.example.Word.mapper.WClassificationMapper;
import org.example.Word.model.*;
import org.example.Word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @des:
 * @package: org.example.Word.service.Imp
 * @author: xsg
 * @date: 2021/4/19
 **/
@Service
public class WordServiceImp implements WordService {

    @Autowired
    private WBookMapper wBookMapper;

    @Autowired
    private WClassificationMapper wClassificationMapper;

    @Autowired
    private WClassificationBookMapper wClassificationBookMapper;

    @Autowired
    private UAdminBookMapper uAdminBookMapper;


    @Override
    public List<WBook> BookList() {
        return  wBookMapper.selectByExample(new WBookExample());
    }

    @Override
    public List<Classification> ClassificationList() {
        List<Classification> classifications = new ArrayList<>();
        List<WClassification> wClassifications = wClassificationMapper.selectByExample(new WClassificationExample());
        for (WClassification c : wClassifications){
            WClassificationBookExample wClassificationBookExample = new WClassificationBookExample();
            wClassificationBookExample.createCriteria().andCidEqualTo(c.getId());
            List<WClassificationBook> wClassificationBooks = wClassificationBookMapper.selectByExample(wClassificationBookExample);
            if(wClassificationBooks != null && wClassificationBooks.size() > 0){
                List<WBook> wBooks = new ArrayList<>();
                for (WClassificationBook cb : wClassificationBooks){
                    wBooks.add(wBookMapper.selectByPrimaryKey(cb.getBid()));
                }
                classifications.add(new Classification(c.getId(), c.getClassification(), wBooks));
            }
        }
        return classifications;
    }

    @Override
    public List<WBook> learingBook(long uid) {
        List<UAdminBook> uAdminBooks = this.getUAdminBook(uid) ;
        List<WBook> wBooks = new ArrayList<>();
        for (UAdminBook uAdminBook : uAdminBooks) {
            wBooks.add(wBookMapper.selectByPrimaryKey(uAdminBook.getBid()));
        }
        return wBooks;
    }

    @Override
    public List<ClassificationChoose> classificationAndUserBook(long uid) {
        List<ClassificationChoose> classificationChooses = new ArrayList<>();
        List<UAdminBook> uAdminBooks = this.getUAdminBook(uid);
        for (UAdminBook uAdminBook : uAdminBooks) {
            WBook wBook = wBookMapper.selectByPrimaryKey(uAdminBook.getBid());
            WClassificationBookExample wClassificationBookExample = new WClassificationBookExample();
            wClassificationBookExample.createCriteria().andBidEqualTo(uAdminBook.getBid());
            List<WClassificationBook> wClassificationBooks = wClassificationBookMapper.selectByExample(wClassificationBookExample);
            WClassification wClassification = wClassificationMapper.selectByPrimaryKey(wClassificationBooks.get(0).getCid());

            boolean insertFlag = false;
            for(int i = 0; i < classificationChooses.size(); i++){
                if(classificationChooses.get(i).getCid() == wClassification.getId()){
                    List<WBook> wBooks = classificationChooses.get(i).getWBooks();
                    wBooks.add(wBook);
                    classificationChooses.get(i).setWBooks(wBooks);
                    insertFlag = true;
                    break;
                }
            }

            if(!insertFlag){
                ClassificationChoose classificationChoose = new ClassificationChoose();
                classificationChoose.setCid(wClassification.getId());
                classificationChoose.setClassification(wClassification.getClassification());
                List<WBook> wBooks = new ArrayList<>();
                wBooks.add(wBook);
                classificationChoose.setWBooks(wBooks);
                classificationChooses.add(classificationChoose);
            }
        }
        return classificationChooses;
    }

    public List<UAdminBook> getUAdminBook(long uid){
        UAdminBookExample uAdminBookExample = new UAdminBookExample();
        uAdminBookExample.createCriteria().andUidEqualTo(uid).andIshideEqualTo(0);
        return uAdminBookMapper.selectByExample(uAdminBookExample);
    }


}
