package ftt.compiladores.dojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FttCompiladoresDojo {

    public static void main(String[] args) throws IOException {
        // TODO Criar tabela de lexemas

        String dir = System.getProperty("user.dir");

        File file = new File("src\\ftt\\compiladores\\dojo\\jquery-3.4.1.js");
        FileWriter out = new FileWriter(dir + "\\output.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String full = "";

        while ((st = br.readLine()) != null) {

            if (st.trim().startsWith("//")) {
                continue;
            }

            full += st.trim() + "\n";
        }

        full = full.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");

        out.write(full);
        out.close();
    }

}
