package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.DeveloperConverter;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.exception.DeveloperAlreadyExistsException;
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.web.command.CreateDeveloperCommand;
import projects.realestatemanager.web.command.EditDeveloperCommand;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperConverter developerConverter;

    @Transactional
    public Long createDeveloper(CreateDeveloperCommand createDeveloperCommand) {
        log.debug("Dane DEWELOPERA do zapisania: {}", createDeveloperCommand);

        Developer developerToCreate = developerConverter.from(createDeveloperCommand);
        log.debug("Uzyskany OBIEKT do zapisu: {}", developerToCreate);

        if (developerRepository.existsByDeveloperName(developerToCreate.getDeveloperName())) {
            log.debug("UWAGA! Próba dodania istniejącego DEWELOPERA");
            throw new DeveloperAlreadyExistsException(String.format("DEWELOPER %s już istnieje", developerToCreate.getDeveloperName()));
        }

        setDefaultActive(developerToCreate);
        developerRepository.save(developerToCreate);
        log.debug("DEWELOPER zapisany: {}", developerToCreate);

        return developerToCreate.getId();
    }

    @Transactional
    public boolean edit(EditDeveloperCommand editDeveloperCommand) {
        Long id = editDeveloperCommand.getId();
        if (!developerRepository.existsById(id)) {
            log.debug("UWAGA! DEWELOPER o id={} nie istnieje!!!", id);
            throw new EntityDoesNotExistException(String.format("DEWELOPER o id=%s nie istnieje :(", id));
        }

        Developer developer = developerRepository.getOne(id);
        log.debug("DEWELOPER do edycji: {}", developer);
        developer = developerConverter.from(editDeveloperCommand, developer);

        log.debug("DEWELOPER zmodyfikowany {}", developer);
        return true;
    }

    @Transactional
    public List<DeveloperSummary> showAllDevelopers() {
        log.debug("Pobieranie informacji o DEWELOPERACH");

        return developerRepository.findAll().stream()
                .map(developerConverter::developerSummary)
                .collect(Collectors.toList());
    }

    @Transactional
    public DeveloperSummary showDeveloper(Long id) {
        log.debug("Wyszukiwanie DEWELOPERA o id={}", id);
        Developer developer = developerRepository.getOne(id);

        if (!developerRepository.existsById(id)) {
            log.debug("UWAGA! DEWELOPER o id={} nie istnieje!!!", id);
            throw new EntityDoesNotExistException(String.format("DEWELOPER o id=%s nie istnieje :(", id));
        }

        return developerConverter.developerSummary(developer);
    }

    private void setDefaultActive(Developer developerToCreate) {
        developerToCreate.setIsActive(Boolean.TRUE);
    }

    @Transactional
    public boolean delete(Long id) {
        log.debug("Wyszukiwanie DEWELOPERA o id={}", id);
        Developer developer = developerRepository.getOne(id);

        if (!developerRepository.existsById(id)) {
            log.debug("UWAGA! DEWELOPER o id={} nie istnieje!!!", id);
            throw new DeveloperDoesNotExistException(String.format("DEWELOPER o id=%s nie istnieje :(", id));
        }

        developerRepository.delete(developer);
        log.debug("DEWELOPER od id={} został pomyślnie usunięty",id);
        return true;
    }

}