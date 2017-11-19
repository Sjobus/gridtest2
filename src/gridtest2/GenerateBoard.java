/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author sibev
 */
public class GenerateBoard {
    public ArrayList<Position> positionsList;
    
    public ArrayList<Position> getBoard(int collums, int rows){
        int xCoord = 50;
        int yCoord = 25;
        Position pos;
        positionsList = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < collums; j ++){
                if(xCoord == 50){
                   pos = new Position(xCoord,yCoord,true);
                }
                else{
                    pos = new Position(xCoord,yCoord,isWalkable());
                }
                xCoord = xCoord + 32;
                positionsList.add(pos);
            }
            xCoord= 50;
            yCoord = yCoord + 32;
        }
        return positionsList;
    }
    
    public boolean isWalkable(){
        Random r = new Random();
        if(r.nextFloat() <= 0.30f)
        return false;
        else
            return true;
    }
}
