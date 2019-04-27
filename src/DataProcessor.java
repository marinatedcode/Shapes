import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcessor {

    public static void main(String[] args) {
        String fileName = "grades.txt";
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toUpperCase();
                switch (line) {
                    case "A":
                        a++;
                        break;
                    case "B":
                        b++;
                        break;
                    case "C":
                        c++;
                        break;
                    case "D":
                        d++;
                        break;
                    default:
                        //do nothing
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> output = new ArrayList<>();
        output.add("Answer Report");
        output.add("A - " + a);
        output.add("B - " + b);
        output.add("C - " + c);
        output.add("D - " + d);

        Charset utf8 = StandardCharsets.UTF_8;

        try {
            Files.write(Paths.get("output.txt"), output, utf8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
