package id.aldi.countwords;

import id.aldi.countwords.config.ApplicationConfig;
import id.aldi.countwords.usecase.CountUsecase;
import id.aldi.countwords.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CountWordsMainApp {

    private static final String FILE_INPUT_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\input.txt";


    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        CountUsecase countUsecase = new CountUsecase();

        log.info("[READING INPUT FILE][{}]",FILE_INPUT_PATH);
        List<String> wordsList = Arrays.stream(fileReader.readFile(FILE_INPUT_PATH).split(" ")).toList();

        int count = countUsecase.numberOfWordsWithPrefix(wordsList,ApplicationConfig.properties.getProperty("application.business.rules.prefix"));
        log.info(String.valueOf(count));

        List<String> words = countUsecase.wordsLongerThanN(wordsList,Integer.parseInt(ApplicationConfig.properties.getProperty("application.business.rules.min.char")));
        log.info(words.toString());
    }
}