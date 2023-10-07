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
        }
        if (currentState == 10 && (isOther(c) || isSpace(c))) {
            System.out.println("Add operator: " + readed);
            reset();
        }
    }

//    public void identifier(String str) {
//        String word = "";
//        for (char c : str.toCharArray()) {
//            if (currentState == 0 && isLetter(c)) {
//                currentState = 1;
//                word += c;
//                continue;
//            }
//            if (currentState == 1 && (isLetter(c) || isDigit(c))) {
//                word += c;
//                continue;
//            }
//
//            if (currentState == 1 && (c == ';' || c == ' ' || isBracket(c))) {
//                if (isKeyword(word)) {
//                    System.out.println("Keyword: " + word);
//                } else {
//                    System.out.println("Identifier: " + word);
//                }
//                if (c != ' ') {
//                    System.out.println(c + " : " + c);
//                }
//                word = "";
//                reset();
//                continue;
//            }
//            if (currentState == 0 && (c == ';' || isBracket(c))) {
//                System.out.println(c + " : " + c);
//            }
//        }
//    }

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
