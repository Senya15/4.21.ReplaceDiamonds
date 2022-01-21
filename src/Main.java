import java.util.Scanner;

public class Main {
    private static final char SPACE = ' ';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        String CardNumber;
        do {
            System.out.println("####################\n" +
                    "\tВведите номер кредитной карты формата: **** **** **** ****");
            inputNumber = sc.nextLine().trim();
            CardNumber = checkCardNumber(inputNumber);
        } while (CardNumber.length() != 19);

        System.out.println("Вы ввели карту с номером: " + CardNumber);
        System.out.println("\n\tКарта \" " +
                searchAndReplaceDiamonds(CardNumber, "***") +
                " \" найдена в базе");

    }

    public static String checkCardNumber(String creditNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int index;
        for (int i = 0; i < 4; i++) {
            index = creditNumber.indexOf(SPACE);
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
        int index = text.lastIndexOf(SPACE);
        return placeholder + " " + text.substring(index + 1);
    }
}

