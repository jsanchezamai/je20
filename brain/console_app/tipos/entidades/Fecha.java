package console_app.tipos.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Fecha {

    public static String fechaComoCadena(Date fecha) {
        String pattern = "yyyy-MM-dd HH:MM:ss";
        if (fecha != null) {
            // http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(fecha);
        } else {
            return pattern;
        }
    }

    public static Date localToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime dateToLocal(Date fecha) {
        return fecha.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }

    public static Date stringLocalToDate(String valor) {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (valor != null) {
            // http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                return simpleDateFormat.parse(valor);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;

    }

    public static Date masDias(Date fecha, int dias) {
        LocalDateTime fechaLocal = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return Date.from(fechaLocal.plusDays(dias).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static boolean fechaEnRango(Date fecha, Date fechaMin, Date fechaMax) {
        return (fecha.equals(fechaMin) || fecha.after(fechaMin)) && (fecha.equals(fechaMin) || fecha.before(fechaMax));
    }

    public static String ahora() {
        return Fecha.fechaComoCadena(ahoraLocalDate());
    }

    public static Date ahoraDate() {
        return Fecha.localToDate(ahoraLocalDate());
    }

    public static String fechaComoCadena(LocalDateTime fecha) {
        return Fecha.fechaComoCadena(Fecha.localToDate(fecha));
    }

    public static LocalDateTime ahoraLocalDate() {
        return LocalDateTime.now();
    }

}
