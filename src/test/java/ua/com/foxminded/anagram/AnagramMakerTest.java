package ua.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class AnagramMakerTest {

    @Test
    void testMakeAnagram_shouldThrowException_whenInputArgumentNULL() {
        assertThrows(IllegalArgumentException.class, () -> AnagramMaker.makeAnagram(null));
    }

    @Test
    void testMakeAnagram_shouldThrowException_whenInputEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> AnagramMaker.makeAnagram(""));
    }

    @Test
    void testMakeAnagram_shouldThrowException_TextСontainsOnlySpacesOrAndTabs() {
        assertThrows(IllegalArgumentException.class, () -> AnagramMaker.makeAnagram(AnagramMaker.SPACE_DELIMITER
                + AnagramMaker.SPACE_DELIMITER + AnagramMaker.SPACE_DELIMITER + AnagramMaker.SPACE_DELIMITER));
    }

    @Test
    void testMakeAnagram_shouldReturnSameString_whenTextContainsOneSymbol() {
        assertEquals("1", AnagramMaker.makeAnagram("1"));
    }

    @Test
    void testMakeAnagram_shouldReturnSameString_whenTextContainsSeveralSymbol() {
        assertEquals("1234567890", AnagramMaker.makeAnagram("1234567890"));
    }

    @Test
    void testMakeAnagram_shouldReturnSameString_whenTextContainsMultipleSymbol() {
        assertEquals("1.234567890", AnagramMaker.makeAnagram("1.234567890"));
    }

    @Test
    void testMakeAnagram_shouldReturnSameString_whenInputLetter() {
        assertEquals("a", AnagramMaker.makeAnagram("a"));
    }

    @Test
    void testMakeAnagram_shouldReverseWord_whenInputWordFromOddQuantityLetters() {
        assertEquals("cba", AnagramMaker.makeAnagram("abc"));
    }

    @Test
    void testMakeAnagram_shouldReverseWord_whenInputWordFromEvenQuantityLetters() {
        assertEquals("dcba", AnagramMaker.makeAnagram("abcd"));
    }

    @Test
    void testMakeAnagram_shouldReverseWord_whenInputSameLettersInDifferentRegisters() {
        assertEquals("AAAaaa", AnagramMaker.makeAnagram("aaaAAA"));
    }

    @Test
    void testMakeAnagram_shouldReverseWord_whenInputDifferentLettersInDifferentRegisters() {
        assertEquals("dcBA", AnagramMaker.makeAnagram("ABcd"));
    }

    @Test
    void testMakeAnagram_shouldReverseWord_whenInputCombinationOfSymbolsAndLettersInDifferentRegisters() {
        assertEquals("123gOoD123yes123456dOoG123", AnagramMaker.makeAnagram("123GoOd123sey123456DoOg123"));
    }

    @Test
    void testMakeAnagram_shouldReverseString_whenInputStringWithWordWithDifferentSymbolsAndWordWithNonLettersSymbols() {
        assertEquals("123gOoD123yes123456dOoG123 1234567890",
                AnagramMaker.makeAnagram("123GoOd123sey123456DoOg123 1234567890"));
    }

    @Test
    void testMakeAnagram_shouldReverseString_whenInputWordsWithDifferentSymbols() {
        assertEquals("123gOoD123yes123456dOoG123 123gOoD123yes123456dOoG123",
                AnagramMaker.makeAnagram("123GoOd123sey123456DoOg123 123GoOd123sey123456DoOg123"));
    }

    @Test
    void testMakeAnagram_shouldReverseString_whenInputWordsHaveSpacesOnBothSides() {
        assertEquals("123gOoD123yes123456dOoG123 123gOoD123yes123456dOoG123",
                AnagramMaker.makeAnagram("   123GoOd123sey123456DoOg123 123GoOd123sey123456DoOg123   "));
    }
}
