package com.luo.java2;

import java.io.Serializable;

/**
 * @author luozstart
 * @create 2023-01-06 22:19
 */
public class Creatue<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
