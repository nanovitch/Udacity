
import java.util.Timer;
import java.util.TimerTask;


/**
 * Schedule a task that executes once every second.
 */

public class AnnoyingBeep {
    
    public static void main(String args[]) {
		System.out.println("About to schedule task.");
		new AnnoyingBeep();
		System.out.println("Task scheduled.");
	}
    
    Timer timer;

    public AnnoyingBeep() {
    	
        timer = new Timer();
        timer.schedule(new RemindTask(),
	               0,        //initial delay
               1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
    	int numWarningBeeps = 3;

    	public void run() {
		    if (numWarningBeeps > 0) {
		        
			System.out.println("Beep!");
			numWarningBeeps--;
		    } else {
		        
	                System.out.println("Time's up!");
		        //timer.cancel(); //Not necessary because we call System.exit
		        System.exit(0);   //Stops the AWT thread (and everything else)
		    }
    	}
    }
}


