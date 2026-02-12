/*
* Este código pertence a @fernandopedridodev, para o seu uso ou modificación
* contactade en fernandopedridodev@gmail.com.
 */
package hangman;

import java.util.ArrayList;

/**
 *
 * @author fernandopedridodev <fernandopedridodev@gmail.com>
 */
public class HangMan {

    public static int MAX_FAILS = 6;
    public HiddenWord hiddenWord;
    public char[] fails;

    public HangMan(HiddenWord hiddenWord, char[] fails) {
        this.hiddenWord = hiddenWord;
        this.fails = fails;
    }

    public ArrayList<Character> getFails() {

        return null;

    }

    public String getStringFails() {

        return null;

    }

    public String showHiddenWord() {

        return null;

    }

    public String showFullWord() {

        return null;

    }

    public void tryChar(char c) {

    }

    public boolean isGameOver() {

        return false;

    }

    public boolean maxFailsExceeded() {

        return false;

    }
}
