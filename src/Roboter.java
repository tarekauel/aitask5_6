/*
 * Copyright (c) 2015 Tarek Auel
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

public class Roboter {

    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {

        int steps = 0;
        double stepSize = 1;
        double deltaX = 0.1;

        Point p = new Point();
        p.x = 10;
        p.y = 2;
        while (distance(p.x,p.y) > 1) {
            System.out.printf("X: %.8f\tY: %.8f\tDistance: %.8f\n", p.x, p.y, distance(p.x,p.y));
            steps++;
            p = move(p, stepSize,deltaX);
        }
        System.out.printf("X: %.8f\tY: %.8f\tDistance: %.8f\n", p.x, p.y, distance(p.x,p.y));
        System.out.println("Steps: " + steps);
    }

    public static Point move(Point p, double stepSize, double deltaX) {
        double rand_x = Math.random();
        double rand_y = Math.random();

        double test_x_1 = p.x + rand_x;
        double test_y_1 = p.y + rand_y;

        double test_x_2 = p.x - rand_x;
        double test_y_2 = p.y - rand_y;

        double distance_1 = distance(test_x_1, test_y_1);
        double distance_2 = distance(test_x_2, test_y_2);

        double deltaE = (distance_2 - distance_1);

        double move = deltaE / deltaX * stepSize;

        double move_x = move * (rand_x / (rand_x + rand_y));
        double move_y = move * (rand_y / (rand_x + rand_y));

        p.x += move_x;
        p.y += move_y;

        System.out.printf("\t Other direction: X: %.8f\tY: %.8f\tDistance: %.8f\n", p.x - 2*move_x, p.y - 2*move_y, distance(p.x - 2*move_x, p.y - 2*move_y));

        if (p.x < 0) p.x = 0;
        if (p.y < 0) p.y = 0;

        return p;
    }

    public static double distance(double x, double y) {
        int target_x = 5;
        int target_y = 5;

        return Math.sqrt(Math.abs(Math.pow(x - target_x, 2) + Math.pow(y - target_y, 2)));
    }
}
