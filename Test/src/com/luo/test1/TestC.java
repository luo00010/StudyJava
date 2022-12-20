package com.luo.test1;

/**
 * @author luozstart
 * @create 2022-12-19 21:15
 */
public class TestC extends B implements A{
    public static void main(String[] args) {
        new TestC().pX();
    }
    public void pX(){
        System.out.println();
    }
}

interface A{
    int x=0;
}
class  B{
    int x=1;
}