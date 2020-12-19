package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component @Profile("heroku")
@Slf4j @RequiredArgsConstructor
public class DataLoaderManager {

    private final List<DataLoader> dataLoaders;

    @PostConstruct
    public void orderLoaders(){
        Collections.sort(dataLoaders);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void loadData() {
        log.debug("Loading default data");
        dataLoaders.forEach(DataLoader::loadData);
    }
}
