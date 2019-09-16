package ftt.compiladores.parserxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ParserXML {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        File temp, fXML;
        BufferedReader br = null;
        try {
            String pathXML;
            do {
                System.out.print("Digite o caminho do arquivo XML a ser convertido!");
                pathXML = input.nextLine();
                temp = File.createTempFile("pathXML", ".xml");
                if (!temp.exists()) {
                    System.out.println("O arquivo digitado não existe, digite o caminho novamente!\n");
                }
            } while (!temp.exists());
            fXML = new File(pathXML);
            br = new BufferedReader(new FileReader(fXML));
            int cont = 0;
            Stack<String> stXml = new Stack<>();
            String st;
            while ((st = br.readLine().trim()) != null) {
                if (st.startsWith("{")) {

                }
            }

        } catch (Exception ex) {
            System.out.println("\u001B[31mErro: " + ex.getMessage());
        } finally {
            br.close();
        }
    }
}
