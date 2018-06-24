package q1q2;

import java.util.Calendar;
import java.util.GregorianCalendar;


public interface Dangerous {
	Calendar calendar = new GregorianCalendar();
	int year=calendar.get(Calendar.YEAR);
	
	boolean isDangerous();
	
	default int getYear() {
		return this.year;
	}
}
