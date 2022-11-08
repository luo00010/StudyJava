package com.luo.java3;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author luozstart
 * @create 2022-11-07 16:55
 */
public class BankTest {

}
class Bank implements Runnable{
    private Bank() {
    }
    private static Bank b =null;
    public static  Bank getB(){
        if (b==null) {
            synchronized (Bank.class) {
                if (b == null) {
                    b = new Bank();
                }

            }
        }
        return b;
    }

    @Override
    public void run() {

    }
}