package com.tatelucky.yduts.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 原生zk-api使用
 *
 * @author tangsheng
 * @since 2019-06-19
 */
public class TestZk {
    //闭锁，使用信号量进行阻塞，防止程序还没连接上zk就往下跑，直接报异常
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String connStr = "127.0.0.1:2181";
    private static final Integer timeout = 2000;
    private static final String node = "/test";


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZooKeeper zooKeeper = new ZooKeeper(connStr, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    //连接成功，让阻塞的程序向下执行
                    countDownLatch.countDown();
                    System.out.println("连接成功！");
                }
            }
        });
        //阻塞等待
        countDownLatch.await();
        System.out.println(zooKeeper.getState());


        //创建节点
        /**
         * 参数1：路径
         * 参数2：内容
         * 参数3：节点权限
         * 参数4：节点类型：
         *      PERSISTENT：持久 PERSISTENT_SEQUENTIAL： 持久顺序
         *      EPHEMERAL ：临时 EPHEMERAL_SEQUENTIAL ： 临时顺序
         * 参数5(可选)：注册一个异步回调函数
         * 参数6(可选)：传递给回调的参数
         *
         */
        zooKeeper.create(node, "4".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Thread.sleep(1000);
        // 状态
        Stat stat = new Stat();
        // 2.查看新增后的节点状态
        byte[] bytes = zooKeeper.getData(node, null, stat);
        System.out.println(new String(bytes));

        //创造监听事件
        stat = zooKeeper.exists(node, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType() + "-->" + watchedEvent.getPath());
                //watcher是一次性操作，只能看到setData操作带来的变化，delete操作看不到变化,
                // 所以，要在绑定一次事件，来持续监听
                try {
                    zooKeeper.exists(watchedEvent.getPath(), true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //修改
        zooKeeper.setData(node, "2".getBytes(), stat.getVersion());
        byte[] bytes2 = zooKeeper.getData(node, null, stat);
        System.out.println(new String(bytes2));


        //删除
        zooKeeper.delete(node, stat.getVersion());
        stat = zooKeeper.exists(node, null);
        if (null == stat) {
            System.out.println("现在不存在test节点");
        }
        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭成功");
        System.in.read();


    }
}
