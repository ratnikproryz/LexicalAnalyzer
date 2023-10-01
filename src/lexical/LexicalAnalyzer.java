package lexical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LexicalAnalyzer implements Token {
    private Set<String> keywordsList = new HashSet<>();
    private Set<String> identifiersList = new HashSet<>();
    private Set<String> numsList = new HashSet<>();
    private Set<String> addOpsList = new HashSet<>();
    private Set<String> mulOpsList = new HashSet<>();
    private Set<String> relOpsList = new HashSet<>();
    private Set<String> logicalOp = new HashSet<>();
    private Set<String> othersList = new HashSet<>();

    public LexicalAnalyzer() {
    }

    public void analyze(String str) {
        String[] text = str.split(" ");
        for (String item : text) {
            if (checkKeyword(item) == 1) {
                keywordsList.add(item);
            } else if (checkIdentifier(item) == 2) {
                identifiersList.add(item);
            } else if (checkNum(item) == 3) {
                numsList.add(item);
            } else if (checkAddOp(item) == 4) {
                addOpsList.add(item);
            } else if (checkMulOp(item) == 5) {
                mulOpsList.add(item);
            } else if (checkRelop(item) == 6) {
                relOpsList.add(item);
            } else if (item.contains("&&")) {
                logicalOp.add(item);
            } else if (item.contains("||")) {
                logicalOp.add(item);
            } else if (item.contains("!")) {
                logicalOp.add(item);
            } else {
                othersList.add(item);
            }
            System.out.println(item);
        }
    }

    public void resutl() {
        System.out.println("Keywords: " + keywordsList.toString());
        System.out.println("Identifiers: " + identifiersList.toString());
        System.out.println("Num: "+ numsList.toString());
        System.out.println("Add operation: "+ addOpsList.toString());
        System.out.println("Mul operation: "+ mulOpsList.toString());
        System.out.println("Relation operation: "+ relOpsList.toString());
        System.out.println("Logical operation: "+  logicalOp.toString());
        System.out.println("Others: "+ othersList.toString());
    }

    public int checkKeyword(String word) {
        if (Arrays.asList(keyword).contains(word)) {
            return 1;
        }
        return 0;
    }

    public int checkIdentifier(String word) {
        if (word.matches(identifier)) {
            return 2;
        }
        return 0;
    }

    public int checkNum(String word) {
        if (word.matches(num)) {
            return 3;
        }
        return 0;
    }

    public int checkAddOp(String word) {
        if (Arrays.asList(addOp).contains(word)) {
            return 4;
        }
        return 0;
    }

    public int checkMulOp(String word) {
        if (Arrays.asList(mulOp).contains(word)) {
            return 5;
        }
        return 0;
    }

    public int checkRelop(String word) {
        if (Arrays.asList(relop).contains(word)) {
            return 6;
        }
        return 0;
    }
}
