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
        double rand_x = Math.random() * stepSize / 4;
        double rand_y = Math.random() * stepSize / 4;

        double test_x_1 = p.x + rand_x;
        double test_y_1 = p.y + rand_y;

        double test_x_2 = p.x - rand_x;
        double test_y_2 = p.y - rand_y;

        double distance_1 = distance(test_x_1, test_y_1);
        double distance_2 = distance(test_x_2, test_y_2);

        double deltaE = (distance_2 - distance_1);

        double move = deltaE / deltaX * (-1 * stepSize);

        p.x -= move * (rand_x / (rand_x + rand_y));
        p.y -= move * (rand_y / (rand_x + rand_y));

        System.out.printf("\t Other direction: X: %.8f\tY: %.8f\tDistance: %.8f\n", p.x + 2*(move * (rand_x / (rand_x + rand_y))), p.y + 2*(move * (rand_y / (rand_x + rand_y))), distance(p.x + 2*(move * (rand_x / (rand_x + rand_y))), p.y + 2*(move * (rand_y / (rand_x + rand_y)))));

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
