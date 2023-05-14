package Parkhaus;
import java.util.*;
import java.text.*;

/**
 * Supplies basic time and date functionalities
 * @version 29.11.2011
 * @author Binz, OSZ IMT
 */
public class DateHelper{
  /**
  * Gets the actual time and date as String (format: "dd.MM.yyyy HH:mm")
  * @return The actual time and date
  */
  public static String getActualTimeAsString() {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    return sdf.format(date);
  }
  /**
  * Calculates a time difference in minutes
  * @param startDate
  * @param endDate
  * @return time difference in minutes (-1 in case of error)
  */
  public static int calculateTimeDifferenceInMinutes(String startDate, String endDate) {
    int differenceInMinutes;
    Date date1 = null, date2 = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    try {
      date1 = sdf.parse(startDate);
      date2 = sdf.parse(endDate);
    }
    catch (ParseException exp){
      return -1;
    }
    cal1.setTime(date1);
    cal2.setTime(date2);
    differenceInMinutes = (int) ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / 60000);
    return differenceInMinutes;
  }
}//DateHelper