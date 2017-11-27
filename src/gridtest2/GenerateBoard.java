/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.text.Text;

/**
 *
 * @author sibev
 */
public class GenerateBoard {
    public ArrayList<Position> positionsList;
    
    public ArrayList<Position> getBoard(int collums, int rows){
        int xCoord = 50;
        int yCoord = 25;
        int nr = 0;
        Text nummer;
        Position pos;
        positionsList = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < collums; j ++){
                if(j == 0 || collums -j ==1  ){
                    nummer = new Text("" + nr);
                   pos = new Position(xCoord,yCoord,true,nummer);
                   nr++;
                   //System.out.println("x :" + pos.xPos + " y: "+ pos.yPos);
                }
                else{
                    nummer = new Text("" + nr);
                    pos = new Position(xCoord,yCoord,isWalkable(),nummer);
                    nr ++;
                }
                xCoord = xCoord + 20;
                positionsList.add(pos);
                //System.out.println("index: " + positionsList.indexOf(pos));
            }
            xCoord= 50;
            yCoord = yCoord + 20;
        }
        return positionsList;
    }
    
    public boolean isWalkable(){
        Random r = new Random();
        if(r.nextFloat() <= 0.20f)
        return false;
        else
            return true;
    }
}
