import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        String op1 = "";
        String op2 = "";
        int num1, num2, num3, indic = 0;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        if (str.charAt(0) == '-') {
            str1.append('-');
            indic++;
        }

        for (int i = indic; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (Character.getNumericValue(str.charAt(i)) >= 0 && Character.getNumericValue(str.charAt(i)) <= 9) {
                if (op1.equals("")) {
                    str1.append(str.charAt(i));
                } else if (op2.equals("")) {
                    str2.append(str.charAt(i));
                } else {
                    str3.append(str.charAt(i));
                }
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (op1.equals("")) {
                    op1 += str.charAt(i);
                } else if (op2.equals("")) {
                    op2 += str.charAt(i);
                }
            } else {
                throw new NumberFormatException("Wrong symbol!");
            }
        }

        num1 = Integer.parseInt(str1.toString());
        num2 = Integer.parseInt(str2.toString());

        if (op2.equals("")) {
            System.out.println(calculateTwo(num1, num2, op1));
        } else {
            num3 = Integer.parseInt(str3.toString());
            System.out.println(calculateThree(num1, num2, num3, op1, op2));
        }
    }

    public static int calculateTwo(int a, int b, String operation) {
        if (Objects.equals(operation, "+")) {
            return a + b;
        } else if (Objects.equals(operation, "-")) {
            return a - b;
        } else if (Objects.equals(operation, "*")) {
            return a * b;
        } else if (Objects.equals(operation, "/")) {
            return a / b;
        }
        return 0;
    }

    public static int calculateThree(int a, int b, int c, String op1, String op2) {
        if ((Objects.equals(op2, "*") || Objects.equals(op2, "/")) && ((Objects.equals(op1, "+")) || (Objects.equals(op1, "-")))) {
            if (op2.equals("*")) {
                if (op1.equals("+")) {
                    return a + b * c;
                } else {
                    return a - b * c;
                }
            } else if (op2.equals("/")) {
                if (op1.equals("+")) {
                    return a + b / c;
                } else {
                    return a - b / c;
                }
            }
        } else if (Objects.equals(op1, "+") && Objects.equals(op2, "+")) {
            return a + b + c;
        } else if (Objects.equals(op1, "+") && Objects.equals(op2, "-")) {
            return a + b - c;
        } else if (Objects.equals(op1, "-") && Objects.equals(op2, "+")) {
            return a - b + c;
        } else if (Objects.equals(op1, "-") && Objects.equals(op2, "-")) {
            return a - b - c;
        } else if (Objects.equals(op1, "*") && Objects.equals(op2, "+")) {
            return a * b + c;
        } else if (Objects.equals(op1, "*") && Objects.equals(op2, "-")) {
            return a * b - c;
        } else if (Objects.equals(op1, "*") && Objects.equals(op2, "*")) {
            return a * b * c;
        } else if (Objects.equals(op1, "*") && Objects.equals(op2, "/")) {
            return a * b / c;
        } else if (Objects.equals(op1, "/") && Objects.equals(op2, "+")) {
            return a / b + c;
        } else if (Objects.equals(op1, "/") && Objects.equals(op2, "-")) {
            return a / b - c;
        } else if (Objects.equals(op1, "/") && Objects.equals(op2, "*")) {
            return a / b * c;
        } else if (Objects.equals(op1, "/") && Objects.equals(op2, "/")) {
            return a / b / c;
        }
        return 0;
    }
}

