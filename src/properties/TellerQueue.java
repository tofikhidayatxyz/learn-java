package properties;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class TellerQueue {
    protected Integer maxQueueInList = 10;
    private Deque<String> queues = new ArrayDeque<>();

    public ArrayList<ArrayList<String>> showAll() {
        Integer currentIndex = 0;
        Integer lastIndex = -1;

        ArrayList<ArrayList<String>> listQueue = new ArrayList<ArrayList<String>>();

        for(String queue : queues) {
            lastIndex = currentIndex % maxQueueInList == 0 ? lastIndex + 1 : lastIndex;
            try {
                listQueue.get(lastIndex);
            } catch(Exception e) {
                listQueue.add(new ArrayList<String>());
            }
            listQueue.get(lastIndex).add(queue);
            currentIndex++;
        }

        return listQueue;
    }

    public void addQueue(String name) {
        this.queues.add(name);
    }

    public void removeQueue() {
        this.queues.removeFirst();
    }

    public void removeQueue(String keyword) {
        this.queues.removeIf((String key) -> key.equalsIgnoreCase(keyword));
    }

    public void removeAll() {
        this.queues.removeAll(this.queues);
    }

}
