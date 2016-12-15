package MapViewer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by Nisali Kularatne on 16/12/2016.
 */
public class TileMap {

    private int[][] map;
    public Image tileSheet;
    private int tileSize;
    private int numCols;
    private int numRows;

    //TileMapIndexes constructor
    public TileMap(int tileSize)

    {
        this.tileSize = tileSize;
    }


    //load and get the map layout form map file
    public void loadMap(String mapSourcePath){
        try{
            InputStream in = getClass().getResourceAsStream(mapSourcePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //the first two lines are the height and width of map
            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());
            map = new int[numRows][numCols];
            String delims = "\\s+";
            for (int row = 0; row < numRows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delims);
                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }

        }catch(NumberFormatException | IOException ex){
            System.err.println(ex);
        }
    }
    //function to return all the images required
    public Image loadImage(String tilePath)

    {
        return new Image(tilePath);
    }

    //draw the map using the tileset image which is loaded from loadImage
    public void drawMap(GraphicsContext g){
        tileSheet=loadImage("/Tilesets/testtileset.gif");
        for(int row=0;row<map.length; row++){
            for(int col=0; col<map[row].length; col++){
                int origin = map[row][col];
                int yOffsetHeight=0;

                if(origin >= (tileSheet.getWidth()/tileSize)){
                    yOffsetHeight++;
                    origin = (int) (origin-(tileSheet.getWidth()/tileSize));
                }

                g.drawImage(tileSheet, origin*tileSize, yOffsetHeight*tileSize, tileSize, tileSize ,col*tileSize , row*tileSize, tileSize, tileSize);
            }
        }
    }
}


