package annotations.app.databases;

import annotations.app.annotationsapp.InitializerClass;
import annotations.app.annotationsapp.InitializerMethod;

@InitializerClass
public class DatabaseConnection {
    @InitializerMethod
    public void connectToDatabase1() {
        System.out.println("Connecting to database 1");
    }

    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }

}
