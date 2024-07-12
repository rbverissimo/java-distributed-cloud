package distributed.systems;

import distributed.systems.algorithmns.LeaderElection;

public class Main {
    public static void main(String[] args) {
        LeaderElection leaderElection = new LeaderElection();
        leaderElection.connectToZookeeper();
    }
}