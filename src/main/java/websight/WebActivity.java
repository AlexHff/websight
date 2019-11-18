package websight;

import java.util.*;

/**
 *
 */
public class WebActivity implements Statistics {
    private static final int LEN = 4;
    private static final String PREFIX = "www.";
    private Map<String, Integer> map;

    /**
     * @return
     */
    public WebActivity() {
        map = new HashMap<String, Integer>();
    }

    private Comparator<Map.Entry<String, Integer>> sortByValue = new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            return -e1.getValue().compareTo(e2.getValue());
        }
    };

    /**
     * @param pageName
     * @throws IllegalArgumentException
     */
    public void visit(String pageName) throws IllegalArgumentException {
        if (pageName.length() == 0 || !pageName.substring(0, LEN).equals(PREFIX)) {
            throw new IllegalArgumentException();
        }
        map.put(pageName, map.getOrDefault(pageName, 0) + 1);
    }

    /**
     * @param pageName
     * @return int
     */
    public int getVisit(String pageName) {
        if (pageName.length() == 0 || !pageName.substring(0, LEN).equals(PREFIX)) {
            throw new IllegalArgumentException();
        }
        return map.getOrDefault(pageName, -1);
    }

    /**
     * @return List<String>
     */
    public List<String> mostVisited() {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, sortByValue);
        List<String> mostVisited = new ArrayList<>();
        for (Map.Entry<String, Integer> e : list) {
            mostVisited.add(e.getKey());
        }
        return mostVisited;
    }
}
