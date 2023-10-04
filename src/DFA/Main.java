package DFA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static String normalize(String str) {
        if (str.matches("^.*[(].*$")){
            str = str.replaceAll("\\(", " ( ");
        }
        if (str.matches("^.*[)].*$")){
            str = str.replaceAll("\\)", " ) ");
        }
        str = str.replaceAll(";", "");
        return str.trim();
    }

    public static void main(String[] args) {
        try {
            String path = "D:\\Java\\Compiler\\src\\Lexical\\lexical.txt";
            FileInputStream stream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
            String str = "";

            while ((str = br.readLine()) != null) {
                str = normalize(str);
                for(char c : str.toCharArray()){
                    lexicalAnalyzer.analyze(c);
                    lexicalAnalyzer.analyzeV2(c);
                }
            }
            lexicalAnalyzer.resutl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
