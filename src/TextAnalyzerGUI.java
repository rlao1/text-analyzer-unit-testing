import java.io.IOException;
import javafx.application.Application; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextAnalyzerGUI extends Application {
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("panel.fxml"));
		primaryStage.setTitle("Text Analyzer");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, 600.0, 500.0));
		primaryStage.show();
	}

	
	
}
