package org.darkestapp.colorin.structure.utils;

/**
 * Represents a coordinate used to draw.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 29/10/16.
 */
public class Point {

    /**
     * Coordinates of Point
     */
    private final double x;
    private final double y;

    /**
     * Default constructor
     * @param x represents the X coordinate.
     * @param y represents the Y coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X coordinate
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the Y coordinate
     * @return
     */
    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point that = (Point) o;

        if (Double.compare(that.x, x) != 0) return false;
        return Double.compare(that.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
