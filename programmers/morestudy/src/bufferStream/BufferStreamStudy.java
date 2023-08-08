package bufferStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferStreamStudy {
    private static final byte[] DLT_SIGNATURE = {0x44, 0x4C, 0x54, 0x01};


    //수정
    public List<DLTLog> readDLTLogs(String filename) throws IOException {
        List<DLTLog> logs = new ArrayList<>();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename))) {
            //TODO : ByteBuffer byteBuffer = ByteBuffer.allocate(LOG_SIZE); // Define LOG_SIZE  사용
            int signatureIndex = 0;
            int b;
            while ((b = bis.read()) != -1) {
                if (b == DLT_SIGNATURE[signatureIndex]) {
                    signatureIndex++;
                    if (signatureIndex == DLT_SIGNATURE.length) {
                        DLTLog log = readLog(bis);
                        if (log != null) {
                            logs.add(log);
                        }
                        signatureIndex = 0; // Reset the signature index to start searching again
                    }
                } else {
                    signatureIndex = 0; // Reset the signature index if the byte doesn't match
                }
            }
        }
        return logs;
    }

    private DLTLog readLog(BufferedInputStream bis) throws IOException {
        // Read the log data after the DLT signature, create and return a DLTLog object
        

        return null;
    }
}
class DLTLog {
    // DLT log data
}
