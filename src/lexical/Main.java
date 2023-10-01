package lexical;

import lexical.LexicalAnalyzer;

import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static String normalize(String str) {
        if (str.matches("^.*[(].*$")){
            str = str.replaceAll("\\(", " \\( ");
        }
        if (str.matches("^.*[)].*$")){
            str = str.replaceAll("\\)", " \\) ");
        }
        return str.trim();
    }

    public static void main(String[] args) {
        try {
            String path = "D:\\Java\\Compiler\\src\\lexical\\lexical.txt";
            FileInputStream stream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
            String str = "";

            while ((str = br.readLine()) != null) {
                lexicalAnalyzer.analyze(normalize(str));
            }
            lexicalAnalyzer.resutl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}