package ftt.compiladores.validatelines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author igor_
 */
public class FttCompiladoresValidateLines {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in, "ISO-8859-2");
        System.out.print("Digite o caminho do arquivo a ser lido: ");
        String pathTxt = scan.nextLine();

        System.out.print("Digite o caminho do arquivo a ser salvo com os resultados: ");
        String outPathTxt = scan.nextLine();

        try {
            File file = new File(pathTxt);
            FileWriter out = new FileWriter(outPathTxt);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            String st;
            Stack<Character> stack;

            String result = "";

            while ((st = br.readLine()) != null) {

                boolean validate = true;
                char c;
                stack = new Stack<>();

                for (int i = 0; i < st.length(); i++) {
                    c = st.charAt(i);
                    if (c == '{') {
                        stack.push(c);
                    } else if (c == '[' && (stack.empty() || stack.peek() != '(')) {
                        stack.push(c);
                    } else if (c == '(') {
                        stack.push(c);
                    } else if (c == ')') {
                        if (stack.empty()) {
                            validate = false;
                            break;
                        } else if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            validate = false;
                            break;
                        }
                    } else if (c == ']') {
                        if (stack.empty()) {
                            validate = false;
                            break;
                        } else if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            validate = false;
                            break;
                        }
                    } else if (c == '}') {
                        if (stack.empty()) {
                            validate = false;
                            break;
                        } else if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            validate = false;
                            break;
                        }
                    }
                }
                if (validate && stack.empty()) {
                    result += st + " - OK!\n";
                } else {
                    result += st + " - Inválido!\n";
                }
            }
            out.write(result);
            out.close();
        } catch (Exception ex) {
            System.out.println("\n" + ex.getMessage());
        }
    }
}
