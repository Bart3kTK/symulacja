import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        Application.launch(args);
      }
      @Override
      public void start(Stage primaryStage) throws IOException {
        new GUI(primaryStage);
      }

}
