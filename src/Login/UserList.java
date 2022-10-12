package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Chek.ChekInput.*;

public class UserList extends User {

    private static final String pathnameUser = "./src/Login/Users";

    public static List<User> readUserList() throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        File userFile = new File (pathnameUser);
        Scanner userScanner = new Scanner(userFile);
        String usersLine = userScanner.nextLine();
        String[] userLineArray = usersLine.split(";");

        for (String charLine: userLineArray
        ) {
            String[] itemLine = charLine.split(",");
            User item = new User();
            item.setId(Integer.parseInt(itemLine[0]));
            item.setLogin(itemLine[1]);
            item.setEmail(itemLine[2]);
            item.setPassword(itemLine[3]);
            item.setRole(Role.valueOf(itemLine[4]));
            userList.add(item);
        }
        return userList;
    }

    public static void writeUserList(List<User> userList) throws IOException {
        StringBuilder userLineWrite = new StringBuilder();
        for (User item: userList
        ) {
            userLineWrite = userLineWrite.append(item.getId() + "," + item.getLogin() + "," +
                    item.getEmail() + "," + item.getPassword() + "," +  item.getRole().name() + ";");

        }
        FileWriter userRecord = new FileWriter(pathnameUser);
        userRecord.append(userLineWrite);
        userRecord.close();
    }

    /*-------------------------*/

    public static void userManagement(List<User> userList) {
        System.out.println("\n<---------User management interface--------->\n" +
                "Enter values to select an action:\n" +
                "1 - for displaing user list,\n" +
                "2 - for add new User, \n3 - view information about user, \n" +
                "4 - set amin for user, \n5 - for exit to main menu: ");
        boolean exit = false;
        switch (choiceInt ()) {
            case 1:
                userOutput(userList);
                break;
            case 2:
                addUser (userList);
                System.out.println("\n<-------New user added successfully.------->\n");
                break;
            case 3:
                viewUser(userList);
                break;
            case 4:
                changeUser(userList);
                break;
            case 5:
                exit = true;
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
        if (exit == false){ userManagement(userList);}
    }
    public static void addUser (List<User> userList) {
        int currentId = userList.size() +1;
        String newLogin = loginInput();
        String newEmail = mailInput();
        String newPassword = passwordInput();
        User newUser = new User(currentId, newLogin, newEmail, newPassword, Role.USER);
        userList.add(newUser);
    }

    public static void userOutput(List<User> userList){
        System.out.println("\n<----------Displaying a list of users: ---------->\n");
        for (User item: userList
        ) {
            System.out.println(item.toString());
        }
    }

    public static User authorization(List<User> userList, User currentUser){
        System.out.println("\n<------------Authorization------------>\n");
        String loginEmailUser = loginMailInput();
        String passwordUser = passwordInput();
        currentUser.setLogin(loginEmailUser);
        currentUser.setEmail(loginEmailUser);
        currentUser.setPassword(passwordUser);
        boolean userAuth = false;
        for (User user : userList) {
            if (currentUser.equals(user))
            {
                currentUser.setId(user.getId());
                currentUser.setLogin(user.getLogin());
                currentUser.setEmail(user.getEmail());
                currentUser.setRole(user.getRole());
                System.out.println("\n<--------You have successfully logged in as "
                        +currentUser.getRole().name().toLowerCase() + ".-------->");
                userAuth = true;
                break;
            }
        }
        if (userAuth == false) {
            System.out.println("You entered the wrong login or password. Try it again.");
        }
        return currentUser;
    }

    public static User logOut(List<User> userList, User currentUser){
        currentUser.setId(0);
        currentUser.setLogin("");
        currentUser.setEmail("");
        currentUser.setPassword("");
        currentUser.setRole(Role.GUEST);
        System.out.println("\n<--------You have successfully logged out.-------->");
        return currentUser;
    }

    public static void changeUser(List<User> userList){
        System.out.print("Select user to change role to Admin: ");
        int idInput = choiceInt ();
        boolean userChoice = false;
        for (User item: userList
        ) {
            if (item.getId() == idInput) {
                item.setRole(Role.ADMIN);
                userChoice = true;
                System.out.println("User №" + item.getId() + " got the admin role.");
                break;
            }
        }
        if (userChoice == false){
            System.out.println("You have entered an invalid user number.\n" +
                    "Please, try it again");
            changeUser(userList);
        }
    }

    public static void viewUser(List<User> userList){
        System.out.print("Select user to view information: ");
        int idInput = choiceInt ();
        boolean userChoice = false;
        for (User item: userList
        ) {
            if (item.getId() == idInput) {
                System.out.println(item.toString());
                userChoice = true;
                break;
            }
        }
        if (userChoice == false){
            System.out.println("You have entered an invalid user number.\n" +
                    "Please, try it again");
            changeUser(userList);
        }
    }
}
