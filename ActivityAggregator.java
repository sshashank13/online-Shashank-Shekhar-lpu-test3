import java.util.concurrent.ConcurrentHashMap;

public class ActivityAggregator {
    ConcurrentHashMap<String, Integer> userActivityMap = new ConcurrentHashMap<>();

    public void addEntry(LogEntry entry) {
        userActivityMap.merge(entry.userId, 1, Integer::sum);
    }

    public ConcurrentHashMap<String, Integer> getMap() {
        return userActivityMap;
    }
}

