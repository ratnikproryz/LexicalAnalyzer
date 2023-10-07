package DFA;

import Lexical.Analyze;

import java.io.BufferedReader;
import java.util.Arrays;

public class LexicalAnalyzer implements Token, Analyze {
    private DFA dfa;

    public LexicalAnalyzer() {
    }

    public LexicalAnalyzer(DFA dfa) {
        this.dfa = dfa;
    }


    public void analyze(String str) {
        for (char c : str.toCharArray()) {
            if (dfa.getCurrentState() == 0 || dfa.getCurrentState() == 1) {
                dfa.identifier(c);
            }
            if (Arrays.asList(numberState).contains(dfa.getCurrentState())) {
                dfa.number(c);
            }
            if (dfa.getCurrentState() == 0 && (c == ';' || dfa.isBracket(c))) {
                System.out.println(c + " : " + c);
            }
            if (dfa.getCurrentState() == 0 || dfa.getCurrentState() == 10) {
                dfa.addOperator(c);
            }

            if (dfa.getCurrentState() == 0 || dfa.getCurrentState() == 26) {

            }
        }
//        dfa.identifier(str);
    }

    public void result() {

    }

}
