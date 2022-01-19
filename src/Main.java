import java.util.Scanner;

public class Main {
    private static int checkStr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        do {
            System.out.println("####################\n" +
                    "\tВведите номер кредитной карты формата: **** **** **** ****");
            inputNumber = sc.nextLine().trim();

        } while (checkCardNumber(inputNumber));

//        System.out.println(searchAndReplaceDiamonds("Номер кредитной карты <5484  4864 45684 > 8466", "***"));

    }

    public static boolean checkCardNumber(String creditNumber) {

        int checkFourDigit;
        boolean check = false;
        int index = creditNumber.indexOf(' ');
        if (index == -1) {
            check = true;
        } else if (!(creditNumber.substring(0, index).trim().length() == 4)) {
            check = true;
        } else {
            try {
                checkFourDigit = Integer.parseInt(creditNumber.substring(0, index).trim());
            } catch (NumberFormatException ignored) {
                check = true;
            }
        }
        return check;
    }

   /* public static String searchAndReplaceDiamonds(String text, String placeholder) {
        int startIndex = 0;
        int lastIndex = 0;
        startIndex = text.indexOf('<');
        lastIndex = text.lastIndexOf('>');
        return text.substring(0, startIndex) + placeholder + text.substring(lastIndex +1);
    }*/

}

