package java0.conc0303;

import java.util.concurrent.Exchanger;

import static java.lang.Thread.sleep;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Exchanger11 {

    //声明变量
    private final static int DEFAULT_VALUE = -1;

    public static void main(String[] args) throws InterruptedException {

        //声明交换器
        Exchanger<Integer> exchanger = new Exchanger<>();

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Thread thread = new Thread(()->{
            int result = sum(); //这是得到的返回值
            try {
                Integer exchange = exchanger.exchange(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        //主线程等待交换数据
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" +exchanger.exchange(DEFAULT_VALUE));
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        //main线程阻塞等待交换数据
        // 然后退出main线程
        System.out.println(Thread.currentThread().getName() + "执行完退出...");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

}
