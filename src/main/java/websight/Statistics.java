package websight;

import java.util.List;

public interface Statistics {
    public void visit(String pageName);
    public int getVisit(String pageName);
    public List<String> mostVisited();
}