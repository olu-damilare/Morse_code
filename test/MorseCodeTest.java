

import morseCode.MorseCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeTest {
    MorseCode morseCode;

    @BeforeEach
    void setup() {
        morseCode = new MorseCode();
    }

    @AfterEach
    void tearDown() {
        morseCode = null;
    }

    @Test
    void testToWriteAMorseCodeCharacter(){
        assertEquals(".-", morseCode.encode("A"));
        assertEquals("-..", morseCode.encode("d"));
        assertEquals("   ", morseCode.encode(" "));
        assertEquals("-----", morseCode.encode("0"));
        assertEquals("---..", morseCode.encode("8"));
    }

    @Test
    void testToWriteAMorseCodeWord(){
        assertEquals(".- -- .- .-.. .-", morseCode.encode("Amala"));
       assertEquals("-.. .. . --. ---", morseCode.encode("Diego"));
    }

    @Test
    void testToWriteAMorseCodePhrase(){
        assertEquals("- .... .. ...   .. ...   .-   -... --- -.--", morseCode.encode("This is a boy"));
        assertEquals("...-- ....-   .-.. .. .- --   ... - .-. . . -", morseCode.encode("34 Liam street"));
    }

    @Test
    void testToDecodeMorseCodeCharacter(){
        assertEquals("A", morseCode.decodeChar(".-"));
        assertEquals("D", morseCode.decodeChar("-.."));
        assertEquals(" ", morseCode.decodeChar("   "));
        assertEquals("0", morseCode.decodeChar("-----"));
        assertEquals("8", morseCode.decodeChar("---.."));
    }

    @Test
    void testToDecodeMorseCodeWord(){
        assertEquals("AMALA", morseCode.decodeWord(".- -- .- .-.. .-"));
        assertEquals("DIEGO", morseCode.decodeWord("-.. .. . --. ---"));
    }

    @Test
    void testToDecodeMorseCodePhrase(){
        assertEquals("THIS IS A BOY", morseCode.decode("- .... .. ...   .. ...   .-   -... --- -.--"));
        assertEquals("34 LIAM STREET", morseCode.decode("...-- ....-   .-.. .. .- --   ... - .-. . . -"));
    }

}
