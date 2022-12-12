package day03workshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;

public class CartDBinMemory {

    public HashMap<String,ArrayList<String>> userMap= new HashMap<String,ArrayList<String>>();

    public CartDBinMemory(String baseFolder){
        this.loadDataFromFiles(baseFolder);
    }

    public void loadDataFromFiles(String baseFolder){
        File f=new File(baseFolder);
        File[] filteredFiles = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir,String filename){
                return filename.endsWith(".db");
            }
        });
        if (filteredFiles.length==0){
            return;
        }

        for(File file: filteredFiles){
            String userkey=file.getName().replace(".db","");
            //read the contents of the file
            this.userMap.put(userkey,ReadFile(file));
        }

    }


    public ArrayList<String> ReadFile(File f){
        ArrayList<String> dataList=new ArrayList<String>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String line;
            while ((line=bf.readLine())!=null){
                line=line.trim();
                dataList.add(line);
            }
            bf.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return dataList;

    }
}
