package javatpoint;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by acedric on 22/03/2017.
 */
public class Enum {
    public static void main(String[] args) {

        Set<days> set = EnumSet.of(days.monday,days.tuesday);

        Iterator<days> d= set.iterator();
        while (d.hasNext()){
            System.out.println(d.next());
        }
    }
}
enum days {
    monday, tuesday, wednesday,thursday, friday
        }
