package Chek;

import java.util.Scanner;
public class ChekInput {
    private static String readValue(String inputMessage, String regex, String errorMessage) {
        Scanner input2 = new Scanner(System.in);
        while (true) {
            System.out.print(inputMessage);
            String line = input2.nextLine();
            if (line.matches(regex))
            {
                return line;
            }
            System.out.println(errorMessage);
        }
    }

    public static String loginInput() {
        return readValue("Enter your login: ",
                "^[a-zA-Z][a-zA-Z0-9-_\\.]{3,10}$",
                "The name must contain 4-20 characters, " +
                        "which can be letters and numbers, the first character must be a letter.");
    }

    public static String mailInput() {
        return readValue("Enter your email: ",
                "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$",
                "Incorrect email entered.");
    }

    public static String passwordInput() {
        return readValue("Enter your password: ",
                "(?=^.{7,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
                "Incorrect password entered.");
    }

    public static String loginMailInput() {
        return readValue("Enter your login or email: ",
                "(^[a-zA-Z][a-zA-Z0-9-_\\.]{3,10}$)|(^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$)",
                "Incorrect login or email entered.");
    }

    public static String inputProductName() {
        return readValue("Enter product name: ",
                "^[a-zA-Z][a-zA-Z0-9-_\\.]{3,20}$",
                "The name must contain 4-20 characters, " +
                        "which can be letters and numbers, the first character must be a letter.");
    }

    public static String inputProductPrice() {
        return readValue("Enter product price: ",
                "\\-?\\d+(\\.\\d{0,2})?",
                "Incorrect price format.");
    }

    public static String inputProductDescription() {
        return readValue("Enter product description: ",
                "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
                "The description must contain 6-40 characters, " +
                        "which can be letters and numbers, the first character must be a letter.");
    }

    public static String choiceInput() {
        return readValue("",
                "\\d",
                "Enter an integer.");
    }

    public static int choiceInt (){

        return Integer.parseInt(choiceInput());
    }
}
