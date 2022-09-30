package com.raferl.test.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raferlyan
 * @date 2022/9/5 18:38
 **/
public class PageDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("yjc01");
        list.add("yjc02");
        list.add("yjc03");
        list.add("yjc04");
        list.add("yjc05");
        list.add("yjc06");
        list.add("yjc07");

        int pageNumber = 0;

        // size 必须大于0
        int size = 5;
        Pageable able = PageRequest.of(pageNumber, size, Sort.by(Sort.DEFAULT_DIRECTION, "key"));

        Page<String> page = ConvertPageUtil.convertList2PageVO(list, able);
        System.out.println(page.getContent());
    }

}
