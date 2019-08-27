package funny.hindi.videos.tube.mode;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class M {
    public static String changeDateFormat(String inputString) {
        Log.i(">>inputDate", "changeDateFormat: " + inputString);
        String[] date1 = new String[1];
        String inputPattern = "yyyy-MM-dd'T'HH:mm:ss";
        String outputPattern = "dd-MMM-yyyy h:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(inputString);
            str = outputFormat.format(date);
            date1 = str.split(" ");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1[0];

    }
}
