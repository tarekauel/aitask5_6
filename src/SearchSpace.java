public class SearchSpace {

    public static void main(String[] args) {
        double[][] d = new double[150][150];

        for (int i=0; i < d.length; i++) {
            for (int j=0; j < d[0].length; j++) {
                d[i][j] = distance(i / 10.0, j / 10.0);
            }
        }

        for (double[] x : d) {
            for (double y : x) {
                System.out.printf("%.4f\t", y);
            }
            System.out.println();
        }


    }

    public static double distance(double x, double y) {
        int target_x = 5;
        int target_y = 5;

        return Math.sqrt(Math.abs(Math.pow(x - target_x, 2) + Math.pow(y - target_y, 2)));
    }
}
