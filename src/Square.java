import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Square extends Rectangle 
    {
    private Random random;
    private int RGB[] = new int[3];
    private double prob;
    private boolean isClicked = false;
	private Square[] neighbours = new Square[4];


    public Square(int side, double probability, Random random)
    {
        this.random = random;
        prob = probability;
        setWidth(side);
        setHeight(side);

        RGB[0] = random.nextInt(256);
        RGB[1] = random.nextInt(256);
        RGB[2] = random.nextInt(256);

        setFill(Color.rgb(RGB[0], RGB[1], RGB[2]));
        setStroke(Color.DARKORCHID);
    }
    
    public void setRandomColor()
    {
        if (prob-random.nextDouble() > 0 )
        {
            RGB[0] = random.nextInt(256);
            RGB[1] = random.nextInt(256);
            RGB[2] = random.nextInt(256);
        }
        else 
        {
            for (int rgbPoz = 0; rgbPoz < 3; rgbPoz++)
            {   
                int active = 0;
                int helper = RGB[rgbPoz];
                RGB[rgbPoz] = 0;
                for (Square nb : neighbours)
                {
                    if (nb.isClicked == true) continue;
                    else active ++;
                    RGB[rgbPoz] += nb.getColorId()[rgbPoz];
                }
                if (active != 0) RGB[rgbPoz] = RGB[rgbPoz] / active;
                else RGB[rgbPoz] = helper;
            }
        }
        setFill(Color.rgb(RGB[0], RGB[1], RGB[2]));
            
    }
    public int[] getColorId()
    {
        return RGB;
    }

    public boolean isClicked(){
        return isClicked;
    }

    public void Clicked(){
            isClicked = !isClicked;
            if (isClicked) setStroke(Color.BLACK);
            else setStroke(Color.DARKORCHID);
            
    }
    public void setNeighbours(Square[] nb){
        neighbours[0] = nb[0];
        neighbours[1] = nb[1];
        neighbours[2] = nb[2];
        neighbours[3] = nb[3];
    }
}
