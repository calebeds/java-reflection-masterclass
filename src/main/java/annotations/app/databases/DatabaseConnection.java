package annotations.app.databases;

import annotations.app.annotationsapp.InitializerClass;
import annotations.app.annotationsapp.InitializerMethod;
import annotations.app.annotationsapp.RetryOperation;

import java.io.IOException;

@InitializerClass
public class DatabaseConnection {
    private int failCounter = 5;

    @RetryOperation(
            numberOfRetries = 10,
            retryExceptions = IOException.class,
            durationBetweenRetriesMs = 1000,
            failureMessage = "Connection to database 1 failed after retries"
    )
    @InitializerMethod
    public void connectToDatabase1() throws IOException {
        System.out.println("Connecting to database 1");
        if(failCounter > 0) {
            failCounter--;
            throw new IOException("Connection Failed");
        }

        System.out.println("Connection to database1 succeeded");
    }

    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }

}
