package id.aldi.countwords.usecase;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountUsecaseTest {

    CountUsecase countUsecase;

    List<String> stringList;



    @BeforeEach
    void setUp() {
        countUsecase = new CountUsecase();
        stringList = new ArrayList<>();
        stringList.add("my");
        stringList.add("name");
        stringList.add("is");
        stringList.add("Aldi");
    }

    @ParameterizedTest
    @CsvSource(value = {"A:1", "na:1", "M,N,I,a:0"},delimiter = ':')
    void testNumberOfWordsWithPrefix(String prefix, String ans) {
        int count = countUsecase.numberOfWordsWithPrefix(stringList,prefix);
        assertEquals(Integer.parseInt(ans),count);
    }


    @Test
    void testNumberOfWordsWithPrefixEmpty() {
        int count = countUsecase.numberOfWordsWithPrefix(stringList,"");
        assertEquals(4,count);
    }

    @Test
    void testNumberOfWordsWithPrefixEmptyList() {
        List<String> stringList = new ArrayList<>();
        int count = countUsecase.numberOfWordsWithPrefix(stringList,"a,b,c,d");
        assertEquals(0,count);
    }

    @Test
    void testWordsWithLengthMoreThan3() {
        List<String> expected = new ArrayList<>();
        expected.add("name");
        expected.add("Aldi");

        List<String> actual = countUsecase.wordsLongerThanN(stringList,3);
        assertEquals(expected,actual);
    }

    @Test
    void testWordsWithLengthMoreThan4() {
        List<String> expected = new ArrayList<>();

        List<String> actual = countUsecase.wordsLongerThanN(stringList,4);
        assertEquals(expected,actual);
    }

    @Test
    void testWordsWithLengthMoreThan0() {
        List<String> expected = new ArrayList<>();
        expected.add("my");
        expected.add("name");
        expected.add("is");
        expected.add("Aldi");

        List<String> actual = countUsecase.wordsLongerThanN(stringList,0);
        assertEquals(expected,actual);
    }

    @Test
    void testWordsWithLengthEmptyList() {
        List<String> stringList = new ArrayList<>();

        List<String> expected = new ArrayList<>();

        List<String> actual = countUsecase.wordsLongerThanN(stringList,13);
        assertEquals(expected,actual);
    }
}