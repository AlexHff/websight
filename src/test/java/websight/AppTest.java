package websight;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class AppTest {
    private static final String GOOGLE = "www.google.com";
    private static final String INSTAGRAM = "www.instagram.com";
    private static final String TWITTER = "www.twitter.com";

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
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        e.visit(TWITTER);
        e.visit(INSTAGRAM);
        e.visit(INSTAGRAM);
        e.visit(INSTAGRAM);
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        assertEquals(GOOGLE, e.mostVisited().get(0));
    }

    @Test
    public void testMostVisitedNotNull() {
        WebActivity e = new WebActivity();
        assertNotNull(e.mostVisited());
    }

    @Test
    public void testGetVisit() {
        final int res = 3;
        WebActivity e = new WebActivity();
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        e.visit(GOOGLE);
        assertEquals(res, e.getVisit(GOOGLE));
    }

    @Test
    public void testGetVisitDoesNotExist() {
        WebActivity e = new WebActivity();
        assertEquals(-1, e.getVisit(GOOGLE));
    }
}
