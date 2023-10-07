package DFA;

public interface Token {
    String[] OTHERS = {" ", ";",};
    String[] KEYWORDS = {"for", "while", "if", "else", "return", "break", "continue", "int", "float", "void"};
    String[] BRACKETS = {")", "(", "{", "}", "[", "]"};
    Integer[] numberState = {0, 3, 4, 5, 6, 7, 8};
    Integer[] relOpState = {0, 12, 13, 15, 17};
    Integer[] andState = {0, 18, 19};
    Integer[] orState = {0, 21, 22};
    Integer[] notState = {0, 15};
}
