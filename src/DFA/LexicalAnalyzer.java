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
            if (dfa.getCurrentState() == 0 && c == ' ') {
                dfa.reset();
            }
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
            if (dfa.getCurrentState() == 0 || dfa.getCurrentState() == 28) {
                dfa.mulOperator(c);
            }
            if (Arrays.asList(andState).contains(dfa.getCurrentState())) {
                dfa.and(c);
            }
            if (Arrays.asList(orState).contains(dfa.getCurrentState())) {
                dfa.or(c);
            }
            if (Arrays.asList(notState).contains(dfa.getCurrentState())) {
                dfa.not(c);
            }
            if (Arrays.asList(relOpState).contains(dfa.getCurrentState())) {
                dfa.relOperator(c);
            }
            if (dfa.getCurrentState() == 0) {
                dfa.error(c);
            }
        }
    }
}
