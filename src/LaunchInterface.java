import Login.Role;
import Login.User;
import Products.Product;

import java.util.List;
import java.util.Scanner;

import static Chek.ChekInput.choiceInt;
import static Login.UserList.*;
import static Products.ProductList.*;

public class LaunchInterface {

    public static void launch (List<User> userList, User currentUser, List<Product> productsList){
        while(true) {
            boolean flag = true;
            if (currentUser.getRole().equals(Role.GUEST)){
                flag = choice (flag, userList, currentUser, productsList);
            } else if (currentUser.getRole().equals(Role.USER)) {
                flag = UserChoice(flag, userList, currentUser, productsList);
            } else if (currentUser.getRole().equals(Role.ADMIN)){
                flag = adminChoice (flag, userList, currentUser, productsList);
            } else {break;}
            if (flag == false){
                break;
            }
        }
    }

    public static boolean choice (boolean flag, List<User> userList, User currentUser,
                                  List<Product>productsList) {
        System.out.println("\n<----------Choice interface---------->\n" +
                "Enter values to select an action: \n1 - for user registration, \n2 - for authorization, " +
                "\n3 - for displaying  product list, \n4 - for exit from app.");
        switch (choiceInt()) {
            case 1:
                System.out.println("\n<---------------Registration--------------->\n");
                addUser (userList);
                System.out.println("\n<-----You have successfully registered.----->\n");
                break;
            case 2:
                authorization(userList, currentUser);
                break;
            case 3:
                productOutput(productsList);
                break;
            case 4:
                flag = false;
                System.out.println("<----------Exit from app---------->");
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
        return flag;
    }

    public static boolean UserChoice (boolean flag, List<User> userList, User currentUser,
                                      List<Product> productsList) {
        System.out.println("\n<----------User interface---------->\n" +
                "Enter values to select an action:\n" +
                "1 - for log out,\n"+
                "2 - for displaying product list, \n3 - for exit. ");
        switch (choiceInt()) {
            case 1:
                logOut(userList, currentUser);
                break;
            case 2:
                productOutputAndByu(productsList);
                break;
            case 3:
                flag = false;
                System.out.println("<----------Exit from app---------->");
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
        return flag;
    }

    public static boolean adminChoice (boolean flag, List<User> userList, User currentUser,
                                       List<Product> productsList) {
        Scanner input1= new Scanner(System.in);
        System.out.println("\n<----------Admin choice interface---------->\n" +
                "Enter values to select an action:\n" +
                "1 - for log out, \n2 - for products list management,\n"+
                "3 - for user list management, \n4 - for exit.");
        switch (choiceInt ()) {
            case 1:
                logOut(userList, currentUser);
                break;
            case 2:
                productManagement(productsList);
                break;
            case 3:
                userManagement(userList);
                break;
            case 4:
                flag = false;
                System.out.println("<----------Exit from app---------->");
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
        return flag;
    }
}
