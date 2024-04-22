package id.aldi.countwords.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void testReadFile() {
        String content = fileReader.readFile("D:\\personal projects\\csg\\count-words\\src\\main\\resources\\input.txt");
        assertTrue(content.length()>0);
    }

    @Test
    void testReadFileNotFound() {
        String content = fileReader.readFile("D:\\personal projects\\csg\\count-words\\src\\main\\resources\\notfound.txt");
        assertEquals("",content);
    }
}