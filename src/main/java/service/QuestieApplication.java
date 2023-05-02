package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines the base URI for all resource URIs (where the APIs are located
 */
@ApplicationPath("/getQuest")

/**
 * Declares the root resource and provider classes
 */
public class QuestieApplication extends Application {
    public Set<Class<?>> getQuest() {
        HashSet h = new HashSet<Class<?>>();
        h.add(QuestieService.class);
        return h;
    }
}