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
import javafx.scene.transform.Scale;

/**
 *
 * @author sibev
 */
public class Position {
    public int xPos;
    public int yPos;
    public boolean walkable;
    //Image floor = new Image("https://orig00.deviantart.net/16ec/f/2013/345/7/b/dungeon_floor_by_sharandra-d6xlhqd.png");
    //ImagePattern floorPattern = new ImagePattern(floor);
    
    Position(int x, int y, boolean walkable){
        this.xPos = x;
        this.yPos = y;
        this.walkable = walkable;
        
    }
    
    public Rectangle getGraphic(){
        Rectangle rec = new Rectangle(xPos,yPos,32,32);
        if(walkable)
            
            rec.setFill(Color.WHITE);
        else
            rec.setFill(Color.BLACK);
        rec.setStroke(Color.DARKGRAY);
        rec.setStrokeWidth(2);
        
        Scale scale = new Scale();
        scale.setPivotX(50);
        scale.setPivotY(50);
        rec.getTransforms().add(scale);
        
        return rec;            
    }
}
