/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sibev
 */
public class PathFinder implements Runnable {
    private ArrayList<Position> posList;
    private ArrayList<Position> openList;
    private ArrayList<Position> closedList;    
    private Position startPos;
    private Position endPos;
    private Position currentPos;
    
    public boolean endBereikt = false;
    //public Position cameFrom;
    
    PathFinder(){}
    
    PathFinder (ArrayList<Position> posList){
        this.posList = posList;
        this.startPos = posList.get(0);
        this.endPos = posList.get(1499); 
        System.out.println("pathfinder gemaakt");
    }
    
    public void setPosList(ArrayList<Position> posList){
        this.posList = posList;
    }
    
    public void findPathSetUp(){
        startPos = posList.get(0);
        endPos = posList.get(posList.size()-1);
        openList = new ArrayList<>();
        closedList = new ArrayList<>();
        openList.add(startPos);
        currentPos = startPos;
        startPos.gScore = 0;  // The cost of going from start to start is zero.
        startPos.hScore = Math.subtractExact((endPos.xPos - startPos.xPos),(endPos.yPos - startPos.yPos)); //afstand van de start node naar de end node
        startPos.fScore = startPos.gScore + startPos.hScore; // daadwerkelijke kosten.
        findPath();
    }
    
    public void findPath(){
        
        
        // filter out obsticals and calculate the scores for every pos in open list        
        while(openList.isEmpty() == false){
            for (Iterator<Position> it = openList.iterator(); it.hasNext();) {                                 
                Position p = it.next();
                if(p.walkable == false){
                        closedList.add(p);
                        openList.remove(p);                    
                        //System.out.println("obstical added to closedList");
                    }
                    if(closedList.contains(p)){
                        //System.out.println("zit in closed list");
                        break;
                    }
                    if(currentPos == endPos){
                        //doe iets
                        endBereikt = true;
                        System.out.println("einde berijkt");
                    }
                    else
                    {
                        p.gScore = Math.subtractExact((p.xPos - currentPos.xPos),(p.yPos - currentPos.yPos));
                        p.hScore = Math.subtractExact((p.xPos - endPos.xPos),(p.yPos - endPos.yPos));
                        p.fScore = p.gScore + p.hScore;
                        if(p.fScore < currentPos.fScore){
                            openList.remove(currentPos);
                            closedList.add(currentPos);                        
                            p.cameFrom = currentPos;
                            currentPos = p;                        
                            System.out.println("current position updated");
                            //getAdjecent(currentPos);
                            findPath();
                            
                        }
                    }
                }
            //get adjecent positions
            for(Iterator<Position> iter = posList.iterator(); iter.hasNext();){
                Position pos = iter.next();
                if(openList.contains(pos)){
                    System.out.println("heb ik al in open");
                    //iter.remove();
                }
                if(closedList.contains(pos)){
                    System.out.println("heb ik al in closed");
                }
                else if(pos.xPos == currentPos.xPos + 20 && pos.yPos == currentPos.yPos || pos.xPos == currentPos.xPos - 20 && pos.yPos == currentPos.yPos ||
                pos.xPos == currentPos.xPos  && pos.yPos == currentPos.yPos + 20 || pos.xPos == currentPos.xPos  && pos.yPos == currentPos.yPos - 20 ){
                    openList.add(pos);
                    System.out.println("position toegevoegd aan de openlist");
                }
            }
        }
    }   

    public void getAdjecent(Position position){        
        for(Position p : posList) {
                if(openList.contains(p)){
                    System.out.println("heb ik al in open");
                }
                if(closedList.contains(p)){
                    System.out.println("heb ik al in closed");
                }
                else if(p.xPos == position.xPos + 20 && p.yPos == position.yPos || p.xPos == position.xPos - 20 && p.yPos == position.yPos ||
                        p.xPos == position.xPos  && p.yPos == position.yPos + 20 || p.xPos == position.xPos  && p.yPos == position.yPos - 20 ){
                    openList.add(p);
                    System.out.println("position toegevoegd aan de openlist");
                }
            }
    }
        //current := the node in openSet having the lowest fScore[] value
        //if current = goal
            //return reconstruct_path(cameFrom, current)

        //openSet.Remove(current)
        //closedSet.Add(current)

        //for each neighbor of current
            //if neighbor in closedSet
                //continue		// Ignore the neighbor which is already evaluated.

            //if neighbor not in openSet	// Discover a new node
                //openSet.Add(neighbor)
            
            // The distance from start to a neighbor
            //tentative_gScore := gScore[current] + dist_between(current, neighbor)
            //if tentative_gScore >= gScore[neighbor]
                //continue		// This is not a better path.

            // This path is the best until now. Record it!
           // cameFrom[neighbor] := current
            //gScore[neighbor] := tentative_gScore
            //fScore[neighbor] := gScore[neighbor] + heuristic_cost_estimate(neighbor, goal) 

    //return failure
    @Override
    public void run() {
        try{
            while(!endBereikt){
                findPathSetUp(); 
            }
        }
        catch(Exception e){
            
        }
        finally{
            
        }
       
    }
}
