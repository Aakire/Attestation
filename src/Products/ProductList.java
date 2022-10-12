package Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Chek.ChekInput.*;

public class ProductList extends Product{
    private final static String pathnameProduct = "./src/Products/Product";
    public static List<Product> readProductList() throws FileNotFoundException {

        File productFile = new File (pathnameProduct);
        Scanner sc = new Scanner(productFile);
        String productLine = sc.nextLine();
        String[] productLineArray = productLine.split(";");
        List<Product> productsList = new ArrayList<>();
        for (String charLine: productLineArray
        ) {
            String[] itemLine = charLine.split(",");
            Product item = new Product();
            item.setId(Integer.parseInt(itemLine[0]));
            item.setName(itemLine[1]);
            item.setPrice(Double.valueOf(itemLine[2]));
            item.setDescription(itemLine[3]);
            productsList.add(item);
        }
        return productsList;
    }

    public static void writeProductList(List<Product> productsList) throws IOException {
        StringBuilder productLineWrite = new StringBuilder();
        for (Product item: productsList
        ) {
            productLineWrite = productLineWrite.append(item.getId() + "," + item.getName() + "," +
                    item.getPrice() + "," + item.getDescription() + ";");
        }
        FileWriter productRecord = new FileWriter(pathnameProduct);
        productRecord.append(productLineWrite);
        productRecord.close();
    }

    /*-------------------------------------------------------------------------*/
    public static void productManagement(List<Product> productsList){
        System.out.println("\n<-------Product management interface------->\n" +
                "Enter values to select an action:\n" +
                "1 - for displaing product list,\n" +
                "2 - for add new product, \n3 - view information about product, \n" +
                "4 - for change product, \n5 - for exit to main menu. ");
        boolean exit = false;
        switch (choiceInt ()) {
            case 1:
                productOutput(productsList);
                break;
            case 2:
                addProduct(productsList);
                break;
            case 3:
                viewProduct(productsList);
                break;
            case 4:
                changeProduct(productsList);
                break;
            case 5:
                exit = true;
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
        if (exit == false) {productManagement(productsList);}
    }

    public static void productOutput(List<Product> productsList){
        System.out.println("\n<-------Displaying a list of products: ------->\n");
        for (Product item: productsList
        ) {
            System.out.println(item.toString());
        }
    }

    public static void productOutputAndByu (List<Product> productsList){
        System.out.println("\n<-------Displaying a list of products: ------->\n");
        for (Product item: productsList
        ) {
            System.out.println(item.toString());
        }
        System.out.println("\n<-------Purchase interface------->\n" +
                "Enter values to select an action: \n1 - to buy products, \n2 - for exit.");
        switch (choiceInt()) {
            case 1:
                double price = productChoice( productsList);
                System.out.print("Select quantity of item to buy: ");
                int nProduct = choiceInt ();
                System.out.println("Thank you! Your purchase amount is: " + price*nProduct + "S");
            case 2:
                System.out.println("Exit");
                break;
            default:
                System.out.println("You have chosen the wrong action. Please try again.");
                break;
        }
    }

    public static double productChoice(List<Product> productsList){
        System.out.print("Select product number to purchase: ");
        int idInput = choiceInt ();
        double purchasePrice = 0;
        boolean productChoice = false;
        for (Product item: productsList
        ) {
            if (item.getId() == idInput) {
                purchasePrice = item.getPrice();
                productChoice = true;
                break;
            }
        }
        if (productChoice == false){
            System.out.println("You have entered an invalid product number.\n" +
                    "Please, try it again");
            productChoice(productsList);
        }
        return purchasePrice;
    }

    public static void viewProduct(List<Product> productsList){
        System.out.print("Select product number to view information: ");
        int idInput = choiceInt ();
        boolean productChoice = false;
        for (Product item: productsList
        ) {
            if (item.getId() == idInput) {
                System.out.println(item.toString());
                productChoice = true;
                break;
            }
        }
        if (productChoice == false){
            System.out.println("You have entered an invalid product number.\n" +
                    "Please, try it again");
            viewProduct(productsList);
        }
    }

    public static void addProduct (List<Product> productsList) {
        int currentId = productsList.size() +1;
        String newName = inputProductName();
        double newPrice = Double.valueOf(inputProductPrice());
        String newDescription = inputProductDescription();
        Product newProduct = new Product(currentId, newName, newPrice, newDescription);
        productsList.add(newProduct);
    }

    public static void changeProduct(List<Product> productsList){
        System.out.print("Select product number to change: ");
        int idInput = choiceInt ();
        boolean productChoice = false;
        for (Product item: productsList
        ) {
            if (item.getId() == idInput) {

                String newName = inputProductName();
                double newPrice = Double.valueOf(inputProductPrice()) ;
                String newDescription = inputProductDescription();
                item.setName(newName);
                item.setPrice(newPrice);
                item.setDescription(newDescription);
                productChoice = true;
                break;
            }
        }
        if (productChoice == false){
            System.out.println("You have entered an invalid product number.\n" +
                    "Please, try it again");
            changeProduct(productsList);
        }
    }


}
