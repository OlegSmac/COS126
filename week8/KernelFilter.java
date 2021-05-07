import java.awt.Color;

public class KernelFilter {
    private static Picture calculation(Picture picture, double[][] kernel, double k) {
        Picture res = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                double sumred = 0;
                double sumgreen = 0;
                double sumblue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel[i].length; j++) {
                        if (i + col - kernel[0].length / 2 < 0 && j + row - kernel.length / 2 < 0) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            if (picture.width() > Math.abs(x)) {
                                x = picture.width() + x;
                            }
                            else {
                                x = 0;
                            }
                            if (picture.height() > Math.abs(y)) {
                                y = picture.height() + y;
                            }
                            else {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (i + col - kernel[0].length / 2 > picture.width() - 1 &&
                                j + row - kernel.length / 2 > picture.height() - 1) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            x = x - picture.width();
                            if (x > picture.width() - 1) {
                                x = 0;
                            }
                            y = y - picture.height();
                            if (y > picture.height() - 1) {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (i + col - kernel[0].length / 2 < 0 &&
                                j + row - kernel.length / 2 > picture.height() - 1) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            if (picture.width() > Math.abs(x)) {
                                x = picture.width() + x;
                            }
                            else {
                                x = 0;
                            }
                            y = y - picture.height();
                            if (y > picture.height() - 1) {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (i + col - kernel[0].length / 2 > picture.width() - 1 &&
                                j + row - kernel.length / 2 < 0) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            x = x - picture.width();
                            if (x > picture.width() - 1) {
                                x = 0;
                            }
                            if (picture.height() > Math.abs(y)) {
                                y = picture.height() + y;
                            }
                            else {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (i + col - kernel[0].length / 2 < 0) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            if (picture.width() > Math.abs(x)) {
                                x = picture.width() + x;
                            }
                            else {
                                x = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (j + row - kernel.length / 2 < 0) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            if (picture.height() > Math.abs(y)) {
                                y = picture.height() + y;
                            }
                            else {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (i + col - kernel[0].length / 2 > picture.width() - 1) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            x = x - picture.width();
                            if (x > picture.width() - 1) {
                                x = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else if (j + row - kernel.length / 2 > picture.height() - 1) {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            y = y - picture.height();
                            if (y > picture.height() - 1) {
                                y = 0;
                            }
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                        else {
                            int x = i + col - kernel[0].length / 2;
                            int y = j + row - kernel.length / 2;
                            Color color = picture.get(x, y);
                            sumred += kernel[i][j] * k * color.getRed();
                            sumgreen += kernel[i][j] * k * color.getGreen();
                            sumblue += kernel[i][j] * k * color.getBlue();
                        }
                    }
                }
                if (sumred > 255) {
                    sumred = 255;
                }
                if (sumgreen > 255) {
                    sumgreen = 255;
                }
                if (sumblue > 255) {
                    sumblue = 255;
                }
                if (sumred < 0) {
                    sumred = 0;
                }
                if (sumgreen < 0) {
                    sumgreen = 0;
                }
                if (sumblue < 0) {
                    sumblue = 0;
                }
                int red = (int) Math.round(sumred);
                int green = (int) Math.round(sumgreen);
                int blue = (int) Math.round(sumblue);
                Color c = new Color(red, green, blue);
                res.set(col, row, c);
            }
        }
        return res;
    }


    public static Picture identity(Picture picture) {
        double[][] k = new double[3][3];
        k[0][0] = 0; k[0][1] = 0; k[0][2] = 0;
        k[1][0] = 0; k[1][1] = 1; k[1][2] = 0;
        k[2][0] = 0; k[2][1] = 0; k[2][2] = 0;
        return calculation(picture, k, 1);
    }

    public static Picture gaussian(Picture picture) {
        double[][] k = new double[3][3];
        k[0][0] = 1; k[0][1] = 2; k[0][2] = 1;
        k[1][0] = 2; k[1][1] = 4; k[1][2] = 2;
        k[2][0] = 1; k[2][1] = 2; k[2][2] = 1;
        return calculation(picture, k, 1/16.0);
    }

    public static Picture sharpen(Picture picture) {
        double[][] k = new double[3][3];
        k[0][0] = 0; k[0][1] = -1; k[0][2] = 0;
        k[1][0] = -1; k[1][1] = 5; k[1][2] = -1;
        k[2][0] = 0; k[2][1] = -1; k[2][2] = 0;
        return calculation(picture, k, 1);
    }

    public static Picture laplacian(Picture picture) {
        double[][] k = new double[3][3];
        k[0][0] = -1; k[0][1] = -1; k[0][2] = -1;
        k[1][0] = -1; k[1][1] = 8; k[1][2] = -1;
        k[2][0] = -1; k[2][1] = -1; k[2][2] = -1;
        return calculation(picture, k, 1);
    }

    public static Picture emboss(Picture picture) {
        double[][] k = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        /* k[0][0] = -2; k[0][1] = -1; k[0][2] = 0;
        k[1][0] = -1; k[1][1] = 1; k[1][2] = 1;
        k[2][0] = 0; k[2][1] = 1; k[2][2] = 2; */
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
