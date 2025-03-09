package arrays;

import java.lang.reflect.Array;

public class GetArrayElement {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 6, 7};
        System.out.println(getArrayElement(array, 2));
        System.out.println(getArrayElement(array, -2));
    }
    
    public static Object getArrayElement(Object array, int index) {
        if (index >= 0) {
            return Array.get(array, index);
        }
        int arrayLength = Array.getLength(array);
        return Array.get(array, arrayLength + index);
    }
}