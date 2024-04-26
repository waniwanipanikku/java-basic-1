import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class u {
    private static final int LINES_PER_FILE = 100;  // 分割する行数

    public static void main(String[] args) {
        List<String> data = Arrays.asList(
            "Apple", "Banana", "Cherry", "Date", "Elderberry",
            "Fig", "Grape", "Honeydew", "Ilama", "Jackfruit",
            // このリストは続きます...
        );

        try {
            splitListIntoCSV(data, LINES_PER_FILE);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }

    public static void splitListIntoCSV(List<String> data, int linesPerFile) throws IOException {
        int fileCount = 0;
        for (int start = 0; start < data.size(); start += linesPerFile) {
            int end = Math.min(start + linesPerFile, data.size());
            List<String> sublist = data.subList(start, end);
            String filename = "output_" + (++fileCount) + ".csv";
            try (FileWriter writer = new FileWriter(filename)) {
                for (String item : sublist) {
                    writer.write(item + "\n");
                }
            }
            System.out.println("Written " + filename);
        }
    }
}