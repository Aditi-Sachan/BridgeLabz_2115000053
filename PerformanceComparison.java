import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String inputString = "hello";

        long startTime1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(inputString);
        }
        long endTime1 = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime1 - startTime1) / 1_000_000 + " ms");

        long startTime2 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(inputString);
        }
        long endTime2 = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime2 - startTime2) / 1_000_000 + " ms");

        String filePath = "LinkedList.txt";
        measureFileReadingTime(new FileReader(filePath), "FileReader");
        measureFileReadingTime(new InputStreamReader(new FileInputStream(filePath)), "InputStreamReader");
    }

    private static void measureFileReadingTime(Reader reader, String readerType) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println(readerType + " Time: " + (endTime - startTime) / 1_000_000 + " ms, Word Count: " + wordCount);
    }
}
