package annotations.app.configs;

import annotations.app.annotationsapp.InitializerClass;
import annotations.app.annotationsapp.InitializerMethod;

@InitializerClass
public class ConfigsLoader {
    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }
}
