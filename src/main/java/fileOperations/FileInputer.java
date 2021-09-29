package fileOperations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputer {
    private static Logger logger = LogManager.getLogger();
    public void putNumberIntoFile(String number,String filepath) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath,true);
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
