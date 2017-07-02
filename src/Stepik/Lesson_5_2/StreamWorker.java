package Stepik.Lesson_5_2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamWorker {

    public static void main(final String[] args) {Serializable

        final byte[] inputArray = {0x33, 0x45, 0x01};
        int checkSum = 0;

        try (InputStream inputStream = new ByteArrayInputStream(inputArray)){
            checkSum = checkSumOfStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(checkSum);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checkSum = 0, readsResult = -1;
        byte[] readedBytes = new byte[1024];

        try {
            do {readsResult = inputStream.read(readedBytes);
                if (readsResult >= 0) {
                    for (int i = 0; i < readsResult; i++) {
                        checkSum = Integer.rotateLeft(checkSum,1)^Byte.toUnsignedInt(readedBytes[i]);
                    }
                }
            } while (readsResult >= 0);
        } catch (IOException e) {
            throw e;
        }

        return checkSum;
    }

}