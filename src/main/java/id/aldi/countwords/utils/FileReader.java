package id.aldi.countwords.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
public class FileReader {

    /**
     *
     * @param pathToFile full path to the txt file
     * @return the string content of the file
     */
    public String readFile(String pathToFile) {
        StringBuilder strBuilder = new StringBuilder();

        try {
            Scanner sc = new Scanner(new File(pathToFile));
            while(sc.hasNext()) {
                strBuilder.append(sc.nextLine());
                strBuilder.append(" ");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            log.error("File input.txt in resources does not exists!");
        }


        return strBuilder.toString();
    }
}
