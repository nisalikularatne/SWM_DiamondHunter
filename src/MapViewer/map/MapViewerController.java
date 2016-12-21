package MapViewer.map;

import MapViewer.Diamond;
import com.neet.DiamondHunter.GameState.PlayState;
import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.Manager.GameStateManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.*;

import MapViewer.Items;
import MapViewer.MainMapView;
import MapViewer.TileMap;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Nisali Kularatne on 16/12/2016.
 */
public class MapViewerController {

    private MainMapView main;

    @FXML AnchorPane anchorPane;
    @FXML Button defaultButton;
    @FXML Button saveButton;

    //togglebutton for AXE
    @FXML
    ToggleButton AXEbtn;
    //togglebutton for BOAT
    @FXML
    ToggleButton BOATbtn;

    @FXML
    Button backButton;

    //canvas for the MapViewer to be drawn
    @FXML
    Canvas canvasMapViewer;
    //create new Items objects to get the axe and boat
    private Items item = new Items();
    private int XaxeCoordinate;
    private int YaxeCoordinate;
    private int XboatCoordinate;
    private int YboatCoordinate;
    private TileMap tileMap;
    private int[][] index = null;
    private int mouseXcoordinate;
    private int mouseYcoordinate;
    private GraphicsContext g ;
    private Diamond diamond = new Diamond();


    //function to update the Axe position
    public void updateAxeCoordinate(int newAxeX, int newAxeY) {
        this.XaxeCoordinate = newAxeX;
        this.YaxeCoordinate = newAxeY;
        item.setAxeCoordinate(XaxeCoordinate, YaxeCoordinate);
    }

    //function to update the Boat Position
    public void updateBoatCoordinate(int newBoatX, int newBoatY){
        this.XboatCoordinate = newBoatX;
        this.YboatCoordinate = newBoatY;
        item.setBoatCoordinate(XboatCoordinate, YboatCoordinate);
    }
    //function to get the Map on the canvas sheet
    @FXML
    public void drawMap(){
        tileMap = new TileMap(16);
        tileMap.loadMap("/Maps/testmap.map");
        g = canvasMapViewer.getGraphicsContext2D();
        tileMap.drawMap(g);
        item.setPlayer(g);
        diamond.populateDiamond(g);
        item.setAxeCoordinate(XaxeCoordinate,YaxeCoordinate);
        item.setAxe(g);
        item.setBoatCoordinate(XboatCoordinate,YboatCoordinate);
        item.setBoat(g);
    }

    //check if the togglebutton axe is selected
    @FXML
    public void axeSelected()

    {
        AXEbtn.setSelected(true);
    }
    //check if the togglebutton boat is selected
    @FXML
    public void boatSelected()
    {
        BOATbtn.setSelected(true);
    }
    //mouse Click Event
    @FXML
    public void onMousePressed(){
        canvasMapViewer.setOnMousePressed(e -> {
            if (AXEbtn.isSelected()) {
                mouseXcoordinate = (int) (e.getX()/16);
                mouseYcoordinate = (int) (e.getY()/16);
                updateAxeCoordinate(mouseXcoordinate,mouseYcoordinate);
                g.clearRect(0, 0, 640, 640);
                drawMap();
                AXEbtn.setSelected(false);
            } else if (BOATbtn.isSelected()) {
                mouseXcoordinate = (int) (e.getX()/16);
                mouseYcoordinate = (int) (e.getY()/16);
                updateBoatCoordinate(mouseXcoordinate, mouseYcoordinate);
                g.clearRect(0,0,640,640);
                drawMap();
                BOATbtn.setSelected(false);
            }
        });
    }

    public void SaveCoordinates (){
        try{

            index[0][0]=YaxeCoordinate;
            index[0][1]=XaxeCoordinate;
            index[1][0]=YboatCoordinate;
            index[1][1]=XboatCoordinate;
            BufferedWriter bw = new BufferedWriter(new FileWriter("bin/SavePositions.txt"));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {

                    bw.write(index[i][j] + " ");

                }
                bw.newLine();
            }
            bw.flush();


        }
        catch(IOException e){

        }

    }
    //get the tilemap indexes from the File in resources
    public void TileMapIndexes(){

        readValueFromPositionFile();
        XaxeCoordinate = index[0][1];
        YaxeCoordinate = index[0][0];
        XboatCoordinate = index[1][1];
        YboatCoordinate = index[1][0];
        drawMap();
    }
    @FXML
    public void SaveButtonAction(){
        SaveCoordinates();

    }
    //Add default positions
    @FXML
    public void defaultMap(){
        g.clearRect(0, 0, 640, 640);//clear the canvas
        updateAxeCoordinate(37,26);
        updateBoatCoordinate(4, 12);
        drawMap();
    }
    //reaing the original Axe and Boat Positions from a File in Resources
    public void readValueFromPositionFile(){
        try{

            BufferedReader br = new BufferedReader(new FileReader(new File("bin/SavePositions.txt")));
            int row=0;
            int size=0;
            String line;
            while((line=br.readLine())!=null){

                String[] values = line.trim().split("\\s+");
                if(index == null){
                    size = values.length;
                    index = new int[size][size];
                }

                for(int col=0; col<size; col++){
                    index[row][col]=Integer.parseInt(values[col]);
                }
                row++;
            }

        }catch(NumberFormatException |IOException ex){
            System.err.println(ex);
        }

    }

    @FXML
    private void goMainView() throws IOException {
        main.showMain();
    }

}






