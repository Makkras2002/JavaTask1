package fileOperations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputer {
    private static Logger logger = LogManager.getLogger();
    private final String FILEPATH = "source.txt";
    public void putNumberIntoFile(String number) throws IOException {
        FileWriter fileWriter = new FileWriter(FILEPATH,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
