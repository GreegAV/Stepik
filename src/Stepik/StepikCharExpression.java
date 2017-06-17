package Stepik;

/**
 * Created by avg-m on 17/06/2017.
 */
public class StepikCharExpression {

    public static void main(String[] args) {
        System.out.println(charExpression(15));
    }
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

}


