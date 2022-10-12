import Login.*;
import Products.*;

import java.io.IOException;
import java.util.List;

import static Login.UserList.*;
import static Products.ProductList.*;

public class Main extends LaunchInterface {
    public static void main(String[] args) throws IOException {

        /*------------Reading products-------------*/
        List<Product> productsList = readProductList();
        /*------------Reading users-------------*/
        List<User> userList = readUserList();
        User currentUser = new User();
        currentUser.setRole(Role.GUEST);
        /*------------Interface launch-------------*/
        launch (userList, currentUser, productsList);
        /*------------Recording Files-------------*/
        writeProductList(productsList);
        writeUserList(userList);
        /*--------------Exit Message---------------*/

        System.out.println( currentUser.getRole().name() +" " + currentUser.getLogin() +
                " exited the app." );
    }
}
