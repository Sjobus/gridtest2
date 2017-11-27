/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;

/**
 *
 * @author sibev
 */
public class Position extends Rectangle {
    public int xPos;
    public int yPos;
    public boolean walkable;
    public boolean isStart = false;
    public boolean isEnd = false;
    
    public int gScore; // distance from this node to the start node
    public int hScore; // distance from this node to the end node
    public int fScore; // gScore + hScore
    
    public Text nummer;
    
    public Position cameFrom;
    Position(int x, int y, boolean walkable,Text nummer){
        this.xPos = x;
        this.yPos = y;
        this.walkable = walkable;
        this.nummer = nummer;
        if(this.xPos == 50 && this.yPos == 25){
            this.isStart = true;
        }
        if(this.yPos == 65 && this.xPos == 130){
                isEnd = true;
            }
        if(this.xPos == 1030 && this.yPos == 605){
            this.isEnd = true;
        }
        
        
    }
    
    public Rectangle getGraphic(){
        Rectangle rec = new Rectangle(xPos,yPos,20,20);
        if(walkable && !isEnd && !isStart){
            rec.setFill(Color.WHITE);
        }
        else if(isStart){
            rec.setFill(Color.CORNFLOWERBLUE);
        }
        else if(isEnd){
            rec.setFill(Color.FIREBRICK);
        }
        else{
            rec.setFill(Color.BLACK);
        }
        rec.setStroke(Color.DARKGRAY);
        rec.setStrokeWidth(2);      

        return rec;            
    }
    
    public Text getText(){
        return nummer;
    }
}
