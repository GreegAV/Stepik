package Stepik;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputStreamToString {

    public static void main(String[] args) {
        Charset charset = StandardCharsets.US_ASCII;
        try (InputStream inputStream = new ByteArrayInputStream(new byte[] {48, 49, 50, 51, 13, 10})) {
            String textForOut = readAsString(inputStream, charset);
            System.out.println(textForOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // Сделать метод паблик и сдавать только текст метода
        int resultsRead, deltaStepOfArray = 512, beginIndex = 0, endIndex = deltaStepOfArray;
        byte[] bytes = new byte[endIndex], bytes1;
        do {
            resultsRead = inputStream.read();
            if (resultsRead > -1) {
                bytes[beginIndex] = (byte) resultsRead;
                beginIndex++;
                if (beginIndex == endIndex) {
                    endIndex += deltaStepOfArray;
                    bytes1 = Arrays.copyOf(bytes,endIndex);
                    bytes = bytes1;
                }
            }
        } while (resultsRead > -1);

        bytes1 = Arrays.copyOf(bytes, beginIndex);

        return new String(bytes1, charset);
    }
}