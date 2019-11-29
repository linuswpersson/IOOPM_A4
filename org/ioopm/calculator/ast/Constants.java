package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Global set of known constants which the parser can access
 */
public class Constants {
    public static final HashMap<String, Double> namedConstants = new HashMap<>();

    /**
     *Static block runs at program load-time and adds entries in the hashtable that maps the strings "pi", "e", 
     *"Answer" and "L" to the corresponding values.
     */
    static {
	Constants.namedConstants.put("pi", Math.PI);
	Constants.namedConstants.put("e",  Math.E);
        Constants.namedConstants.put("Answer",  42.0);
	Constants.namedConstants.put("L",  6.022140857*Math.pow(10, 23));
    }
}
