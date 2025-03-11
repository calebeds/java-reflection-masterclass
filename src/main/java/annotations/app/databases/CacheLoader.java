package annotations.app.databases;

import annotations.app.annotationsapp.InitializerClass;
import annotations.app.annotationsapp.InitializerMethod;

@InitializerClass
public class CacheLoader {
    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
