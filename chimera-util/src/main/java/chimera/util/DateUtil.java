package chimera.util;

import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by cas
 */
public final class DateUtil {
    private DateUtil() {
    }
    public static final String DEFAULT_DATE_FORMAT_VALUE = "dd/MM/yyyy";
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_FORMAT_VALUE);

    public static Date convertToDate(long date){
        return new Date(date);
    }

    public static String convertToDateStr(long date){
        return DEFAULT_DATE_FORMAT.format(new Date(date));
    }

    public static Date convertToDate(long date, Locale locale){
        return new Date(date);
    }

    public static String convertToDateStr(long date, Locale locale){
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT_VALUE, locale);
        return df.format(new Date(date));
    }

    /**
     * calculate month different between two dates
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Integer calculateMonth(Date d1, Date d2) {
        if (d1 == null || d2 == null) return 0;

        DateTime start, end;
        if (d1.after(d2)) {
            start = new DateTime(d1);
            end = new DateTime(d2);
        } else {
            start = new DateTime(d2);
            end = new DateTime(d1);
        }
        return Months.monthsBetween(end, start).getMonths() % 12;
    }

    /**
     * calculate year different between two dates
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Integer calculateYear(Date d1, Date d2) {
        if (d1 == null || d2 == null) return 0;
        DateTime start, end;
        if (d1.after(d2)) {
            start = new DateTime(d1);
            end = new DateTime(d2);
        } else {
            start = new DateTime(d2);
            end = new DateTime(d1);
        }
        return Years.yearsBetween(end, start).getYears();
    }

    /**
     * get difference between two date
     *
     * @param d1
     * @param d2
     * @return
     */
    public static String calculateDuration(Date d1, Date d2) {
        DateTime arrival, departure;
        if (d1.after(d2)) {
            arrival = new DateTime(d1);
            departure = new DateTime(d2);
        } else {
            arrival = new DateTime(d2);
            departure = new DateTime(d1);
        }

        StringBuilder sb = new StringBuilder();

        int days = Days.daysBetween(departure, arrival).getDays();
        if (days > 0) {
            sb.append(days + "hari ");
        }

        int hours = Hours.hoursBetween(departure, arrival).getHours() % 24;
        if (hours > 0) {
            sb.append(hours + "j ");
        }

        int minutes = Minutes.minutesBetween(departure, arrival).getMinutes() % 60;
        if (minutes > 0) {
            sb.append(minutes + "m ");
        }

        String result = sb.toString();
        if (result.isEmpty()) {
            return "";
        }
        return result.substring(0, result.length() - 1);
    }
}
