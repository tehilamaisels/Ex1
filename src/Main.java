
import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num1 = "";
        String num2 = "";

        while (true) {

            System.out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            num1 = scanner.next();

            if (num1.equals("quit")) {
                break;
            }

            if (!Ex1.isNumber(num1)) {
                continue;
            }

            System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
            num2 = scanner.next();

            if (num2.equals("quit")) {
                break;
            }

            if (!Ex1.isNumber(num2)) {
                continue;
            }

            System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));

            System.out.println("Enter a base for output: (a number [2,16]");
            String baseText = scanner.next();


            if (!baseText.matches("\\d+")){
                System.out.println("ERR: wrong base, should be [2,16], got (" + baseText + ")");
                continue;
            }


            int base = Integer.parseInt(baseText);

            if (base < 2 || base > 16) {
                System.out.println("ERR: wrong base, should be [2,16], got (" + baseText + ")");
                continue;
            }


            int n1 = Ex1.number2Int(num1);
            int n2 = Ex1.number2Int(num2);

            String equal1 = Ex1.int2Number(n1 + n2, base);
            String equal2 = Ex1.int2Number(n1 * n2, base);

            System.out.println(num1 + " + " + num2 + " = " + equal1);
            System.out.println(num1 + " * " + num2 + " = " + equal2);
            String[] arr = {num1, num2, equal1, equal2};
            System.out.println("Max number over [" + num1 + ", "  + num2 + ", " + equal1 + ", " + equal2 +"] is: " + Ex1.maxIndex(arr));

        }

    }

}








