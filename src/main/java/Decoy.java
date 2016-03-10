import java.util.HashMap;

/**
 * Created by user on 08.03.16.
 */
public class Decoy {
    private HashMap<Long, HashMap<String, HashMap<String, Double>>> map;
    // (time (curr (curr rate)))

    private Decoy(){//TODO==============================================================================
        map=new HashMap<Long, HashMap<String, HashMap<String, Double>>>();
        String[] currs={"EUR","USD","PLN","GBP","CHF"};
        HashMap<String,HashMap<String,Double>> mapOfCurrs = new HashMap<String,HashMap<String,Double>>();
        for(String ss : currs) {
            HashMap<String,Double> rates=new HashMap<String, Double>();
            for (String s : currs)
                rates.put(s, new Double(s.equals(ss)?1:Math.random() * 5 + 2));
            mapOfCurrs.put(ss,rates);
        }
        map.put(new Long(0),mapOfCurrs);
    }

    public static double get(long t,String c0,String c1){
        return 0;//TODO==============================================================================
    }
}
