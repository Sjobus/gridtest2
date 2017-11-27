/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest2;


import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
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
    
    public Pane root;
    public Scene scene;
    public GenerateBoard board;
    public ArrayList<Position> posList;
    public PathFinder finder;
    
    public String url = "https://cdn1.epicgames.com/ue/item/FantasyDungeon_Screenshot_01-1920x1080-7edf6601ef279e2a6058740a22248a23.png";
    public Image img = new Image(url);
    public ImagePattern pattern = new ImagePattern(img);
    
    //voor pathfinding
    public ArrayList<Position> openList;
    public ArrayList<Position> closedList;    
    public Position startPos;
    public Position endPos;
    public Position currentPos;
    public Position cameFrom;
    
    
    @Override
    public void start(Stage primaryStage) {
       root = new Pane();
       scene = new Scene(root,1366,768,pattern); 
       Button newGridbutton = new Button("new grid");
        newGridbutton.setOnAction((ActionEvent e) -> {
           scene = null;           
           scene = getScene();
           root.getChildren().add(newGridbutton);
           primaryStage.setScene(scene);
           
        });        
        newGridbutton.relocate(1050,125);
        //newGridbutton.setLayoutY(125);        
        root.getChildren().add(newGridbutton);
       primaryStage.setTitle("Grids");
       primaryStage.setScene(scene);       
       primaryStage.show();       
    }
    
    public Scene getScene(){
        board = new GenerateBoard();
        root = new Pane();
        scene = new Scene(root,1366,768,pattern);        
        //scene.setFill(pattern);        
        posList = board.getBoard(5,3);
        for (Iterator<Position> it = posList.iterator(); it.hasNext();) {                                 
            Position pos = it.next();            
            Rectangle rec = pos.getGraphic();
            rec.relocate(pos.xPos, pos.yPos);
            root.getChildren().addAll(rec,pos.getText());
        }   
        Button startbutton = new Button("start");
        startbutton.setOnAction((ActionEvent e) -> {
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    finder = new PathFinder();
                    finder.setPosList(posList);
                    Thread thread = new Thread(finder);
                    thread.start();
                    
                }
            });
            
        });
        startbutton.relocate(1050,200);
        //startbutton.setLayoutX(1050);
        //startbutton.setLayoutY(200);
        
        root.getChildren().add(startbutton);
        return scene;        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
