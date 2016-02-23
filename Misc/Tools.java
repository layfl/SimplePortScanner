package Misc;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by layfl on 23.02.2016.
 */
public class Tools {
    public static String pat = "[a-zA-Z]";

    public static boolean checkAddressIp(String str) {
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(str);
        return !matcher.find(); /* negation */
    }

    public static boolean isNumber(String str) {
        try {
            int val = Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean checkPortRange(int from, int to) {
        return (from > 0 && from <= 65535 && from <= to) && (to > 0 && to <= 65535 && to >= from);
    }

    public static String[][] treeMapToStringArray(TreeMap<String, String> map) {
        int i = 0;
        String[][] str = new String[map.keySet().size()][2];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str[i][0] = entry.getKey();
            str[i][1] = entry.getValue();
            i++;
        }

        return str;
    }
}
