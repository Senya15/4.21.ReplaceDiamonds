import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        do {
            System.out.println("####################\n" +
                    "\tВведите номер кредитной карты формата: **** **** **** ****");
            inputNumber = sc.nextLine().trim();
        } while (checkCardNumber(inputNumber).length() != 19);

        System.out.println("Вы ввели номер карты: " + checkCardNumber(inputNumber));
        System.out.println("\n\tКарта / " +
                searchAndReplaceDiamonds(checkCardNumber(inputNumber), "***") +
                " / найдена в базе");

    }

    public static String checkCardNumber(String creditNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int index;
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
                    stringBuilder.append(creditNumber, 0, index).append(" ");
                    creditNumber = creditNumber.substring(index).trim();
                } catch (NumberFormatException ignored) {
                    break;
                }
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        int index = text.lastIndexOf(' ');
        return placeholder + " " + text.substring(index + 1);
    }
}

