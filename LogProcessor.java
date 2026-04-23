import java.io.*;
import java.util.*;

public class LogProcessor implements Runnable {
    String filePath;
    ActivityAggregator aggregator;

    public LogProcessor(String filePath, ActivityAggregator aggregator) {
        this.filePath = filePath;
        this.aggregator = aggregator;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    LogEntry entry = new LogEntry(parts[0], parts[1], parts[2]);
                    aggregator.addEntry(entry);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }
}
