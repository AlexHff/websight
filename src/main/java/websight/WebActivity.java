package websight;

import java.util.*;

public class WebActivity implements Statistics{
    private HashMap<String, Integer> map = new HashMap<>();

    Comparator<Map.Entry<String, Integer>> sortByValue = new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            return -e1.getValue().compareTo(e2.getValue());
        }
    };

    public void visit(String pageName) throws IllegalArgumentException {
        if (pageName.length() == 0 || !pageName.substring(0, 4).equals("www."))
            throw new IllegalArgumentException();
        map.put(pageName, map.getOrDefault(pageName, 0) + 1);
    }

    public int getVisit(String pageName) {
        if (pageName.length() == 0 || !pageName.substring(0, 4).equals("www."))
            throw new IllegalArgumentException();
        return map.getOrDefault(pageName, -1);
    }

    public List<String> mostVisited() {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, sortByValue);
        List<String> mostVisited = new ArrayList<>();
        for (Map.Entry<String, Integer> e : list)
            mostVisited.add(e.getKey());
        return mostVisited;
    }
}