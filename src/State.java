import java.util.HashMap;

/**
 * State class
 */
public class State {
    private int stateId;
    private HashMap<Character, Transition> transitions;

    /**
     * Constructor
     * @param stateId the id of this state
     */
    public State(int stateId) {
        this.stateId = stateId;
        transitions = new HashMap<>();
    }

    /**
     * Add new transition to this state
     * @param ts new transition
     */
    public void addTransition(Transition ts) {
        transitions.put(ts.getOldChar(), ts);
    }

    /**
     * Get transition based on the character on tape.
     * @param oldChar character the head is pointing to
     * @return corresponding transition
     */
    public Transition getTransition(char oldChar) {
        return transitions.get(oldChar);
    }
}
