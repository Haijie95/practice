package day03workshop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ShoppingCartDB {

    public static final String LOGIN="login";
    public static final String ADD="add";
    public static final String LIST="list";
    public static final String SAVE="save";
    public static final String EXIT="exit";
    public static final String USERS="users";
    //valid command
    public static final List<String> VALID_COMMANDS=Arrays.asList(LOGIN,ADD,LIST,SAVE,EXIT,USERS);


    private CartDBinMemory db;
    private String currentUser;
    private String baseFolder;

    public ShoppingCartDB(){
        this.baseFolder="db"; //by default
        this.setup();
        this.db=new CartDBinMemory(this.baseFolder);
    }
    public ShoppingCartDB(String baseFolder){
        this.baseFolder=baseFolder;
        this.setup();
        this.db=new CartDBinMemory(this.baseFolder);
    }

    public void setup(){
        Path p =Paths.get(this.baseFolder);
        if (Files.isDirectory(p)){
            //skip if directory exist
        } else{
            try{
                Files.createDirectory(p);
            }
            catch(IOException e){
                System.out.println("Error :"+e.getMessage());
            }
        }
    }

    public void startShell(){
        System.out.println("Welcome to multiuser shopping cart!");

        Scanner sc = new Scanner(System.in);
        //sc.nextLine(); //current line until end of the line
        //sc.next(); //word until whitespace
        //String commmand =sc.next();
        //String inputs = sc.nextLine();
        boolean stop=false;
        String line;
        
        //while ((line=sc.nextLine()) != null){
        while(!stop){
            //System.out.println(line);
            line=sc.nextLine();
            line=line.trim();
            System.out.println("-> "+line);

            if (line.equalsIgnoreCase("exit")){
                //return;
                System.out.print("Exiting!");
                stop=true;
            }

            //validate command
            if (!this.ValidateInput(line)){
                System.out.println("Invalid Input: ^^");
            }else{
                System.out.println("Processing : "+line);
                this.ProcessInput(line);
            } 
        }
        sc.close();
    }
    //validate command
    public boolean ValidateInput(String input){
        String[] parts = input.split(" ");
        String command = parts[0];
        return VALID_COMMANDS.contains(command);
        
    }
    //process command
    public void ProcessInput(String input){
        Scanner sc = new Scanner(input);
        String command =sc.next().trim();
        
        switch (command){
            case LOGIN:
                String username=sc.nextLine().trim();
                this.LogInAction(username);
                System.out.println("Current log in is "+username);
                break;

            case LIST:
                this.listAction();
                break;

            case SAVE:
                this.saveAction();
                break;

            case ADD:
            String[] items=sc.nextLine().trim().split(",");
            this.AddAction(items);
                break;

            case USERS:
                this.ListUserAction();
                break;

            default:
                break;

        }
        sc.close();
    }

    //log in action
    public void LogInAction(String username){
        if(!this.db.userMap.containsKey(username)){
            this.db.userMap.put(username,new ArrayList<String>());
        }
        this.currentUser=username;
    }
    //add
    public void AddAction(String[] items){
        for(String item: items){
            this.db.userMap.get(this.currentUser).add(item.trim());
        }
    }
    //list
    public void listAction(){
        for (String item: this.db.userMap.get(this.currentUser))
        System.out.println(("Item ->")+item);
    }
    //list user action
    public void ListUserAction(){
        for (String key: this.db.userMap.keySet()){
            System.out.println("->"+key);
        }
    }
    //save
    public void saveAction(){
        //get current user name
        String username=this.currentUser;
        //prepare the filepath = "db/<username>.db"
        String outputFilename=String.format("/%s/%s.db",this.baseFolder,this.currentUser);

        try{
            FileWriter fw = new FileWriter(outputFilename);
            //Save the contents for this user in Map to a file
            for (String item: this.db.userMap.get(this.currentUser)){
                fw.write(item+"\n");
            }
            fw.flush();
            fw.close();

        }
        catch(IOException e){
            e.printStackTrace();
            //save the contents for this user in Map to a file
        }
        

    }
}
