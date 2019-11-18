package websight;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testWebActivityNotNull() {
        assertNotNull(new WebActivity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionThrownIllegalStringFormat() {
        WebActivity e = new WebActivity();
        e.visit("google.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionThrownEmptyString() {
        WebActivity e = new WebActivity();
        e.visit("");
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerExceptionThrownNullString() {
        WebActivity e = new WebActivity();
        e.visit(null);
    }

    @Test
    public void testMostVisited() {
        WebActivity e = new WebActivity();
        e.visit("www.google.com");
        e.visit("www.google.com");
        e.visit("www.twitter.com");
        e.visit("www.instagram.com");
        e.visit("www.instagram.com");
        e.visit("www.instagram.com");
        e.visit("www.google.com");
        e.visit("www.google.com");
        assertEquals("www.google.com", e.mostVisited().get(0));
    }

    @Test
    public void testMostVisitedNotNull() {
        WebActivity e = new WebActivity();
        assertNotNull(e.mostVisited());
    }

    @Test
    public void testGetVisit() {
        WebActivity e = new WebActivity();
        e.visit("www.google.com");
        e.visit("www.google.com");
        e.visit("www.google.com");
        assertEquals(3, e.getVisit("www.google.com"));
    }

    @Test
    public void testGetVisitDoesNotExist() {
        WebActivity e = new WebActivity();
        assertEquals(-1, e.getVisit("www.google.com"));
    }
}
