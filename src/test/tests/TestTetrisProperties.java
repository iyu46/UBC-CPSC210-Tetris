package tests;

import logic.TetrisProperties;
import logic.java.PropertiesMissingException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestTetrisProperties {

    private String testPath = "test.properties";

    @BeforeEach
    public void deleteTestFile() {
        File testFile = new File(testPath);
        if (testFile.isFile()) {
            if (testFile.delete()) {
                System.out.println("Successfully cleared testFile");
            } else {
                System.out.println("Failed to delete testFile");
            }
        }
    }

    @Test
    public void testFirstRead() {
        //TetrisProperties.readFromProperties("fail.txt");
        try {
            TetrisProperties.readFromProperties(testPath);
            fail("exception was not well-implemented");
        } catch (PropertiesMissingException e) {
            //
        }
    }

    @Test
    public void testFirstWrite() {
        TetrisProperties.writeToProperties(5, testPath);
        File testFile = new File(testPath);
        assertTrue(testFile.isFile());
        assertEquals(5, TetrisProperties.readFromProperties(testPath));

    }

    @Test
    public void testMultipleWrite() {
        TetrisProperties.writeToProperties(8, testPath);
        TetrisProperties.writeToProperties(54, testPath);
        TetrisProperties.writeToProperties(5, testPath);
        assertEquals(5, TetrisProperties.readFromProperties(testPath));
    }


    @AfterEach
    public void clearTestFile() {
        deleteTestFile();
    }

}
