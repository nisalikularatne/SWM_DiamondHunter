package MapViewer;

import java.io.IOException;

import MapViewer.map.MapViewerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class MainMapView extends Application{
	
	private Stage primaryStage;
	private static BorderPane mainLayout;
	

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Diamond Hunter Map Viewer");
        this.primaryStage.setResizable(false);
        this.primaryStage.getIcons().add(new Image("/Favicon/diamond.png"));
        showMainView();
        showMain();
    }
    
    private void showMainView() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainMapView.class.getResource("view/MainView.fxml"));
    	mainLayout = (BorderPane) loader.load();
    	Scene scene = new Scene(mainLayout);
    	scene.getStylesheets().add(getClass().getResource("view/MainView.css").toExternalForm());
    	Font.loadFont(getClass().getResource("/Font/Kemco Pixel Bold.ttf").toExternalForm(), 14);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
    
    public static void showMain() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainMapView.class.getResource("view/MainView.fxml"));
    	BorderPane mainView = loader.load();
    	mainLayout.setTop(mainView);
    }
    
    public static void showMapView() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainMapView.class.getResource("map/MapViewer.fxml"));
    	BorderPane mapView = loader.load();
    	MapViewerController controller = loader.getController();
    	controller.TileMapIndexes();
    	mainLayout.setTop(mapView);
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
}