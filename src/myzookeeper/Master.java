package myzookeeper;

/**
 * Created by zhangyi on 2/25/15.
 */
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.proto.WatcherEvent;

import java.io.IOException;


public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    private void startZK() {
        try {
            zk = new ZooKeeper(hostPort, 15000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public static void main(String args[]) throws Exception {
        Master m = new Master(args[0]);

        m.startZK();

        Thread.sleep(60000);
    }

}
