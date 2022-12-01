package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class workshopone {
    
    public static void main(String[] args){
        
        //create list for fruits
        List<String> listOfFruits=new LinkedList<>();
        String input="";
        Console cons=System.console();

        System.out.println("Welcome to your shopping cart");

        while(!input.equals("exit")){
                        
            input=cons.readLine();
            String[] arrOfFruits =input.trim().split(" ");
            //System.out.println(arrOfFruits[1]);
            if(arrOfFruits[0].equals("add")){
                if(listOfFruits.contains(arrOfFruits[1])){
                    System.out.printf("You have %s in your cart\n",arrOfFruits[1]);
                } else{
                    listOfFruits.add(arrOfFruits[1]);
                    System.out.printf("%s added to cart\n",arrOfFruits[1]);
                }
            }
            else if(arrOfFruits[0].equals("delete")){
                if(Integer.parseInt(arrOfFruits[1])>listOfFruits.size()){
                    System.out.println("Incorrect Item Index");
                } else{
                    System.out.printf("%s removed from cart\n",listOfFruits.get(Integer.parseInt(arrOfFruits[1])-1));
                    listOfFruits.remove(Integer.parseInt(arrOfFruits[1])-1);
                }
            }
            else if(arrOfFruits[0].equals("list")){
                if(listOfFruits.size()==0){
                    System.out.println("Your cart is empty");
                } else{
                    for(Integer index=0;index<listOfFruits.size();index++){
                        System.out.printf("%d. %s\n",index+1,listOfFruits.get(index));        
                    }
                }
                
            }

        }
    }
    
}
