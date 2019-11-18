package websight;

public final class App {
    public static void main(String[] args) {
        WebActivity e = new WebActivity();
        e.visit("www.google.com");
        e.visit("www.google.com");
        e.visit("www.twitter.com");
        e.visit("www.instagram.com");
        e.visit("www.instagram.com");
        e.visit("www.instagram.com");
        e.visit("www.google.com");
        e.visit("www.google.com");
        System.out.println(e.mostVisited());
        System.out.println(e.getVisit("www.gilbert.com"));
    }
}
