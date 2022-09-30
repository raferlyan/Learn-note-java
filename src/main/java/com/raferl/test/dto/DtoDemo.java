package com.raferl.test.dto;

/**
 * @author raferlyan
 * @date 2022/9/29 08:35
 **/
public class DtoDemo {

    public static void main(String[] args) {
        test01();
    }


    /**
     * 测试获得dto返回值
     */
    public static void test01(){
        TestDto testDto = new TestDto();
        testDto.setOwner("owner");
        System.out.println(testDto.getOwner());
//        System.out.println(testDto.getInfo());
        System.out.println(testDto.getDataDate());

        TempDto tempDto = new TempDto();
        tempDto.setName(null);

        System.out.println(tempDto.getName());
        if(tempDto.getName() == null){
            System.out.println("ke");
        }else if (tempDto.getName().isEmpty()){
            System.out.println("hao");
        }

    }
}
