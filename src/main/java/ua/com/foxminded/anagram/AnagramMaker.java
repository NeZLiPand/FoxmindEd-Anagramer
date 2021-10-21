package ua.com.foxminded.anagram;

public class AnagramMaker {

    public static final String SPACE_DELIMITER = " ";

    public static String makeAnagram(String text) {
        validateText(text);
        String[] arrayWords = text.trim().split(SPACE_DELIMITER);
        StringBuilder backwardsString = new StringBuilder();
        for (int i = 0; i < arrayWords.length; i++) {
            backwardsString.append(reverseWord(arrayWords[i]));
            if (i + 1 < arrayWords.length) {
                backwardsString.append(" ");
            }
        }
        return backwardsString.toString();
    }
    
    private static String reverseWord(String word) {
        char[] arrayCharacters = word.toCharArray();
        int indexLeftToRight = 0;
        int indexRightToLeft = (word.length() - 1);
        while (indexLeftToRight <= indexRightToLeft) {
            if (Character.isLetter(arrayCharacters[indexLeftToRight])) {
                if (Character.isLetter(arrayCharacters[indexRightToLeft])) {
                    swapElements(arrayCharacters, indexLeftToRight, indexRightToLeft);
                    indexLeftToRight++;
                }
                indexRightToLeft--;
            } else {
                indexLeftToRight++;
            }
        }
        return String.valueOf(arrayCharacters);
    }
    
    private static void validateText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }
        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text contains only tabs or/and spaces");
        }
    }
    
    private static void swapElements (char[] word, int indexLeftToRight, int indexRightToLeft) {
        char characterCopy = word[indexLeftToRight];
        word[indexLeftToRight] = word[indexRightToLeft];
        word[indexRightToLeft] = characterCopy;
    }
}
