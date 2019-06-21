package com.tatelucky.yduts.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 原生zk-api使用
 *
 * @author tangsheng
 * @since 2019-06-19
 */
public class TestZk {
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String connStr = "127.0.0.1:2181";
    private static final Integer timeout = 2000;


    public static void main(String[] args) throws IOException, InterruptedException {

        ZooKeeper zooKeeper = new ZooKeeper(connStr, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    countDownLatch.countDown();
                    System.out.println("连接成功！");
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());

        //zooKeeper.create()

        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭成功");

    }
}
