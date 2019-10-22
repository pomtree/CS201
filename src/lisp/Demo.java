package lisp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\user\\IdeaProjects\\CS201\\src\\lisp\\lisps.txt"));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] lines = line.split(" ");
            Stack<String> major = new Stack<String>();
            Stack<String> temp = new Stack<String>();
            for (int i = 0; i < lines.length; i++) {
                while (!lines[i].equals(")")) {
                    major.push(lines[i++]);
                }
                while (!major.peek().equals("(")) {
                    temp.push(major.pop());
                }
                major.pop();
                String mode = temp.pop();
                float value;
                {
                    switch (mode) {
                        case "+":
                            value = 0;
                            while (!temp.isEmpty()) {
                                value += Float.parseFloat(temp.pop());
                            }
                            break;
                        case "-":
                            value = Float.parseFloat(temp.pop());
                            while (!temp.isEmpty()) {
                                value -= Float.parseFloat(temp.pop());
                            }
                            break;
                        case "*":
                            value = 1;
                            while (!temp.isEmpty()) {
                                value *= Float.parseFloat(temp.pop());
                            }
                            break;
                        case "/":
                            value = Float.parseFloat(temp.pop()) / Float.parseFloat(temp.pop());
                            while (!temp.isEmpty()) {
                                value /= Float.parseFloat(temp.pop());
                            }
                            break;
                        default:
                            value = Float.MIN_VALUE;
                            break;
                    }
                }
                major.push("" + value);
            }
            System.out.println(line + " Returns \n" + major.pop());
        }
    }
}
