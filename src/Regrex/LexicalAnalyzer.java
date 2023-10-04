package Regrex;

import Lexical.Analyze;
import Lexical.Token;

import java.util.Arrays;

public class LexicalAnalyzer implements Token, Analyze {

    public LexicalAnalyzer() {
    }

    public void analyze(String str) {
        String[] text = str.split(" ");
        for (String item : text) {
            if (item.contains(and)) {
                logicalOp.add(item);
            } else if (item.contains(or)) {
                logicalOp.add(item);
            } else if (item.contains(not)) {
                logicalOp.add(item);
            } else if (checkKeyword(item) == 1) {
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
            } else if (checkOthers(item) == 7) {
                othersList.add(item);
            }
        }
    }

    public void analyzeV2(String str) {
        String[] text = str.split(" ");
        for (String item : text) {
            if (item.contains(and)) {
                System.out.println("And: " + item);
            } else if (item.contains(or)) {
                System.out.println("Or: " + item);
            } else if (item.contains(not)) {
                System.out.println("Not: " + item);
            } else if (checkKeyword(item) == 1) {
                System.out.println("Keyword: " + item);
            } else if (checkIdentifier(item) == 2) {
                System.out.println("Identifier:" + item);
            } else if (checkNum(item) == 3) {
                System.out.println("Num: " + item);
            } else if (checkAddOp(item) == 4) {
                System.out.println("Addop: "+ item);
            } else if (checkMulOp(item) == 5) {
                System.out.println("Mulop: "+ item);
            } else if (checkRelop(item) == 6) {
                System.out.println("Relop: "+item);
            } else if (checkOthers(item) == 7) {
                System.out.println(item+":"+item);
            }else if(!item.isEmpty()){
                System.out.println("Error: "+item);
            }
        }
    }

    public void resutl() {
        System.out.println("Keywords: " + keywordsList.toString());
        System.out.println("Identifiers: " + identifiersList.toString());
        System.out.println("Num: " + numsList.toString());
        System.out.println("Add operation: " + addOpsList.toString());
        System.out.println("Mul operation: " + mulOpsList.toString());
        System.out.println("Relation operation: " + relOpsList.toString());
        System.out.println("Logical operation: " + logicalOp.toString());
        System.out.println("Others: " + othersList.toString());
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

    public int checkOthers(String word) {
        if (Arrays.asList(others).contains(word)) {
            return 7;
        }
        return 0;
    }
}
