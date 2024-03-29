package tests;

import logic.TetrisProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Constants;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestConstants {

    private String testPath = "test.properties";
    Constants testConstants = Constants.getInstance();

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
    public void testInit() {
        File testFile = new File(testPath);
        testConstants.initConstants(testPath);
        assertTrue(testFile.isFile());
        assertEquals(1, testConstants.getGameSpeed());
    }

    @Test
    public void testExistingInit() {
        try {
            File testFile = new File(testPath);
            TetrisProperties.writeToProperties(3, testPath);
            testConstants.initConstants(testPath);
            assertTrue(testFile.isFile());
            assertEquals(3, testConstants.getGameSpeed());
        } catch (IOException e) {
            fail("IOException: in TestConstants, properties were not read from correctly");
        }
    }

    @Test
    public void testGetSet() {
        File testFile = new File(testPath);
        testConstants.initConstants(testPath);
        assertTrue(testFile.isFile());
        assertEquals(1, testConstants.getGameSpeed());
        testConstants.setGameSpeed(3);
        assertEquals(3, testConstants.getGameSpeed());
    }

    @Test
    public void testFrame() {
        assertTrue(testConstants.UIFrame instanceof JFrame);
    }

    @AfterEach
    public void deleteTestFile2() {
        deleteTestFile();
    }

}
