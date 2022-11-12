import com.sun.javafx.sg.prism.web.NGWebView;

import java.util.concurrent.locks.Lock;

/**
 * 复习线程安全的懒汉式
 *
 * @author luozstart
 * @create 2022-11-09 10:41
 */
public class Bank {
    private Bank(){}
    private Bank bank = null;


    public Bank getBank() {
        if (bank==null){
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
