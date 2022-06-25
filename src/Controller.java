import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private ListView<String> resultView;
	
	public void handleAnalyzeClick() throws IOException 
	{
		TextAnalyzer obj = new TextAnalyzer();
		resultView.getItems().addAll(obj.getList());
	}

	public void clearResultView() throws IOException 
	{
		resultView.getItems().clear();
	}
	
}
