package Stepik;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by avg-m on 28/06/2017.
 */
public class checkSumOfStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
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