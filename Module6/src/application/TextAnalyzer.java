package application;
/**
 * <h1>Word Occurrences</h1>
 * The program counts the number of a times words
 * appears in the text.
 * 
 * I have no idea how much detail you wanted documented.
 * So I just did the basics.
 * 
 * @author Teresa Scudder 
 * @version 3.0
 * @since 4/1/2020
 */

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.*;


public class TextAnalyzer extends Application {

	/**
	 * Override method to produce the output	 * 
	 * @param s first parameter in the start method 
	 * @return Output
	 */
	@Override
	public void start(Stage s) {

		// title for the stage
		s.setTitle("Text Analyzer");

		// create a tile pane
		TilePane title = new TilePane();

		// create a label
		Label l = new Label("Word          :          Count");

	
		// run
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			private Labeled TextLine;

			public void handle(ActionEvent e) {

				// variables
				String inputString = null;
				int count;

				// Read in the file
				URLReader obj = new URLReader();

				// string from URLReader
				try {
					inputString = obj.main();
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				// word array
				String[] wordsArray = inputString.split("\\s+");

				// mapping the array
				Map<String, Integer> map = new HashMap<>();

				// count words
				for (String word : wordsArray) {
					//
					if (map.containsKey(word)) {
						count = map.get(word);
						map.put(word, count + 1);
					} else {
						map.put(word, 1);
					}
				}

				// output
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					TextLine.setText(entry.getKey() + " : " + entry.getValue());

				}
				
			}
		};


		title.getChildren().add(l);
 
		Scene scene = new Scene(title, 400, 400);

		s.setScene(scene);
		s.show();

		
	}

/**
 * This is the main method which produces the window and contents
 * from the start method
 * @param args
 */

	public static void main(String[] args) {
		launch(args);
	}
}
