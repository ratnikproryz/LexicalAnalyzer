package DFA;

import java.util.Arrays;

public class DFA implements Token {
    private int currentState = 0;
    private String readed = "";

    public DFA() {
    }


    public DFA(int currentState) {
        this.currentState = currentState;
    }

    public boolean isLetter(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }

    public boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public void identifier(char c) {
        if (isLetter(c)) {
            currentState = 1;
            readed += c;
            return;
        }
        if (currentState == 1 && (isLetter(c) || isDigit(c))) {
            readed += c;
            return;
        }
        if (currentState == 1 && (isOther(c) || isSpace(c))) {
            if (isKeyword(readed)) {
                System.out.println("Keyword: " + readed);
            } else {
                System.out.println("Identifier: " + readed);
            }
            reset();
        }
    }

    public void number(char c) {
        if ((currentState == 0 || currentState == 3) && isDigit(c)) {
            currentState = 3;
            readed += c;
        } else if (currentState == 3 && c == '.') {
            currentState = 4;
            readed += c;
        } else if ((currentState == 3 || currentState == 5) && c == 'E') {
            currentState = 6;
            readed += c;
        } else if ((currentState == 4 || currentState == 5) && isDigit(c)) {
            currentState = 5;
            readed += c;
        } else if ((currentState == 6 || currentState == 7 || currentState == 8) && isDigit(c)) {
            currentState = 8;
            readed += c;
        } else if (currentState == 6 && (c == '+' || c == '-')) {
            currentState = 7;
            readed += c;
        }

        if ((currentState == 3 || currentState == 5 || currentState == 8) && (isOther(c) || isSpace(c))) {
            System.out.println("Nubmer: " + readed);
            reset();
        }
    }

    public void addOperator(char c) {
        if (currentState == 0 && (c == '+' || c == '-')) {
            currentState = 10;
            readed += c;
        } else if (currentState == 10 && (isOther(c) || isSpace(c))) {
            System.out.println("Add operator: " + readed);
            reset();
        }
    }

    public void mulOperator(char c) {
        if (currentState == 0 && (c == '*' || c == '/')) {
            currentState = 28;
            readed += c;
        } else if (currentState == 28 && (isOther(c) || isSpace(c))) {
            System.out.println("Mul operator: " + readed);
            reset();
        }
    }

    public void relOperator(char c) {
        if (currentState == 0 && (c == '<' || c == '>')) {
            currentState = 12;
            readed += c;
        } else if ((currentState == 12 || currentState == 15 || currentState == 17) && c == '=') {
            currentState = 13;
            readed += c;
        } else if (currentState == 0 && c == '=') {
            currentState = 17;
            readed += c;
        } else if (currentState == 17 && (isOther(c) || isSpace(c))) {
            reset();
        } else if ((currentState == 12 || currentState == 13) && (isOther(c) || isSpace(c))) {
            System.out.println("Relative operator: " + readed);
            reset();
        }
    }

    public void not(char c) {
        if (currentState == 0 && c == '!') {
            currentState = 15;
            readed += c;
        } else if (currentState == 15 && (isOther(c) || isSpace(c))) {
            System.out.println("NOT: " + readed);
            reset();
        }
    }

    public void and(char c) {
        if (currentState == 0 && c == '&') {
            currentState = 18;
            readed += c;
        } else if (currentState == 18 && c == '&') {
            currentState = 19;
            readed += c;
        } else if (currentState == 19 && (isOther(c) || isSpace(c))) {
            System.out.println("AND: " + readed);
            reset();
        }
    }

    public void or(char c) {
        if (currentState == 0 && c == '|') {
            currentState = 21;
            readed += c;
        } else if (currentState == 21 && c == '|') {
            currentState = 22;
            readed += c;
        } else if (currentState == 22 && (isOther(c) || isSpace(c))) {
            System.out.println("OR: " + readed);
            reset();
        }
    }

    public void error(char c) {
        if (currentState == 0 && (c == '.')) {
            System.out.println("Error: " + c);
        }
    }

    public boolean isSpace(char c) {
        return c == ' ';
    }

    public boolean isOther(char c) {
        return (c == ';' || isBracket(c));
    }

    public boolean isKeyword(String str) {
        return Arrays.asList(KEYWORDS).contains(str);
    }

    public boolean isBracket(char c) {
        return Arrays.asList(BRACKETS).contains(c + "");
    }

    public void reset() {
        currentState = 0;
        readed = "";
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }
}
