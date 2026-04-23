import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String directoryPath = "logs";
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in directory");
            return;
        }

        ActivityAggregator aggregator = new ActivityAggregator();
        List<Thread> threads = new ArrayList<>();

        for (File file : files) {
            if (file.isFile()) {
                LogProcessor processor = new LogProcessor(file.getAbsolutePath(), aggregator);
                Thread t = new Thread(processor);
                threads.add(t);
                t.start();
            }
        }

        for (Thread t : threads) {
            t.join();
        }

        ReportGenerator generator = new ReportGenerator();
        generator.generateReport(aggregator, "report.txt");
    }
}

