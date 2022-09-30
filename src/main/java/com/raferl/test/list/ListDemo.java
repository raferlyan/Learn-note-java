package com.raferl.test.list;


import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author raferlyan
 * @date 2022/9/9 12:57
 **/
public class ListDemo {
    public static void main(String[] args) {
//        clear();
//        getIntersection();
//        judgeNull();
        test01();
    }



    /**
     * 求两个集合的交集
     * 需要添加commons-collections4依赖
     */
    public static void getIntersection(){
        String[] arrayA = new String[] { "1", "2", "3", "4"};
        String[] arrayB = new String[] { "3", "4", "5", "6" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        System.out.println(CollectionUtils.intersection(listA, listB));

        Collection<String> union = CollectionUtils.union(listA, listB);
        System.out.println("并集："+union);
        //交集
        Collection<String> intersection = CollectionUtils.intersection(listA, listB);
        System.out.println("交集："+intersection);
        //交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(listA, listB);
        System.out.println("交集的补集   ："+disjunction);
        //差集(集合相减)
        Collection<String> subtract = CollectionUtils.subtract(listA, listB);
        System.out.println("差集(集合相减)   ："+subtract);
    }

    /**
     * 清空List
     */
    public static void clear(){
        List<String> list = new ArrayList<>();
        list.add("yy");
        list.add("ye");
        list.add("yye");
        list.add("yy");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }

    /**
     * 判断集合是否为空
     */
    public static void judgeNull(){
        List<String> list = new ArrayList<>();

        System.out.println(list.size());

        System.out.println(list.isEmpty());
    }

    public static void test01(){
        List<String> meterIds = new ArrayList<>();
        meterIds.add("8000000020012784");
        meterIds.add("8000000044483164");
        meterIds.add("8000000044483163");
        meterIds.add("8000000020012783");

        List<String> infos = new ArrayList<>();
        infos.add("8000000020012784");
        infos.add("8000000020012783");

        List<String> collect = infos.stream().filter(meterIds::contains).collect(Collectors.toList());
        System.out.println(collect);

    }

}
