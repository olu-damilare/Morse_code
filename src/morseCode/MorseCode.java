package morseCode;

public class MorseCode {

    private final char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final String[] alphabetCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                                "-.--", "--.."};
    private final String[] digitCodes = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};
    private final int[] digits = {0,1,2,3,4,5,6,7,8,9};

    private String encodeChar(char letter) {
        String code = "";
        for (int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] == Character.toUpperCase(letter)) {
                code = alphabetCodes[i];
                break;
            } else if(Character.isDigit(letter)) {
                int num = Integer.parseInt(Character.toString(letter));
                code = digitCodes[num];
                break;
            } else if(letter == ' ') code = "   ";
        }
        return code;
    }

    public String encode(String word) {
        validateWord(word);
        StringBuilder encodedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
                encodedWord.append(encodeChar(word.charAt(i)));
           if(word.charAt(i) != ' ' && i != word.length() - 1 && word.charAt(i + 1) != ' ')
                 encodedWord.append(' ');
        }
        return encodedWord.toString();
    }

    private void validateWord(String word) {
        if(!word.matches("[\\dA-Za-z\\s]+"))
            throw new IllegalArgumentException("Word(s) should only contain alphanumeric and/or space characters");
    }

    public String decodeChar(String morseCode) {
        StringBuilder decodedWord = new StringBuilder();
        for (int i = 0; i < alphabetCodes.length; i++) {
            if(morseCode.equals(alphabetCodes[i])) {
              return decodedWord.append(alphabets[i]).toString();
            }
            else if (morseCode.equals("   ")) {
               return decodedWord.append(" ").toString();
            }
        }

        return decodeDigit(morseCode);
    }

    private String decodeDigit(String morseCode) {
        StringBuilder decodedWord = new StringBuilder();
        for (int i = 0; i < digitCodes.length; i++) {
            if(morseCode.equals(digitCodes[i])) {
                decodedWord.append(digits[i]);
                break;
            }
        }
        return decodedWord.toString();
    }

    public String decodeWord(String morseCode) {
        StringBuilder decodedWord = new StringBuilder();

        String[] encodedChars = morseCode.split(" ");
        for (String word : encodedChars) {
            decodedWord.append(decodeChar(word));
        }
        return decodedWord.toString();
    }

    public String decode(String morseCode) {
        StringBuilder decodedWords = new StringBuilder();
        String[] encodedWords = morseCode.split("   ");

        for (int i = 0; i < encodedWords.length; i++) {
            if(i == encodedWords.length - 1)
                decodedWords.append(decodeWord(encodedWords[i]));
            else
            decodedWords.append(decodeWord(encodedWords[i])).append(" ");
        }
        return decodedWords.toString();
    }
}
