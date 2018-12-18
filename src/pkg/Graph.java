/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgraph2;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Hammad
 */
public class Graph{

    public LinkedList<Vertex> vertices;
    WriteData wd = new WriteData(); 
    public Graph() {
        vertices = new LinkedList();
    }
  public void addVertex(String city,String Latitude,String longitude){

      Vertex a = new Vertex();
      a.setCity(city);
      a.setLatitude(Latitude);
      a.setLongitude(longitude);
      vertices.addLast(a);
//      wd.insertCityInfo(cityInfo);
      
      
  }
  public void addEdges(String city1,String city2,int weight,String roadName,String Longitude,String Latitude,String roadType){
      Vertex c = find(city1);
      Vertex d = find(city2);
      if(c!=null&&d!=null){
      Edge e = new Edge();
      e.endVertex=d;
      e.weight=weight;
      e.roadName=roadName;
      e.setLatitude(Latitude);
      e.setLongitude(Longitude);
      e.setRoadType(roadType);
      c.edges.addLast(e);
      }
      else{
          System.out.println("No vertex to Connect");
      }
      
      
  }
  public void adjusent(String b){
            Vertex v = find(b);
      if(v!=null){      
        for (Vertex vertice : vertices) {
            if (vertice == v) {
                for (Edge edge : vertice.edges) {
                    System.out.println(edge.endVertex.getCity());
                }
            } else {
                for (Edge edge : vertice.edges) {
                    if (edge.endVertex == v) {
                        System.out.println(vertice.getCity());
                    }
                    
                }
            }
        }
      }
      else{
          System.out.println("Vertex Not Found");
      }
  }
  public void getRoads(String roadType){
       for (Vertex vertex : vertices) {
            for(Edge edge: vertex.edges){
                 if(edge.getRoadType().equals(roadType)){
                     System.out.println("successor="+vertex.getCity()+" connector="+edge.endVertex.getCity()+"Roadname="+edge.roadName+" Roadtype="+edge.getRoadType()+" Latitude="+edge.getLatitude()+" Longitude="+edge.getLongitude());
                     
                 }
            }
                }
  }
  public Vertex find(String a){
      
      int v = vertices.size()-1;
      
      while(!vertices.get(v).getCity().equals(a) && v>=0){
          v--;
          if(v<0)
          {
              return null;      
          }
      
        }
      return  vertices.get(v);
  }
  public Edge findEdge(String key){
      Edge found=null;
      
    for(Vertex vertex : vertices){
       for(Edge edge : vertex.edges){
           if(edge.roadName.equals(key)){
               found=edge;
           }
       }
    }
    return found;
  }
  public int findIndex(String a){
      
      int v = vertices.size()-1;
      while(!vertices.get(v).getCity().equals(a) && v>=0)
      {
          v--;
          if(v<0)
          {
              return -1;
              
          }
      }
      return  v;
  }
  public void deleteVertex(String b){
      int k=-1;
       for(int j=0;j<vertices.size();j++){
          if(!vertices.get(j).getCity().equals(b)){
              
              for (int i=0;i<vertices.get(j).edges.size();i++) {
                  if(vertices.get(j).edges.get(i).endVertex.getCity().equals(b)){

                       vertices.get(j).edges.remove(i);
                  } 
              }
          }
          else{
            k=j; 
          }
          }
       if(k!=-1){
       vertices.remove(k);
       }
       else{
           System.out.println("not vertex found");
       }
      }
  public void editVertex(String a,String b){
      if(find(a)!=null){
        find(a).setCity(b);
      }
      else{
          System.out.println("no vertex found");
      }
  }
  public void deleteEdge(String key){
      
        for (Vertex vertice : vertices) {
            for (int j = 0; j < vertice.edges.size(); j++) {
                if (vertice.edges.get(j).roadName.equals(key)) {
                    vertice.edges.remove(j);
                    
                }
                
            }
            
        }  
  }
  public void editEdge(String a,String b){
       for (Vertex vertice : vertices) {
            for (int j = 0; j < vertice.edges.size(); j++) {
                if (vertice.edges.get(j).roadName.equals(a)) {
                    vertice.edges.get(j).roadName=b;
                    
                }
                
            }
            
        }
  }
  public void deleteEdge(String a,String b){
        for (Vertex vertex : vertices) {
            if(vertex.getCity().equals(a)){
                for(int i=0;i<vertex.edges.size();i++){
                     if(vertex.edges.get(i).endVertex.getCity().equals(b)){ 
                         vertex.edges.remove(i);
                          
                       }
                }
            }
        }
  }
  public void display(){
        for (Vertex vertex : vertices) {
            System.out.println("Successor=" + vertex.getCity());
            for(Edge edge: vertex.edges){
                System.out.println(edge.roadName);
                System.out.println("connector="+edge.endVertex.getCity());
                
            }
                }
  }
  public void display2(){
           for (Vertex vertex : vertices) {
            System.out.println("Successor=" + vertex.getCity()+" Latitude="+ vertex.getLatitude() +" Longitude="+ vertex.getLongitude());
            for(Edge edge: vertex.edges){
                System.out.print("Roadname="+edge.roadName+" Roadtype="+edge.getRoadType()+" Latitude="+edge.getLatitude()+" Longitude="+edge.getLongitude());
                System.out.println(" connector="+edge.endVertex.getCity());
                
            }
                }
  }
  public void getPrevoiusCity(){
      try{
          wd. infoReader = new CSVReader(new FileReader(wd.file1), ',','"',0);
        }
        catch(IOException e){
          e.getMessage();
        }
       String [] nextLine;
       try{
           while((nextLine=wd.infoReader.readNext())!=null){
            if(nextLine!=null){ 
               addVertex(nextLine[0],nextLine[1],nextLine[2]);
            }
            
        }
       }
       catch(Exception e){
           System.out.println("no previous city int InsertNewCity");
       }
       wd.closeCityFile();
    }
  public void getPrevoiusRoad(){
      try{
            wd.roadReader = new CSVReader(new FileReader(wd.file2), ',','"',0);
        }
        catch(IOException e){
          e.getMessage();
        }
        String [] nextLine;
       try{
           while((nextLine=wd.roadReader.readNext())!=null){
            if(nextLine!=null){      
               addEdges(nextLine[0],nextLine[2],Integer.parseInt(nextLine[3]),nextLine[1],nextLine[4],nextLine[5],nextLine[6]);
            
            }
            
        }
       }
       catch(Exception e){
           System.out.println("no prevoius road in insertNewRoad");
       }
       wd.closeCityFile();
  }
  public void saveDataToDisk(){
      LinkedList<String []> cityList = new LinkedList();
      LinkedList<String []> roadList = new LinkedList();
      for(Vertex x :vertices){
          for(Edge e: x.edges){
             String[] str = {x.getCity(),e.roadName,e.endVertex.getCity(),String.valueOf(e.weight),e.getLatitude(),e.getLongitude(),e.getRoadType()};
             roadList.add(str);
          }
          String[] str = {x.getCity(),x.getLatitude(),x.getLongitude()};
          cityList.add(str);
        }
      wd.insertCity(cityList);
      wd.insertRoad(roadList);
      

   }
  
  
  }
  

  

