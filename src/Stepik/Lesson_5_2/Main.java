package Stepik.Lesson_5_2;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        int currentResultsInput = -1, prevResultsInput = 0;
        try (InputStream inputStream = System.in) {
            do {
                prevResultsInput = currentResultsInput;
                currentResultsInput = inputStream.read();
                if (prevResultsInput == 13 & currentResultsInput == 10) {
                    continue;
                } else if (prevResultsInput >= 0) {
                    System.out.write(prevResultsInput);
                    System.out.flush();
                }
            } while (currentResultsInput != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}