package methods.test;

import methods.api.Product;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProductTest {

    public static void main(String[] args) {
        testGetters(Product.class);
        testSetters(Product.class);
    }

    public static void testSetters(Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();

        for(Field field: fields) {
            String setterName = "set" + capitalizeFirstLetter(field.getName());

            Method setterMethod = null;
            try {
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(String.format("Setter %s not found", setterName));
            }

            if(!setterMethod.getReturnType().equals(void.class)) {
                throw new IllegalStateException(String.format("Setter method %s has to return void", setterName));
            }
        }
    }

    public static void testGetters(Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();

        Map<String ,Method> methodNameToMethod = mapMethodNameToMethod(dataClass);

        for (Field field: fields) {
            String getterName = "get" + capitalizeFirstLetter(field.getName());

            if(!methodNameToMethod.containsKey(getterName)) {
                throw new IllegalStateException(String.format("Field %s doesn't have a getter", field.getName()));
            }

            Method getter = methodNameToMethod.get(getterName);

            if(!getter.getReturnType().equals(field.getType())) {
                throw new IllegalStateException(
                        String.format("Getter Method %s() has return type %s but expected %s",
                                getter.getName(),
                                getter.getReturnType().getTypeName(),
                                field.getType().getTypeName())
                );
            }

            if(getter.getParameterCount() > 0) {
                throw new IllegalStateException(String.format("Getter %s has %d arguments", getterName, getter.getParameterCount()));
            }
        }
    }

    private static String capitalizeFirstLetter(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {
        Method[] allMethods = dataClass.getMethods();

        Map<String,Method> nameToMethod = new HashMap<>();

        for(Method method: allMethods) {
            nameToMethod.put(method.getName(), method);
        }

        return nameToMethod;
    }
}
