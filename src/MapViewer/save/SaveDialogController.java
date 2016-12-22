package MapViewer.save;

import java.io.IOException;

import MapViewer.MainMapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SaveDialogController {

	@FXML private Button okButton;
	
	@FXML
	private void okButtonClicked(ActionEvent event) {
		Stage stage = (Stage) okButton.getScene().getWindow();
	    stage.close();
		
	}
}
