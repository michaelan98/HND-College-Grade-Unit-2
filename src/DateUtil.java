import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
	
public class DateUtil {

	// List of all date formats that we want to parse.
	// Add your own format here.
	private static List<SimpleDateFormat>
			dateFormats = new ArrayList<SimpleDateFormat>() {{
			add(new SimpleDateFormat("dd/M/yyyy"));
			add(new SimpleDateFormat("dd.M.yyyy"));
			add(new SimpleDateFormat("dd/M/yyyy hh:mm:ss a"));
			add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
			add(new SimpleDateFormat("dd.MMM.yyyy"));
			add(new SimpleDateFormat("dd-MMM-yyyy"));
			add(new SimpleDateFormat("dd/MMM/yyyy"));
		}
	};

	/**
	 * Convert String with various formats into java.util.Date
	 * 
	 * @param input
	 *            Date as a string
	 * @return java.util.Date object if input string is parsed 
	 * 			successfully else returns null
	 */
	public static Date convertToDate(String input) {
		Date date = null;
		if(null == input) {
			return null;
		}
		for (SimpleDateFormat format : dateFormats) {
			try {
				format.setLenient(false);
				date = format.parse(input);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,"Please enter the date format dd/mm/yyyy");
				break;
			}
			if (date != null) {
				break;
			}
		}

		return date;
	}
	
}
