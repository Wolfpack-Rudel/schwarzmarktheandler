package eu.wolfpack.schwarzmarkthaendler.utils;

import java.util.UUID;

public class PlayQuests {

    private PlayerQuest pq1;
    private PlayerQuest pq2;
    private PlayerQuest pq3;


    public PlayQuests(PlayerQuest pq1, PlayerQuest pq2, PlayerQuest pq3) {
        this.pq1 = pq1;
        this.pq2 = pq2;
        this.pq3 = pq3;
    }

    public PlayerQuest getPq1() {
        return pq1;
    }

    public void setPq1(PlayerQuest pq1) {
        this.pq1 = pq1;
    }

    public PlayerQuest getPq2() {
        return pq2;
    }

    public void setPq2(PlayerQuest pq2) {
        this.pq2 = pq2;
    }

    public PlayerQuest getPq3() {
        return pq3;
    }

    public void setPq3(PlayerQuest pq3) {
        this.pq3 = pq3;
    }

}
