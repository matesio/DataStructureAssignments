package pkg;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Hammad
 */
public class WriteData {
    String file1 = "info.csv";
    String file2 = "road.csv";      
    CSVWriter infoWriter ;
    CSVReader infoReader ;
    CSVWriter roadWriter ;
    CSVReader roadReader ;
    public WriteData(){
         infoWriter = null;
         infoReader = null;
         roadWriter = null;
         roadReader = null;
    }

    public void readCityInfo() {
       try{
            infoReader = new CSVReader(new FileReader(file1), ',','"',0);
        }
        catch(IOException e){
          e.getMessage();
        }
        String [] nextLine;
       try{
           while((nextLine=infoReader.readNext())!=null){
            if(nextLine!=null){
                
               System.out.println(Arrays.toString(nextLine));
            }
            
        }
       }
       catch(IOException e){
           System.out.println(e.getMessage()+"in readCityInfo");
       }
       closeCityFile();
    }
    public void readRoadInfo() {
       try{
            roadReader = new CSVReader(new FileReader(file2), ',','"',0);
        }
        catch(IOException e){
          e.getMessage();
        }
        String [] nextLine;
       try{
           while((nextLine=roadReader.readNext())!=null){
            if(nextLine!=null){
                
               System.out.println(Arrays.toString(nextLine));
            }
            
        }
       }
       catch(Exception e){
         System.out.println(e.getMessage()+"in readCityInfo");
       }
       closeCityFile();
    }
    
    public void closeCityFile(){
      try{
        infoWriter.close();
        infoReader.close();
        }
        catch(Exception e){
//          System.out.println(e.getMessage()+"in closeCityFile");
        }
    }
    public void closeRoadFile(){
      try{
        roadWriter.close();
        roadReader.close();
        }
        catch(Exception e){
//            System.out.println(e.getMessage()+"in closeRoadFile");
        }
    }
    public void insertCity(LinkedList<String []> list){
     try{
            infoWriter = new CSVWriter(new FileWriter(file1,false));
        }
        catch(IOException e){
            System.out.println(e.getMessage()+"in insertCityNewInfo");
        }
      infoWriter.writeAll(list);
      closeCityFile();
    }
    public void insertRoad(LinkedList<String []> list){
     try{
            roadWriter = new CSVWriter(new FileWriter(file2,false));
        }
        catch(IOException e){
            System.out.println(e.getMessage()+"in insertRoadNewInfo");
        }
      roadWriter.writeAll(list);
      closeRoadFile();
    }
}
