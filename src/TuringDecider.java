/**
 * This program is used for performing turing decider
 */
public class TuringDecider {
    public static void main( String args[]) {
        Turing machine1 = new Turing(9);    // A NINE state machine
        //Initial state
        State s0 = new State(0);
        State s1 = new State(1);
        State s2 = new State(2);
        State s3 = new State(3);
        State s4 = new State(4);
        //Accept state
        State s5 = new State(5);
        //Reject state
        State s6 = new State(6);
        //For formatting the output
        State s7 = new State(7);

        //If the head is H, than proceed to state 1.
        s0.addTransition(new Transition('H','H',Transition.RIGHT,1));
        //If the head is N, than reject
        s0.addTransition(new Transition('N','0',Transition.RIGHT,8));

        s1.addTransition(new Transition('0','B',Transition.RIGHT,2));
        s1.addTransition(new Transition('1','B',Transition.LEFT,6));
        s1.addTransition(new Transition('B','B',Transition.LEFT,5));
        s1.addTransition(new Transition('H', 'H', Transition.LEFT, 6));

        s2.addTransition(new Transition('1','1',Transition.RIGHT,2));
        s2.addTransition(new Transition('0','0',Transition.RIGHT,2));
        s2.addTransition(new Transition('B','B',Transition.LEFT,3));

        s3.addTransition(new Transition('0','B',Transition.LEFT,6));
        s3.addTransition(new Transition('1','B',Transition.LEFT,4));
        s3.addTransition(new Transition('B','B',Transition.LEFT,6));

        s4.addTransition(new Transition('1','1',Transition.LEFT,4));
        s4.addTransition(new Transition('0','0',Transition.LEFT,4));
        s4.addTransition(new Transition('B','B',Transition.RIGHT,1));

        s5.addTransition(new Transition('B','B',Transition.LEFT,5));
        s5.addTransition(new Transition('H','1',Transition.RIGHT,8));

        s6.addTransition(new Transition('B','B',Transition.LEFT,7));
        s6.addTransition(new Transition('0','B',Transition.RIGHT,6));
        s6.addTransition(new Transition('1','B',Transition.RIGHT,6));
        s6.addTransition(new Transition('H','0',Transition.RIGHT,8));

        s7.addTransition(new Transition('0','B',Transition.LEFT,7));
        s7.addTransition(new Transition('1','B',Transition.LEFT,7));
        s7.addTransition(new Transition('B','B',Transition.LEFT,7));
        s7.addTransition(new Transition('H','0',Transition.LEFT,8));

        machine1.addState(s0);                 // Add the state to the machine
        machine1.addState(s1);
        machine1.addState(s2);
        machine1.addState(s3);
        machine1.addState(s4);
        machine1.addState(s5);
        machine1.addState(s6);
        machine1.addState(s7);


        // Get input
        if(args.length != 1) {
            System.out.println("Wrong input!");
            System.exit(0);
        }
        String inTape = args[0];
        //String inTape = "";
        //System.out.println(inTape);

        String outTape;
        if(inTape.length() == 0) {
            //For handling the special case "", if the string is empty, then set the head to "N"
            outTape = machine1.execute("N" + inTape);
        } else {
            //If the string is not empty, then set the head to "H", head is used as a bound when formating the output.
            outTape = machine1.execute("H" + inTape);
        }

        System.out.println(outTape);  // Show the machine’s output
    }
}
