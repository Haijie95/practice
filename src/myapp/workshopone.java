package myapp; //same name as folder

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class workshopone {  //same name as file
    
    public static void main(String[] args){
        
        //create list for fruits
        List<String> listOfFruits=new LinkedList<>();
        String input="";
        Console cons=System.console();

        System.out.println("Welcome to your shopping cart");

        //Boolean stop = false;
        //while(!stop){}

        while(!input.equals("exit")){
                        
            input=cons.readLine();
            String[] arrOfFruits =input.trim().split(" "); //will get ["add","apple"]
            //System.out.println(arrOfFruits[1]);
            if(arrOfFruits[0].equals("add")){ //add apple orange pear //add " " display error message
                if(listOfFruits.contains(arrOfFruits[1])){
                    System.out.printf("You have %s in your cart\n",arrOfFruits[1]);
                } else{
                    listOfFruits.add(arrOfFruits[1]);
                    System.out.printf("%s added to cart\n",arrOfFruits[1]);
                }
            }
            else if(arrOfFruits[0].equals("delete")){ //delete empty 
                if(Integer.parseInt(arrOfFruits[1])>listOfFruits.size()){
                    System.out.println("Incorrect Item Index");
                } else{
                    System.out.printf("%s removed from cart\n",listOfFruits.get(Integer.parseInt(arrOfFruits[1])-1));
                    listOfFruits.remove(Integer.parseInt(arrOfFruits[1])-1);
                }
            }
            else if(arrOfFruits[0].equals("list")){
                if(listOfFruits.size()<=0){
                    System.out.println("Your cart is empty");
                } else{
                    for(Integer index=0;index<listOfFruits.size();index++){
                        System.out.printf("%d. %s\n",index+1,listOfFruits.get(index));        
                    }
                }
                
            }
        System.out.println("Thank you for shopping with us <3");    
            /*
            switch(arrofFruits[0]){
                case"list":
                    for(Integer index=0;index<listOfFruits.size();index++){
                        System.out.printf("%d. %s\n",index+1,listOfFruits.get(index));
                    break;
                case"add":
                    cart.add(term[1]);
                    System.out.printf("Added %s to cart\n",terms[1])
                    break;
                case"delete"
                    break;
                case"exit"
                    stop=true;
                    break;
                default: System.err.printf("Unknown command: %s\n",terms[0]);
            
            
            }
             */



        }
    }
    
}

