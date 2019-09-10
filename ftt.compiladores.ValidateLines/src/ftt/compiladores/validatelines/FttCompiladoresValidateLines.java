package ftt.compiladores.validatelines;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author igor_
 */
public class FttCompiladoresValidateLines {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String pathTxt = scan.nextLine();

        File file = new File(pathTxt);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        Stack<Character> stack = new Stack<Character>();

        while ((st = br.readLine()) != null) {

            boolean validate = true;
            char c;
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
            if (validate) {
                System.out.println("OK!");
            } else {
                System.out.println("Inválido!");
            }
        }
    }
}
