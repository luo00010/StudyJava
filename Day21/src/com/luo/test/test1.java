package com.luo.test;

import org.junit.Test;

/**
 * @author luozstart
 * @create 2022-11-13 16:27
 */
public class test1 {
    @Test
    public void test2(){
        String s1 = "abc";
        String s2 = s1;
        String s3 = s1.intern();
        System.out.println(s1 == s2);
        System.out.println(s3==s2);
        StringBuffer s4 = new StringBuffer("nc");
    }
}
