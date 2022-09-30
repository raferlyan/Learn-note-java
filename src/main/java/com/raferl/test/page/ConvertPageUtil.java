package com.raferl.test.page;

import com.google.common.collect.Lists;
import org.springframework.data.domain.*;
import org.springframework.util.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

public class ConvertPageUtil {
    public static <T> Page<T> convertList2PageVO(List<T> list, Pageable pageable) {
        if (CollectionUtils.isEmpty(list)) {
            return new PageImpl<>(new ArrayList<>(0), pageable, 0);
        }
        int size = pageable.getPageSize();
        if (size != 20 && size >= list.size()) {
            size = list.size();
        }
        List<List<T>> partition = Lists.partition(list, size);
        int pageNumber = 0;
        if (pageable.getPageNumber() != 0){
            pageNumber = pageable.getPageNumber() - 1;
        }
        Pageable able = PageRequest.of(pageNumber, size, Sort.by(Sort.DEFAULT_DIRECTION, "key"));
        List<T> pageContent = partition.get(pageNumber);
        return new PageImpl<>(pageContent, able, list.size());
    }
}