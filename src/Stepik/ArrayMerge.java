package Stepik;

import java.util.Arrays;

/**
 * Merges two given sorted arrays into one
 *
 * @param a1 first sorted array
 * @param a2 second sorted array
 * @return new array containing all elements from a1 and a2, sorted
 */
public class ArrayMerge {
    public static void main(String[] args) {
        int[] m1={1,2,3};
        int[] m2={2,3,4,5};
        System.out.println(Arrays.toString(mergeArrays(m1,m2)));

    }

    public static int[] mergeArrays(int[] fst, int[] snd) {
        int res[]=new int[fst.length+snd.length];
        int c1=0, c2=0,c3=0;

        while (c3<=fst.length+snd.length-1)
        {
            while ((c1<fst.length) && (c2<snd.length)) {
                if (fst[c1] <= snd[c2]) {
                    res[c3++] = fst[c1++];
                } else {
                    res[c3++] = snd[c2++];
                }
            }
            if (c1==fst.length) {
                for (int i = c2; i < snd.length; i++) {
                    res[c3++] = snd[i];
                }
            }
            else {
                for (int i = c1; i < fst.length; i++) {
                    res[c3++] = fst[i];
                }
            }
        }
        return res;
    }
}
