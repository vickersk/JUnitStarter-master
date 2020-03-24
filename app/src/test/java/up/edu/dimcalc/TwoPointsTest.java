package up.edu.dimcalc;

import android.graphics.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    /**
     * verify random values are being generated for the x and y coordinates of a point,
     * using randomValue()
     */
    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, -11, -11);
        Point p1 = testPoints.getPoint(0);
        testPoints.randomValue(0);
        if (p1.x == -11 & p1.y == -11){
            fail("random values not generated");
        }

    }

    /** verify that arbitrary points are being set to the origin through setOrigin() */
    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 4, 2);
        testPoints.setPoint(1,2,4);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that one point is being copied over to another location/point with copy() */
    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 1, 7);
        testPoints.setPoint(1, 7, 1);
        testPoints.copy(0, 1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(1, p1.x);
        assertEquals(7, p1.y);
        assertEquals(1, p2.x);
        assertEquals(7, p2.y);
    }

    /**
     *  verify that the distance between two points is being correctly calculated with distance() and
     *  is not negative.
     */
    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, -3,-4);
        testPoints.setPoint(1, 0, 0);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double result = testPoints.distance();
        double testResult = 0.0;
        testResult = Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
        assertEquals(testResult, result, 0.01);
    }

    /**
     *  verify that the slope of two points is being correctly calculated and that it doesn't attempt to
     *  divide by zero, with slope()
     */
    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 2);
        testPoints.setPoint(1, 1, 2);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double testSlope;
        double slope;
        if (testPoints.getPoint(0) == testPoints.getPoint(1)){
            testSlope = 0.0;
        } else {
            if (p1.y - p2.y == 0){
                testSlope = 0.0;
            } else {
                testSlope = (p1.x - p2.x) / (p1.y - p2.y);
            }
        }
        slope = testPoints.slope();
        assertEquals(testSlope, slope, 0.01);

    }
}