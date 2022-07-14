package com.basic.study.thread.channel;

/**
 * @author huangquan
 * @date 2022/7/12
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {

       /* WhileQueue<String> queue = new WhileQueue<>();
        new Thread(queue::get).start();
        new Thread(() -> queue.put("1")).start();*/

        WaitNotifyQueue<String> queue = new WaitNotifyQueue<>();

        new Thread(()-> {
            try {
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }




}
