package chimera.util;

import java.time.*;
import java.util.Date;

/**
 * Created by cas
 */
public final class DateConverter {
    public static final String ZONE_TIME_ID = "GMT+7";

    private DateConverter() {
    }

    public static Date localDateTimeToDate(LocalDateTime startOfDay) {
        return Date.from(startOfDay.atZone(ZoneId.of(ZONE_TIME_ID)).toInstant());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.of(ZONE_TIME_ID));
    }

    public static LocalDateTime epochToLocalDateTime(Long epoch) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.of(ZONE_TIME_ID));
    }

    public static Date localDateToDate(LocalDate startOfDay) {
        return Date.from(startOfDay.atStartOfDay(ZoneId.of(ZONE_TIME_ID)).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.from(LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.of(ZONE_TIME_ID)));
    }

    public static LocalDate epochToLocalDate(Long epoch) {
        return LocalDate.from(LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.of(ZONE_TIME_ID)));
    }

    public static Date zonedDateTimeToDate(ZonedDateTime startOfDay) {
        return Date.from(startOfDay.toInstant());
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.of(ZONE_TIME_ID));
    }

    public static ZonedDateTime epochToZonedDateTime(Long epoch) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.of(ZONE_TIME_ID));
    }
}
