import java.util.Scanner;

public class Main {
    static StringBuilder outputStr = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        do {
            System.out.println("####################\n" +
                    "\tВведите номер кредитной карты формата: **** **** **** ****");
            inputNumber = sc.nextLine().trim();

        } while (checkCardNumber(inputNumber).length() != 19);
        System.out.println(outputStr);

//        System.out.println(searchAndReplaceDiamonds("Номер кредитной карты <5484  4864 45684 > 8466", "***"));

    }

    public static StringBuilder checkCardNumber(String creditNumber) {
//        int checkFourDigit;
//        StringBuilder outputStr = new StringBuilder();
//        boolean check = false;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            index = creditNumber.indexOf(' ');
            if (i == 3) {
               if (creditNumber.length() == 4) {
                   index = 4;
               } else {
                   break;
               }
            }
        if (index != 4) {
            break;
        } else {
            try {
                Integer.parseInt(creditNumber.substring(0, index).trim());
                outputStr.append(creditNumber.substring(0, index).trim()).append(" ");
                creditNumber = creditNumber.substring(index).trim();
            } catch (NumberFormatException ignored) {
                break;
            }
        }
        }
        return outputStr;
    }

   /* public static String searchAndReplaceDiamonds(String text, String placeholder) {
        int startIndex = text.indexOf('<');
        int lastIndex = text.lastIndexOf('>');
        return text.substring(0, startIndex) + placeholder + text.substring(lastIndex +1);
    }*/

}

