package MapViewer.save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class SaveDialogController {

	@FXML private Button okButton;
	
	@FXML
	private void okButtonClicked(ActionEvent event) {
		Stage stage = (Stage) okButton.getScene().getWindow();
	    stage.close();
		
	}
}
