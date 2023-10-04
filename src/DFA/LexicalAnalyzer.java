package DFA;

import Lexical.Analyze;
import Lexical.Token;

import java.util.Arrays;

public class LexicalAnalyzer implements Token, Analyze {
    public LexicalAnalyzer() {
    }

    public void analyze(char c) {

    }

    public void analyzeV2(char c) {

    }

    public void result() {

    }

    public int checkKeyword(char c) {
        if (true) {

            return 1;
        }
        return 0;
    }

    public int checkIdentifier(char c) {
        if (true) {

            return 2;
        }
        return 0;
    }

    public int checkNum(char c) {
        if (true) {
            return 3;
        }
        return 0;
    }

    public int checkAddOp(char c) {
        if (true) {
            return 4;
        }
        return 0;
    }

    public int checkMulOp(char c) {
        if (true) {
            return 5;
        }
        return 0;
    }

    public int checkRelop(char c) {
        if (true) {
            return 6;
        }
        return 0;
    }

    public int checkOthers(char c) {
        if (true) {
            return 7;
        }
        return 0;
    }
}
