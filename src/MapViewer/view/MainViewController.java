package MapViewer.view;

import java.io.IOException;

import com.neet.DiamondHunter.Main.Game;

import MapViewer.MainMapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {
	
	private MainMapView main;
	private Game game;
	
	@FXML private Button playGameButton;
	@FXML private Button exitButton;
	
	@FXML
	private void goMapViewer() throws IOException {
		main.showMapView();
	}
	
	@FXML
	private void goPlayGame() {
		game.main(null);

	}
	
	@FXML
	public void exitStage(ActionEvent event) {
	    Stage stage = (Stage) exitButton.getScene().getWindow();
	    stage.close();
	}
}

