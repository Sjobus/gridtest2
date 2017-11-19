/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sibev
 */
public class Gridtest2 extends Application {
    
    public Group root;
    public Scene scene;
    public GenerateBoard board;
    public ArrayList<Position> posList;
    @Override
    public void start(Stage primaryStage) {
       Scene scene = getScene();       
       primaryStage.setTitle("Hello World!");
       primaryStage.setScene(scene);
       primaryStage.setFullScreen(true);
             
       primaryStage.show();
    }
    
    public Scene getScene(){
        board = new GenerateBoard();
        root = new Group();
        scene = new Scene(root,1366,768,Color.WHITE);
        String url = "https://cdn1.epicgames.com/ue/item/FantasyDungeon_Screenshot_01-1920x1080-7edf6601ef279e2a6058740a22248a23.png";
        Image img = new Image(url);
        ImagePattern pattern = new ImagePattern(img);
        scene.setFill(pattern);
        String url2 = "https://s-media-cache-ak0.pinimg.com/originals/36/d6/74/36d67402fadcd4b5ba0b34513a277fac.jpg";
        Image img2 = new Image(url2);
        ImagePattern pattern2 = new ImagePattern(img2);
        posList = board.getBoard(50,30);
        for(Position pos : posList){
            Rectangle rec = pos.getGraphic();
            if(pos.walkable){
                rec.setFill(pattern2);
                root.getChildren().add(rec);
            }
            else{
                root.getChildren().add(pos.getGraphic());
            }
        }        
        return scene;        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
