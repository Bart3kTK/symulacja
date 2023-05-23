
import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI
{

  private static Stage stage;

    public GUI(Stage stag) throws IOException 
    {
      stage = stag;      
      Parent parent = FXMLLoader.load(getClass().getResource("loader.fxml"));
      Scene scene = new Scene(parent);
      stage.setTitle("Symulacja - wprowadzanie wartosci");
      stage.setScene(scene);
      stage.show();
    }

    public static void newScene()
    {
      GridPane pane = new GridPane();
      new GUIPane(pane);
      Scene scene = new Scene(pane);
      stage.setTitle("Symulacja");
      stage.setScene(scene);
    }

}
