import java.io.*;
import java.util.*;

public class ReportGenerator {
    public void generateReport(ActivityAggregator aggregator, String outputPath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            bw.write("USER ACTIVITY REPORT\n");

            List<Map.Entry<String, Integer>> list = new ArrayList<>(aggregator.getMap().entrySet());
            list.sort((a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<String, Integer> entry : list) {
                bw.write(entry.getKey() + ": " + entry.getValue() + " actions\n");
            }

            bw.close();
            System.out.println("Report generated at: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing report");
        }
    }
}

