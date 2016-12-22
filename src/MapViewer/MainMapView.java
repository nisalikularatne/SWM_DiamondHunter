package MapViewer;

import java.io.IOException;

import MapViewer.map.MapViewerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Modality;
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
    
    public static void showSaveMessage() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainMapView.class.getResource("save/SaveDialog.fxml"));
    	Parent root  = (Parent) loader.load();
    	root.getStylesheets().add(MainMapView.class.getResource("save/SaveDialog.css").toExternalForm());
    	Stage dialog = new Stage();
    	dialog.initModality(Modality.APPLICATION_MODAL);
    	dialog.setTitle("Message");
    	dialog.setScene(new Scene(root));
    	dialog.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}