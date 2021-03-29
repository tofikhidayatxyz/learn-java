package com.property.services;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

import com.property.models.TellerQueue;

public class TellerQueueService {
    private Deque<TellerQueue> tellerQueues = new ArrayDeque<>();
    private Integer maxItemInlist;

    // constructor
    public TellerQueueService(Integer maxItemInlist) {
        this.maxItemInlist = maxItemInlist;
    }

    // get queue then parse to 2d arrad list
    public ArrayList<ArrayList<TellerQueue>> viewAll() {
        Integer lastIndex = -1;
        Integer currentIndex = 0;
        ArrayList<ArrayList<TellerQueue>> queueList = new ArrayList<ArrayList<TellerQueue>>();

        for (TellerQueue tellerQueue : tellerQueues) {
            lastIndex = currentIndex % this.maxItemInlist == 0 ? lastIndex + 1 : lastIndex;
            try {
                queueList.get(lastIndex);
            } catch(Exception e) {
                queueList.add(new ArrayList<TellerQueue>());
            }
            queueList.get(lastIndex).add(tellerQueue);
            currentIndex++;
        }
        return  queueList;
    }

    // get last queue number
    public Integer lastQueueNumber() {
        TellerQueue lastQueue = null;

        try {
            lastQueue = this.tellerQueues.getLast();
        } catch(Exception e) {
            // empty
        }

        if(lastQueue != null) {
            return lastQueue.queueNumber + 1;
        }

        return 1;
    }

    // add new queue
    public void addQueue(String name, Integer queueNumber) {
        this.tellerQueues.add(new TellerQueue(name, queueNumber));
    }

    // remove first queue
    public void remove() {
        this.tellerQueues.removeFirst();
    }

    // remove one queue
    public void remove(String keyword) {
        try {
            this.tellerQueues.removeIf((TellerQueue q) -> (
                            q.name.equalsIgnoreCase(keyword)
                            || q.queueNumber == Integer.parseInt(keyword)));

            System.out.println("Berhasil menghapus data");
        } catch(Exception e) {
            System.out.println("Gagal menghapus data");
        }
    }

    // remove all queues
    public void removeAll() {
        this.tellerQueues.removeAll(this.tellerQueues);
    }


}
