package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayFlattening {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((int[])concat(int.class, 1, 2, 3, new int[]{1, 5, 6})));
    }

    public static  <T> T concat(Class<?> type, Object... arguments) {
        if(arguments.length == 0) {
            return null;
        }

        List<Object> elements = new ArrayList<>();
        for(Object argument: arguments) {
            if(argument.getClass().isArray()) {
                int length = Array.getLength(argument);

                for(int i = 0; i < length; i++) {
                    elements.add(Array.get(argument, i));
                }
            } else {
                elements.add(argument);
            }
        }

        Object flattenedArray = Array.newInstance(type, elements.size());

        for (int i = 0; i < elements.size(); i++) {
            Array.set(flattenedArray, i, elements.get(i));
        }

        return (T) flattenedArray;
    }
}
