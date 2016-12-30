package golovatch.courses.proc.recursion.labs;

import static java.lang.Character.*;
/**
 * Created by Alex on 7/17/2016.
 */
public class Parser {
    public static void main(String[] args) {
//        System.out.println("123 = " + eval("123"));
//        System.out.println("5 * 23 = " + eval("5*23"));
//        System.out.println("5 * (1 + 1) = " + eval("5*(1+1)"));
//        System.out.println("1 + (5 - 2 * (13 / 6)) = " + eval("1+(5-2*(13/6))"));

        System.out.println("123 = " + evalR("123"));
        System.out.println("5 * 23 = " + evalR("5 * 23"));
        System.out.println("(1 + 3) * 5  = " + evalR("(1 + 3) * 5"));
        System.out.println("((13 / 6) * 2 - 5) + 2 = " + evalR("(((13 / 6) * 2) - 5) + 2"));
    }

    private static int evalR(String exp) {
        exp = exp.replaceAll(" ", "");

        if (exp.startsWith("(")) {
            int rightIndex = exp.lastIndexOf(")");
            char operator = exp.charAt(rightIndex + 1) ;
            int leftOperand = evalR(exp.substring(1, rightIndex));
            int rightOperand = evalR(exp.substring(rightIndex + 2));
            switch (operator) {
                case '+':
                    return (leftOperand + rightOperand);
                case '-':
                    return (leftOperand - rightOperand);
                case '*':
                    return (leftOperand * rightOperand);
                case '/':
                    return (leftOperand / rightOperand);
            }
        }

        int position = exp.length()-1;
        while (position >= 0) {
            if (isDigit(exp.charAt(position))) position--;
            else {
                int rightOperand = Integer.valueOf(exp.substring(position + 1));
                char operator = exp.charAt(position);
                int leftOperand = evalR(exp.substring(0, position ));
                switch (operator) {
                    case '+':
                        return leftOperand + rightOperand;
                    case '-':
                        return leftOperand - rightOperand;
                    case '*':
                        return leftOperand * rightOperand;
                    case '/':
                        return leftOperand / rightOperand;
                }
            }
        }
        return Integer.valueOf(exp);
    }

    private static int eval(String exp) {
        if (exp.startsWith("(") & exp.endsWith(")")) return eval(exp.substring(1, exp.length() - 1));

        int position = 0;
        while (position <= exp.length() - 1) {
            if (isDigit(exp.charAt(position))) position++;
            else {
                int leftOperand = Integer.valueOf(exp.substring(0, position));
                char operator = exp.charAt(position);
                int rightOperand = eval(exp.substring(position + 1));
                switch (operator) {
                    case '+':
                        return leftOperand + rightOperand;
                    case '-':
                        return leftOperand - rightOperand;
                    case '*':
                        return leftOperand * rightOperand;
                    case '/':
                        return leftOperand / rightOperand;
                }
            }
        }
        return Integer.valueOf(exp);
    }
}
