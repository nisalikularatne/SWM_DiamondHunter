package MapViewer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by Nisali Kularatne on 17/12/2016.
 */


public class Diamond {
    public static Image diamond_Image;
    public int size = 16;

    //get the image from resource file
    public Image loadDiamond(String spritePath){
        return new Image(spritePath);
    }

    public void populateDiamond(GraphicsContext g){
        Diamond diamond = new Diamond();
        diamond_Image =loadDiamond("/Sprites/diamond.gif");
        diamond.drawDiamond(g, 20, 20);
        diamond.drawDiamond(g, 4, 28 );
        diamond.drawDiamond(g, 36, 12 );
        diamond.drawDiamond(g, 34, 4 );
        diamond.drawDiamond(g, 19, 28 );
        diamond.drawDiamond(g, 26, 35 );
        diamond.drawDiamond(g, 36, 38 );
        diamond.drawDiamond(g, 28, 27 );
        diamond.drawDiamond(g, 30, 20 );
        diamond.drawDiamond(g, 25, 14 );
        diamond.drawDiamond(g, 21, 4 );
        diamond.drawDiamond(g, 14, 9 );
        diamond.drawDiamond(g, 3, 4 );
        diamond.drawDiamond(g, 14, 20 );
        diamond.drawDiamond(g, 20, 13 );
    }

    //draws the diamonds on the map
    public void drawDiamond(GraphicsContext g, int xIndex, int yIndex){

        g.drawImage(diamond_Image, 0, 0, size,size, xIndex*size, yIndex*size, size, size);

    }
}
