import java.util.Random;

import javafx.application.Platform;

public class MyThread extends Thread{
	private Object obj;
    private Square square;
	private Random random;
	private double speed;
	private boolean isActive;
	private volatile boolean threadSuspended = false;
	

	MyThread(Object obj, Square sq, double speed, Random random)
	{
		this.obj = obj;
        this.square = sq;
		this.speed = speed;
		this.random = random;
	}

	public boolean isActive(){
		return isActive;
	}

	synchronized public void MyStop(){
		threadSuspended = !threadSuspended;
		notify();
	}

	@Override
	public void run()
	{
            while(true)
			{
				try 
				{	
					if (threadSuspended)
					{
						synchronized(this) 
						{
							while (threadSuspended)
								wait();						
						}
					}
				} 
				catch (InterruptedException e){}

				try 
				{
					synchronized(obj)
					{
						System.out.println("Zaczynam " + Thread.currentThread().getId());
						Platform.runLater(() -> square.setRandomColor());
						System.out.println("Koncze " + Thread.currentThread().getId());
					}
					Thread.sleep( (int) (( random.nextDouble() + 0.5 ) * speed));
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
	}
}
