package pdt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class distanceTest {

    @Test
    public void positiveTest() {
        Point p1 = new Point(1,2);
        Point p2 = new Point(5,4);
        Assert.assertEquals(p2.distance(p1),4.47213595499958);
    }

    @Test
    public void negativeTest() {
        Point p1 = new Point(12,21);
        Point p2 = new Point(52,334);
        Assert.assertEquals(p2.distance(p1),0.0);
    }
}
