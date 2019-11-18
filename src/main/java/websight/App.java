package websight;

/**
 *
 */
public class App {
    private static final String GOOGLE = "www.google.com";
    private static final String INSTAGRAM = "www.instagram.com";
    private static final String TWITTER = "www.twitter.com";

    /**
     * @param args
     */
    public static void main(String[] args) {
        WebActivity e = new WebActivity();
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        e.visit(TWITTER);
        e.visit(INSTAGRAM);
        e.visit(INSTAGRAM);
        e.visit(INSTAGRAM);
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        System.out.println(e.mostVisited());
        System.out.println(e.getVisit("www.gilbert.com"));
    }
}
