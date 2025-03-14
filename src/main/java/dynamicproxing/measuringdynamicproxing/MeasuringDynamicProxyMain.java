package dynamicproxing.measuringdynamicproxing;

import dynamicproxing.measuringdynamicproxing.external.DatabaseReader;
import dynamicproxing.measuringdynamicproxing.external.HttpClient;
import dynamicproxing.measuringdynamicproxing.external.impl.DatabaseReaderImpl;
import dynamicproxing.measuringdynamicproxing.external.impl.HttpClientImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MeasuringDynamicProxyMain {
    public static void main(String[] args) throws InterruptedException {
//        HttpClient httpClient = createProxy(new HttpClientImpl());
//        DatabaseReader databaseReader = createProxy(new DatabaseReaderImpl());
//
//        useHttpClient(httpClient);
//        useDatabaseReader(databaseReader);
        List<String> listOfGreetings = createProxy(new ArrayList<>());

        listOfGreetings.add("hello");
        listOfGreetings.add("good morning");
        listOfGreetings.remove("hello");
    }

    public static void useHttpClient(HttpClient httpClient) {
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");

        System.out.printf("Http response is %s%n", response);
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGameTable = databaseReader.countRowsInTable("GamesTable");

        System.out.printf("There are %s rows in GamesTable%n", rowsInGameTable);

        String[] data = databaseReader.readRow("SELECT * FROM GamesTable");

        System.out.printf("Received %s%n", String.join(" , ", data));
    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();

        TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);

        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }

    public static class TimeMeasuringProxyHandler implements InvocationHandler {
        private final Object originalObject;

        public TimeMeasuringProxyHandler(Object originalObject) {
            this.originalObject = originalObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;

            System.out.printf("Measuring Proxy - Before Executing method %s()%n", method.getName());

            long startTime = System.nanoTime();
            try {
                result = method.invoke(originalObject, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
            long endTime = System.nanoTime();

            System.out.printf("Measuring Proxy - Execution of %s() took %dns \n%n", method.getName(), endTime - startTime);

            return result;
        }
    }
}
