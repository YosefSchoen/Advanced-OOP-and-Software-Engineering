package Airport;

import java.util.ArrayList;
import java.util.Arrays;

//A public class witch holds an array of all transports (planes and trains).
public class AirportUtil {

    //
    public static final Location[] LOCATIONS = Location.values();

    //uses array sort to order the transports by the predefined compare to in each transport's class
    public static void sortTransport(Comparable[] transport){ Arrays.sort(transport); }

    //takes the data from each transport and writes up a report based on the data
    static String reportAll (Movable[] movables) {
        String str;
        ArrayList<String> buffer = new ArrayList<>();
        for (Movable m: movables) {
            str = m.getType() + " " +
                    m.getId() +
                    " going from " +
                    m.getSource() +
                    " to " +
                    m.getDestination() +
                    m.getCurrentLocation();
            buffer.add(str);

        }
        return String.join("\n",buffer);
    }
}
