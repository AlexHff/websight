package websight;

import java.util.List;

/**
 *
 */
public interface Statistics {
    void visit(String pageName);

    int getVisit(String pageName);

    List<String> mostVisited();
}
