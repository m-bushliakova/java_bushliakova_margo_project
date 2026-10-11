package com.example.arrays.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.exception.ArrayProcessingException;
import com.example.arrays.factory.ArrayFactory;
import com.example.arrays.factory.ArrayWrapperFactory;
import com.example.arrays.parser.ArrayLineParser;
import com.example.arrays.parser.impl.ArrayLineParserImpl;
import com.example.arrays.service.impl.ArrayFileReaderServiceImpl;
import com.example.arrays.validator.ArrayLineValidator;
import com.example.arrays.validator.impl.ArrayLineValidatorImpl;

class ArrayFileReaderServiceImplTest {

    private static final String VALID_CONTENT = """
            1; 2; 3
            5 10 15 20
            """;

    private static final String MIXED_CONTENT = """
            1; 2; 3
            1, 2, x3, 6..5, 77

            11- 2 - 42
            5 10 15 20
            """;

    private static final String EMPTY_FILE = "";

    private static final int EXPECTED_VALID_ARRAYS = 2;
    private static final int EXPECTED_MIXED_ARRAYS = 3;

    private ArrayFileReaderService service;

    @BeforeEach
    void setUp() {
        ArrayLineValidator validator = new ArrayLineValidatorImpl();
        ArrayLineParser parser = new ArrayLineParserImpl();
        ArrayFactory factory = new ArrayWrapperFactory();
        service = new ArrayFileReaderServiceImpl(validator, parser, factory);
    }

    @Test
    void readIntegerArraysShouldReturnAllValidArrays(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("valid.txt");
        Files.writeString(file, VALID_CONTENT);

        List<ArrayWrapper<Integer>> actual = service.readIntegerArrays(file.toString());

        assertEquals(EXPECTED_VALID_ARRAYS, actual.size());
    }

    @Test
    void readIntegerArraysShouldSkipInvalidAndEmptyLines(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("mixed.txt");
        Files.writeString(file, MIXED_CONTENT);

        List<ArrayWrapper<Integer>> actual = service.readIntegerArrays(file.toString());

        assertEquals(EXPECTED_MIXED_ARRAYS, actual.size());
    }

    @Test
    void readIntegerArraysShouldReturnEmptyListForEmptyFile(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("empty.txt");
        Files.writeString(file, EMPTY_FILE);

        List<ArrayWrapper<Integer>> actual = service.readIntegerArrays(file.toString());

        assertTrue(actual.isEmpty());
    }

    @Test
    void readIntegerArraysShouldThrowWhenFileDoesNotExist(@TempDir Path tempDir) {
        Path missingFile = tempDir.resolve("does-not-exist.txt");

        assertThrows(
                ArrayProcessingException.class,
                () -> service.readIntegerArrays(missingFile.toString())
        );
    }

    @Test
    void readIntegerArraysShouldParseCorrectValues(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("one.txt");
        Files.writeString(file, "1; 2; 3");

        List<ArrayWrapper<Integer>> actual = service.readIntegerArrays(file.toString());

        assertEquals(1, actual.size());
        assertArrayEquals(new Integer[]{1, 2, 3}, actual.get(0).getElements());
    }
}