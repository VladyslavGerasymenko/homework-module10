package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneReader {

    public static void main(String[] args) {
        String fileName = "src/task1/file.txt";

        String regex = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile(regex);
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
