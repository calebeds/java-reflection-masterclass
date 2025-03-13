package annotations.repeatableannotations.loaders;

import annotations.repeatableannotations.annotations.Annotations.ExecuteOnSchedule;
import annotations.repeatableannotations.annotations.Annotations.ScheduledExecutorClass;

@ScheduledExecutorClass
public class Cache {

    @ExecuteOnSchedule(periodSeconds = 5)
    @ExecuteOnSchedule(delaySeconds = 10, periodSeconds = 1)
    public static void reloadCache() {
        System.out.println("Reloading cache");
    }
}
