
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) throws Exception {
                Scanner input = new Scanner(System.in);
                    System.out.println("input: ");
                    String operation = input.nextLine();
                    System.out.println("output: ");
                    System.out.println(parse(operation));
            }
            public static String parse(String operation) throws Exception {

                int leftNum;
                int rightNum;
                String oper;
                String result;
                boolean isRoman;

                String[] operands = operation.split("[+\\-*/]");

                if (operands.length != 2)
                    throw new Exception("Неверный знак операции или колличество операндов не равно двум");

                oper = checkOperation(operation);

                if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
                    leftNum = Roman.convertToArabian(operands[0]);
                    rightNum = Roman.convertToArabian(operands[1]);
                    isRoman = true;
                } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
                    leftNum = Integer.parseInt(operands[0]);
                    rightNum = Integer.parseInt(operands[1]);
                    isRoman = false;
                } else {
                    throw new Exception("Оба числа должны быть римские или арабские. Повторите ввод");
                }

                if (leftNum > 10 || rightNum > 10) {
                    throw new Exception("Числа должны быть от 1 до 10.");
                }

                int arabian = calc(leftNum, rightNum, oper);

                if (isRoman) {
                    if (arabian <= 1) {
                        throw new Exception("Римское число не может быть меньше I");
                    }

                    result = Roman.convertToRoman(arabian);
                } else {
                    result = String.valueOf(arabian);
                }
                return result;
            }
            static String checkOperation (String operation){

                if (operation.contains("+")) return "+";
                else if (operation.contains("-")) return "-";
                else if (operation.contains("*")) return "*";
                else if (operation.contains("/")) return "/";
                else return null;
            }
            static int calc ( int a, int b, String oper){
                return switch (oper) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> a / b;
                };
            }
            //if (oper.equals("+")) return a + b;
            //else if (oper.equals("-")) return a - b;
            //else if (oper.equals("*")) return a * b;
            //else return a / b;

            static class Roman {
                static String[] romanArray = new String[]{
                        "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"

                };

                public static boolean isRoman(String val) {
                    for (String s : romanArray) {

                        if (val.equals(s)) {
                            return true;
                        }
                    }
                    return false;
                }
             /*for (int i = 0; i < romanArray.length; i++) {

                 if (val.equals(romanArray[i])) {
                     return true;
                 }*/

                public static int convertToArabian(String roman) {
                    for (int i = 0; i < romanArray.length; i++) {
                        if (roman.equals(romanArray[i])) {
                            return i;
                        }
                    }
                    return -1;
                }

                public static String convertToRoman(int arabian) {

                    return romanArray[arabian];
                }
            }
        }








