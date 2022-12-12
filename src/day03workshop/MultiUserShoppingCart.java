package day03workshop;

//import day03workshop.ShoppingCartDB;

public class MultiUserShoppingCart {

    public static void main(String[] args) {
        System.out.println(("Welcome to the MultiUser Shopping Cart."));


        ShoppingCartDB cart = new ShoppingCartDB("cartdb"); //default folder: "db"
        cart.setup();
        cart.startShell();
        
    }
    
}
