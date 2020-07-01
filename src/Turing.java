/**
 * This program simulates a turing machine.
 * @Author Meng Wang
 */
public class Turing {
    private char[] tape;
    private State[] states;
    private int head;
    private int stateCount;
    private int haltState;

    /**
     * Constructor
     * @param numState number of states of this machine
     */
    public Turing(int numState) {
        states = new State[numState];
        tape = new char[100];
        head = 0;
        stateCount = 0;
        haltState = states.length - 1;
    }

    /**
     * Add state to a machine
     * @param state state to be added
     */
    public void addState(State state) {
        states[stateCount] = state;
        stateCount++;
    }

    /**
     * Process the input tape based on states
     * @param inTape input tape
     * @return result
     */
    public String execute(String inTape) {
        int currState = 0;
        try {
            //Convert string to char array
            convert(inTape);
            if(tape[0] == 'B') {
                currState = haltState;

            }
            //Run the program until reaches the haltstate
            while(currState != haltState) {
                //The char the head is pointing to
                char tapeChar = tape[head];
                Transition currTrans = states[currState].getTransition(tapeChar);
                int movement = currTrans.getMovement();
                tape[head] = currTrans.getNewChar();
                head = head + movement;
                currState = currTrans.getState();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(tape);
    }

    /**
     * Convert string to char array
     * @param inTape input tape
     * @throws Exception
     */
    private void convert(String inTape) throws Exception {
        if(inTape.length() > 100) {
            throw new Exception("Length should be less than 100");
        } else {
            char[] tapeChar = inTape.toCharArray();
            System.arraycopy(tapeChar, 0 , tape, 0, tapeChar.length);
            for(int i = tapeChar.length; i < 100; i++) {
                tape[i] = 'B';
            }
        }
    }
}
