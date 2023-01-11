package hibernatedemo.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String dateStr) throws ParseException {
		Date date = formatter.parse(dateStr);
		return date;
	}

	public static String formatDate(Date date) {
		String result = null;
		if (date != null) {
			result = formatter.format(date);
		}
		return result;
	}

}