package DFA;

public interface Token {
    String[] OTHERS = {" ", ";",};
    String[] KEYWORDS = {"for", "while", "if", "else", "return", "break", "continue", "int", "float", "void"};
    String[] BRACKETS = {")", "(", "{", "}", "[", "]"};
    Integer[] numberState = {0, 3, 4, 5, 6, 7, 8};
}
