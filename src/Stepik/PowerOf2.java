package Stepik;
/**
 * Checks if given <code>value</code> is a power of two.
 *
 * @param value any number
 * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
 *
 * Решать можно разными способами:

воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
применив пару трюков из двоичной арифметики;
написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответствующих уроков).

 */
public class PowerOf2 {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfTwo(int value) {
        if (value==0) return false;
          return ( (Math.abs(value)&(Math.abs(value)-1))==0 );
    }
}
