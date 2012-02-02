package tools;

import java.util.Calendar;

public class TimeStamp {
	private Calendar c;

	public TimeStamp() {
		c = Calendar.getInstance();
	}

	/* GETTER */
	public int getYear() {
		return c.get(Calendar.YEAR);
	}

	public int getMonth() {
		return c.get(Calendar.MONTH) + 1;
	}

	public int getDay() {
		return c.get(Calendar.DATE);
	}

	/* GET_STRING_DATE */
	@Override
	public String toString() {
		return "" + getYear() + getMonth() + getDay();
	}

}
