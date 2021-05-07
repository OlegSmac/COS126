import java.awt.Color;

public class KernelFilter {
    private static int trim(double color) {
        return (int) Math.round(Math.min(Math.max(color, 0), 255));
    }

    private static Picture calculation(Picture picture, double[][] k, double delta) {
        Picture res = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                double sumred = 0;
                double sumgreen = 0;
                double sumblue = 0;
                for (int i = 0; i < k.length; i++) {
                    for (int j = 0; j < k[0].length; j++) {
                        int x = (i + col - k.length / 2) % picture.width();
                        int y = (j + row - k[0].length / 2) % picture.height();
                        if (x < 0) {
                            x = picture.width() + x;
                        }
                        if (y < 0) {
                            y = picture.height() + y;
                        }
                        Color c = picture.get(x, y);
                        sumred += k[i][j] * delta * c.getRed();
                        sumgreen += k[i][j] * delta * c.getGreen();
                        sumblue += k[i][j] * delta * c.getBlue();
                    }
                }
                res.set(col, row, new Color(trim(sumred), trim(sumgreen), trim(sumblue)));
            }
        }
        return res;
    }


    public static Picture identity(Picture picture) {
        double[][] k = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        return calculation(picture, k, 1);
    }

    public static Picture gaussian(Picture picture) {
        double[][] k = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        return calculation(picture, k, 1/16.0);
    }

    public static Picture sharpen(Picture picture) {
        double[][] k = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return calculation(picture, k, 1);
    }

    public static Picture laplacian(Picture picture) {
        double[][] k = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return calculation(picture, k, 1);
    }

    public static Picture emboss(Picture picture) {
        double[][] k = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return calculation(picture, k, 1);
    }

    public static Picture motionBlur(Picture picture) {
        double[][] k = new double[9][9];
        k[0][0] = 1;
        k[1][1] = 1;
        k[2][2] = 1;
        k[3][3] = 1;
        k[4][4] = 1;
        k[5][5] = 1;
        k[6][6] = 1;
        k[7][7] = 1;
        k[8][8] = 1;
        return calculation(picture, k, 1/9.0);
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        motionBlur(picture).show();
    }
}
