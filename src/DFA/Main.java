package DFA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static String[] normalize(String str) {
//        if (str.matches("^.*[(].*$")) {
//            str = str.replaceAll("\\(", " ( ");
//        }
//        if (str.matches("^.*[)].*$")) {
//            str = str.replaceAll("\\)", " ) ");
//        }
//        str = str.replaceAll(";", "");
        return str.trim().split(" ");
    }

    public static void main(String[] args) {
        try {
            String path = "D:\\Java\\Compiler\\src\\Lexical\\lexical.txt";
            FileInputStream stream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(new DFA());

            String str = "";
            while ((str = br.readLine()) != null) {
                lexicalAnalyzer.analyze(str);
            }
            lexicalAnalyzer.result();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
