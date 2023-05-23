import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GUIPane {

    
    int columns = Controller.getColumns();
    int rows = Controller.getRows();
    int side = Controller.getSide();
    int speed = Controller.getSpeeed();
    double probability = Controller.getProbability();


    MyThread T[][] = new MyThread[columns][rows];
    Square squares[][] = new Square[columns][rows];
    Object mutex = new Object();
    Random random = new Random();

    public GUIPane(GridPane pane)
    {
        for (int a = 0; a<columns; a++)
        {
            for (int b = 0; b < rows; b++)
            {
                Square sq = new Square(side, probability, random);
                sq.getColorId();
                squares[a][b] = sq;
                pane.add(sq, a, b);
            }
        }
        for (int a = 0; a<columns; a++)
        {
            for (int b = 0; b < rows; b++)
            {
                Square[] naighbours = new Square[4];
                naighbours[0] = squares[getPropA(a-1)][b];
                naighbours[1] = squares[getPropA(a+1)][b];
                naighbours[2] = squares[a][getPropB(b+1)];
                naighbours[3] = squares[a][getPropB(b-1)];
                squares[a][b].setNeighbours(naighbours);
                
                T[a][b] = new MyThread(mutex, squares[a][b], speed, random);
                T[a][b].start();
            }
        }
        pane.setOnMousePressed(e -> {
            int col = (int) ((e.getX()/ (side + 2)));
            int row = (int) ((e.getY() / (side + 2)));

            squares[col][row].Clicked();
            T[col][row].MyStop();
        });
    }
    public int getPropA(int a){
        if ( a < 0) return columns-1;
        if (a > columns-1) return 0;
        return a; 
    }

    public int getPropB(int b){
        if ( b < 0) return rows-1;
        if (b > rows-1) return 0;
        return b; 
    }
    
}
