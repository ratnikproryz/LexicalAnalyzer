package Lexical;

public interface Token {
    String empty = "^$";
    String[] keyword = {"for", "while", "if", "else", "return", "break", "continue", "int", "float", "void"};
    String letter = "[A-Z | a-z]";
    String digit = "[0-9]";
    String digits = digit + "+";
    String identifier = letter + "(" + letter + "|" + digit + "|_)*";
    String optionalFraction = "((." + digits + ")|" + empty + ")";
    String optionalExponent = "((E(\\+|\\-|" + empty + ")" + digits + ")|" + empty + ")";
    String num = digits + "|" + digits + optionalFraction + "|" + digits + optionalFraction + optionalExponent;
    String[] addOp = {"+", "-"};
    String[] mulOp = {"*", "/"};
    String[] relop = {"<", ">", "<=", ">=", "==", "!="};
    String and = "&&";
    String or = "||";
    String not = "!";
    String[] others = {")", "(", "{", "}", "[", "]"};
}
