package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component @Profile("heroku")
@Slf4j @RequiredArgsConstructor
public class DataLoadingManager {

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        log.debug("Loading default data");
    }
}
