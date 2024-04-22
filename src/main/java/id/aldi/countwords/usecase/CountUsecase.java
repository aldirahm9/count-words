package id.aldi.countwords.usecase;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CountUsecase {

    /**
     *
     * @param wordsList the List of words to be checked
     * @param prefixesString the prefix list in a comma-separated string
     * @return the number of words that start with the prefix
     */
    public int numberOfWordsWithPrefix(List<String> wordsList, String prefixesString) {
        Set<String> prefixList = Arrays.stream(prefixesString.split(",")).collect(Collectors.toSet());
        int numberOfWordsWithPrefix = 0;

        log.info("[numberOfWordsWithPrefix][Prefix : {}][Words : {}]",prefixList,wordsList);

        for(String word : wordsList) {
            for(String prefix : prefixList) {
                if(word.startsWith(prefix)) {
                    numberOfWordsWithPrefix++;
                }
            }
        }

        log.info("[numberOfWordsWithPrefix][Result : {}]",numberOfWordsWithPrefix);

        return numberOfWordsWithPrefix;
    }

    /**
     *
     * @param wordsList the List of words to be checked
     * @param n the minimum length (exclusive)
     * @return the number of words longer than n
     */
    public List<String> wordsLongerThanN(List<String> wordsList, int n) {
        List<String> curatedWords = new ArrayList<>();

        log.info("[wordsLongerThanN][N : {}][Words : {}]",n,wordsList);

        for(String word : wordsList) {
            if(word.length() > n) {
                curatedWords.add(word);
            }
        }

        log.info("[wordsLongerThanN][Result : {}]",curatedWords);

        return curatedWords;
    }
}
