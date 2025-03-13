package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtils {
    
    public static final String FULL_DATE = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_HOUR = "dd 'de' MMMM 'de' yyyy HH:mm";
    public static final String SIMPLE_DATE = "dd/MM/yyyy";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSS_SS_SS = "yyyy-MM-dd'T'HH:mm:ss.SSS+SS:SS";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String DD_DE_MMMM_DE_YYYY = "dd 'de' MMMM 'de' yyyy";
    public static final String DD_MMMM_DE_YYYY_HH_MM_SS = "dd 'de' MMMM 'de' yyyy HH:mm:ss";

    private static final Logger LOGGER = Logger.getLogger(DateUtils.class.getName());

    public static java.sql.Date parse(String pattern, String value) {
        try {
            Date utilDate = new SimpleDateFormat(pattern).parse(value);
            return new java.sql.Date(utilDate.getTime()); // Converte java.util.Date para java.sql.Date
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao converter a data: " + value, ex);
            return null;
        }
    }

    public static String format(String pattern, Date data, Locale locale) {
        if (locale == null) {
            locale = new Locale("pt", "BR");
        }
        return new SimpleDateFormat(pattern, locale).format(data);
    }
    
    public static String format(String pattern, Date data) {
        return format(pattern, data, null);
    }
    
    public static String format(Date date) {
        return format(YYYY_MM_DD, date);
    }
    
    public static String formatFullDate(Date date) {
        return format(FULL_DATE, date);
    }

    public static Date toDate(String date, String mask) {
        try {
            return new SimpleDateFormat(mask).parse(date);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Erro ao converter a string para Date: " + date, e);
            return null;
        }
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
    }
}
