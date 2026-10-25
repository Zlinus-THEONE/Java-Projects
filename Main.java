import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productInventoryList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String productName; // Titled name of the product
        double productPrice; // The Price (Peso) of the product
        int productStock; // The Quantity of the product

        int productID; // User input of Index
        int quantityPurchased; // How many products will the customer buy

        double TOTALRevenue = 0.0; // The general total revenue made in all the products
        double saleRevenue; // A specific revenue made in a product

        int TOTALUnitsSold = 0; // The general total products sold

        boolean KeepGoing = true; // False or true

        System.out.println("=====================================");
        System.out.println("Welcome to the RIAS System!");
        System.out.println("=====================================");
        System.out.println("----------------------------------------------------------------");
        System.out.println("[1] Add Product");
        System.out.println("[2] Remove Product");
        System.out.println("[3] View Inventory");
        System.out.println("[4] Record Sale");
        System.out.println("[5] View Sale Analytics");
        System.out.println("[6] Quit");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Choose from 1-6 commands in the list");
        System.out.println("----------------------------------------------------------------");
        System.out.println();


        // The starting loop
        while (KeepGoing) {
            try {
                System.out.print("Enter a Command: ");
                int command = input.nextInt();
                System.out.println("=====================================");
                input.nextLine();

                // Switch ( If user command == 1, it will go to case 1)
                switch (command) {
                    case 1: // ADD PRODUCT
                        System.out.print("[+] Enter Product Name: ");
                        productName = input.nextLine();

                        System.out.print("- Price:  ₱");
                        productPrice = input.nextDouble();

                        System.out.print("- Stock : ");
                        productStock = input.nextInt();
                                                            // String       //Double    //Int
                        productInventoryList.add(new Product(productName, productPrice, productStock));
                        System.out.println("=====================================");
                        System.out.println("Product ADDED successfully!");
                        break;

                    case 2: // REMOVE PRODUCT
                        System.out.print("Enter Product ID: P0");
                        productID = input.nextInt();
                        System.out.println("=====================================");

                        // IF USER INPUT OF INDEX IS NOT 0 OR NEGATIVE AND IF IT'S LESSER THAN THE SIZE OF THE INVENTORY
                        if (productID >= 0 && productID < productInventoryList.size()) {
                            System.out.println(productInventoryList.get(productID).getName() + " REMOVED successfully!");

                            productInventoryList.remove(productID);
                        } else {
                            System.out.println("Invalid Product ID! Try again!");
                        }
                        break;

                    case 3: // VIEW INVENTORY
                        System.out.println("----------------------------------------------------------------");
                        if  (productInventoryList.isEmpty()) {
                            System.out.println("There are no products in the inventory.");
                        } else {
                            for (int i = 0; i < productInventoryList.size(); i++) {
                                System.out.println("PRODUCT ID [ P0" + i + " ]");
                                System.out.println("Product Name: " + productInventoryList.get(i).getName());

                                System.out.println("+ Price: ₱" +  productInventoryList.get(i).getPrice());
                                System.out.println("+ Stock: " +  productInventoryList.get(i).getStock());
                                System.out.println("----------------------------------------------------------------");
                                System.out.println();
                            }
                        }
                        break;

                    case 4: // RECORD SALE
                        System.out.print("Enter Product ID: P0");
                            productID = input.nextInt(); // Index 10 na product
                        System.out.println("=====================================");

                        if (productID >= 0 && productID < productInventoryList.size()) {
                            System.out.print("Enter Quantity Purchased: ");
                            quantityPurchased =  input.nextInt();

                            if (quantityPurchased > productInventoryList.get(productID).getStock() || quantityPurchased <= 0) {
                                System.out.println("Unsufficient stock! Try again!");
                            } else {
                                saleRevenue = productInventoryList.get(productID).getPrice() * quantityPurchased;
                                System.out.println("Calculation: " + quantityPurchased + " x " +  productInventoryList.get(productID).getPrice() + " = " +  saleRevenue);
                                System.out.println("TOTAL SALE REVENUE: " + saleRevenue);

                                productInventoryList.get(productID).recordSale(quantityPurchased);

                                TOTALRevenue += saleRevenue; // General na pera nakuwa
                                TOTALUnitsSold += quantityPurchased; // General nawala na stock
                            }
                        }

                        break;

                    case 5:  // SALE ANALYTICS RECORD
                        System.out.println("Sales Analytic Record");
                        System.out.println("----------------------------------------------------------------");
                        System.out.print("+ TOTAL Revenue: ₱" + TOTALRevenue + "    |||   ");
                        System.out.println(" + TOTAL Units Sold: " + TOTALUnitsSold);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println();

                        for (Product product: productInventoryList) {
                            System.out.println("PRODUCT NAME: " +  product.getName());
                            System.out.println("+ Stocks Left: " +  product.getStock());
                            System.out.println("+ Sold units: " + product.getUnitsSold());
                            System.out.println("+ Revenue made: ₱" + product.getRevenue());
                            System.out.println("----------------------------------------------------------------");
                        }

                        break;

                    case 6: // QUIT
                        System.out.println("=====================================");
                        System.out.println("Thank you for using the RIAS System!");
                        System.out.println("=====================================");
                        KeepGoing = false;
                        break;

                    default: // INVALID COMMAND ENTERED
                        System.out.println("=====================================");
                        System.out.println("Invalid Command! Try again!");
                }


                System.out.println("=====================================");
                System.out.println();


            } catch (InputMismatchException e) {
                // WRONG DATA TYPE ENTERED
                System.out.println("=====================================");
                System.out.println("Invalid Input! Try again!");
                System.out.println("=====================================");
                System.out.println();
                input.nextLine();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("=====================================");
                System.out.println("Out of bounds! Try again!");
                System.out.println("=====================================");
                System.out.println();
            } catch (Exception e) {
                // ANY KIND OF ERRORS
                System.out.println("=====================================");
                System.out.println("Something went wrong! Try again!");
                System.out.println("=====================================");
                System.out.println();
            }
        }
    }
}