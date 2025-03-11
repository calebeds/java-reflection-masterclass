package annotations.app.http;

import annotations.app.annotationsapp.InitializerClass;
import annotations.app.annotationsapp.InitializerMethod;

@InitializerClass
public class ServiceRegistry {
    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
