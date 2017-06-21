package Stepik;

import java.util.function.DoubleUnaryOperator;


public class Integration {
    public static void main(String[] args) {
        System.out.println("It's a fully fucking shit!");
    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double accuracy = 1e8;
        double h = (b - a) / accuracy;
        double s = 0;
        for (int i = 0; i < accuracy; i++){
            s += f.applyAsDouble(a + h * (i + 0.5));
        }
        return s * h;
    }
}
