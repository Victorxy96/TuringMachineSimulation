/**
 * Transition class
 * @Author Meng Wang
 */
public class Transition {
    public static final int RIGHT = 1;
    public static final int LEFT = -1;

    private char oldChar;
    private char newChar;
    private int movement;
    private int state;

    /**
     * Constructor
     * @param oldChar the old character on the tape
     * @param newChar new character to replace the old one
     * @param movement head's movement direction
     * @param state new state
     */
    public Transition(char oldChar, char newChar, int movement, int state) {
        this.oldChar = oldChar;
        this.newChar = newChar;
        this.movement = movement;
        this.state = state;
    }

    public char getOldChar() {
        return oldChar;
    }


    public char getNewChar() {
        return newChar;
    }


    public int getMovement() {
        return movement;
    }


    public int getState() {
        return state;
    }

}
