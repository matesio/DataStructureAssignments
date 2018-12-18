
package pkg;

/**
 *
 * @author Hammad
 */
public class ProjectGraph2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            

        Graph g = new Graph();
        g.getPrevoiusCity();
        g.getPrevoiusRoad();
        
        
        g.addVertex("Karachi","30351","61612");
        g.addVertex("Lahore",null,null);
        g.addVertex("Peshawar",null,null);
        g.addVertex("Torkham",null,null);
        g.addVertex("kamalia",null,null);
          
        
        g.addEdges("Karachi","Lahore",1819,"N-5","31824","368131","Highway");
        g.addEdges("Lahore","Peshawar",1819,"N-5","35184","51842","Highway");
        g.addEdges("Peshawar","Torkham",1819,"M-5","11351","35135","Motorway");
        g.addEdges("Peshawar","kamalia",1819,"M-6","24461","51545","Motorway");
        
        
        g.deleteVertex("Karachi");
          g.deleteVertex("Lahore");
           g.editVertex("Karachi", "India");
          g.editEdge("N-5","M-97");        
          g.deleteVertex("Karachi");
          g.getRoads("Motorway");
       g.display2();
        g.saveDataToDisk();
                
    }
    
}
