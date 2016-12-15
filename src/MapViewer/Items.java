package MapViewer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by Nisali Kularatne on 16/12/2016.
 */
public class Items
{
    private static Image axe;
    private static Image boat;
    private int Xboat;
    private int Yboat;
    private int Xaxe;
    private int Yaxe;
    public static Image player;
    private static int SIZE = 16;
    //returns image
    public Image loadItem(String ItemPath)
    {
        return new Image(ItemPath);
    }

    public void setAxe(GraphicsContext g)
    {
        axe= loadItem("/Sprites/items.gif");
        drawItem(g, axe, 16, 16, Xaxe, Yaxe);
    }


    public void setAxeCoordinate(int xCoordinate, int yCoordinates)
    {
        this.Xaxe = xCoordinate;
        this.Yaxe = yCoordinates;
    }
    public void setPlayer(GraphicsContext g){
        player=loadItem("/Sprites/playersprites.gif");
        drawItem(g, player, 0, 0, 17, 17);
    }

    public void setBoat(GraphicsContext g)
    {
        boat= loadItem("/Sprites/items.gif");
        drawItem(g, boat, 0, 16, Xboat, Yboat);
    }


    public void setBoatCoordinate(int xCoordinate, int yCoordinate)
    {
        this.Xboat = xCoordinate;
        this.Yboat = yCoordinate;
    }



    //crop the wanted image from tileset
    public void drawItem(GraphicsContext g, Image item, int sx, int sy, int xIndex, int yIndex){
        g.drawImage(item, sx, sy, SIZE,SIZE, xIndex*SIZE, yIndex*SIZE, SIZE, SIZE);
    }
}

