package Lexical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Analyze {
    Set<String> keywordsList = new HashSet<>();
    Set<String> identifiersList = new HashSet<>();
    Set<String> numsList = new HashSet<>();
    Set<String> addOpsList = new HashSet<>();
    Set<String> mulOpsList = new HashSet<>();
    Set<String> relOpsList = new HashSet<>();
    Set<String> logicalOp = new HashSet<>();
    Set<String> othersList = new HashSet<>();
}
