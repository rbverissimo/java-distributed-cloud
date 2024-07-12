package distributed.systems.algorithmns;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class LeaderElection implements Watcher {

    private final String ZOOKEEPER_ADDRESS = "localhost:2128";
    private final int SESSION_TIMEOUT = 3000;
    ZooKeeper zookeper;

    public void connectToZookeeper(){
        try {
            this.zookeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getType()){
            case None:
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    System.out.println("Successfully connected to Zookeeper");
                }
        }
    }
}
