import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    private boolean start = false;
    private static int columns;
    private static int rows;
    private static double probability;
    private static int speeed;
    private static int side;

    public static int getSide() {
        return side;
    }

    public static int getColumns() {
        return columns;
    }

    public static int getRows() {
        return rows;
    }

    public static double getProbability() {
        return probability;
    }

    public static int getSpeeed() {
        return speeed;
    }

    public boolean isStart() {
        return start;
    }

    @FXML
    private TextField col;

    @FXML
    private TextField prob;

    @FXML
    private TextField row;

    @FXML
    private TextField speed;

    @FXML
    private TextField sideF;
    
    @FXML
    void buttonClicked(MouseEvent event) {
        try
        {
            columns = Integer.parseInt(col.getText());
            probability = Double.parseDouble(prob.getText());
            rows = Integer.parseInt(row.getText());
            speeed = Integer.parseInt(speed.getText());
            side = Integer.parseInt(sideF.getText());

            if (columns < 0 || columns > 50) throw new IllegalArgumentException();
            if (probability < 0 || probability > 1) throw new IllegalArgumentException();
            if (rows < 0 || rows > 50) throw new IllegalArgumentException();
            if (speeed < 0 || speeed > 1000) throw new IllegalArgumentException();
            if (side < 5 || side > 100) throw new IllegalArgumentException();


            GUI.newScene();

        }
        catch(IllegalArgumentException e){
            new GUIDialog("Bledne dane", "Columns int (1-50) -> " + col.getText() +
            "\nRows int (1-50) -> " + row.getText() + 
            "\nSide int (5-100) -> " + sideF.getText() +
            "\nSpeed int (1-1000) -> " + speed.getText() +
            "\nProbability double (0-1) -> " + prob.getText());
        }
        

    }

}
