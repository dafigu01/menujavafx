import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import java.io.FileWriter;
import java.util.Date;
import javafx.scene.paint.Color;

public class MenuBar extends Application {
	
	@Override
	public void start(Stage menuStage) throws Exception {
		TextField datedisplay = new TextField("");
		menuStage.setTitle("Creating a User Interface I");
		
		
		MenuItem date = new MenuItem("Time & Date");
		MenuItem printdata = new MenuItem("Print Data");
		MenuItem changecolor = new MenuItem("Change Background Color");
		MenuItem endprogram = new MenuItem("Exit");
		
		MenuButton menuselect = new MenuButton("Menu", null, date, printdata, changecolor, endprogram);
		
		VBox vbox = new VBox(menuselect, datedisplay);
		Scene scene = new Scene(vbox, 600, 600);
		menuStage.setScene(scene);
		menuStage.show();
		
		date.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Date date = new Date();
				datedisplay.setText(date.toString());
			}
		});
		
		printdata.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String textbox = datedisplay.getText();
				try {
					FileWriter fw = new FileWriter("Module3.txt");
					fw.write(textbox);
					fw.close();
				}
				catch(Exception e) {
					datedisplay.setText("Something went wrong");
				}
				datedisplay.setText("The Time and Date have printed successfully to Module3.txt");
			}
		});
		
		changecolor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				vbox.setStyle("-fx-background-color:#00ff00");
				datedisplay.setText("You Have Successfully Changed The Background Color to Green");
			}
		});
		
		endprogram.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});
		
		
		
		
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
