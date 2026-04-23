public class LogEntry {
    String timestamp;
    String userId;
    String action;

    public LogEntry(String timestamp, String userId, String action) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.action = action;
    }
}
