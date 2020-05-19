package ca.udacity.oopInJava.library.newVersion;

import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class RenewReminder {
	
	private final Patron patron;
	
	Timer timer;

    public RenewReminder(Patron patron) {
    	this.patron = patron;
        timer = new Timer(); //  new Timer(true) for a daemon
        int numDaysInYear = LocalDate.now().lengthOfYear(); // how many days in current year
        int years = this.patron.getValidityPeriod(); // how many years the subscription is valid
        timer.schedule(new RemindTask(), years*numDaysInYear*24*3600*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
            patron.setStatus("suspended");
        	timer.cancel(); //Terminate the timer thread
            
        }
    }

}
