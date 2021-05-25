package org.example.Word.Test;

import org.example.Word.mapper.WBookMapper;
import org.example.Word.mapper.WBookWordMapper;
import org.example.Word.mapper.WWordMapper;
import org.example.Word.model.WBook;
import org.example.Word.model.WBookExample;
import org.example.Word.model.WBookWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @des: 随机生成不重复随机数
 * @package: org.example.Word.Test
 * @author: xsg
 * @date: 2021/5/10
 **/

//id	bigint	21	0	0	0	-1	0									0	0	0	0	-1	0	0
//bid	bigint	21	0	-1	0	0	0									0	0	0	0	0	0	0
//wid	bigint	21	0	-1	0	0	0									0	0	0	0	0	0	0
@RestController
@RequestMapping(value = "/test")
public class RandomGen {

    @Autowired
    private WBookWordMapper wBookWordMapper;

    @GetMapping("/BLW")
    public void book_link_word() {
            int[] AllLines = new int[]{3000, 1000, 2500, 3000, 2000, 2500, 2400, 1000, 1000, 1000 };
            int length = 0;
            for(int i = 0; i < AllLines.length; i++){
                int count = AllLines[i];
                int max = 10492;
                Set<Long> set = new HashSet<>();
                Random random = new Random();
                while(count > 0){
                    int t = random.nextInt(max) + 1;
                    if(set.contains(t)){
                        continue;
                    }else{
                        set.add((long)t);
                        count--;
                    }
                }

                System.out.println("最后一次的set大小 " + set.size());
                for (Iterator it = set.iterator(); it.hasNext(); ) {
                    WBookWord wBookWord = new WBookWord();
                    wBookWord.setWid((long)it.next());
                    wBookWord.setBid((long)i + 1);
                    wBookWordMapper.insertSelective(wBookWord);
                    //System.out.println(wBookWord.getId());
                    //  System.out.println(it.next());
                }
                length = length + set.size();
                System.out.println("length大小 " + length);
                System.out.println("完成第 " + i + " 波的数据");
            }
//            int count = 1000;
//            int max = 23631;
//            Set<Long> set = new HashSet<>();
//            Random random = new Random();
//            while(count > 0){
//                int i = random.nextInt(max) + 1;
//                if(set.contains(i) || i == 19){
//                    continue;
//                }else{
//                    set.add((long)i);
//                    count--;
//                }
//            }
//
//            System.out.println(set.size());
//            for (Iterator it = set.iterator(); it.hasNext(); ) {
//                WBookWord wBookWord = new WBookWord();
//                wBookWord.setWid((long)it.next());
//                wBookWord.setBid((long)10);
//                wBookWordMapper.insertSelective(wBookWord);
//                System.out.println(wBookWord.getId());
//              //  System.out.println(it.next());
//            }
//            System.out.println("完成");
        }

}
