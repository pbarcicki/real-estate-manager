package projects.realestatemanager.service;

import antlr.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.ApartmentConverter;
import projects.realestatemanager.data.apartment.ApartmentSummary;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.exception.AllFieldsAreNullException;
import projects.realestatemanager.web.command.SearchApartmentCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class SearchService {

    private final BuildingRepository buildingRepository;
    private final DeveloperRepository developerRepository;
    private final ApartmentRepository apartmentRepository;
    private final ApartmentConverter apartmentConverter;

    public String search(SearchApartmentCommand searchApartmentCommand) {
        log.debug("Developer filter from : {}", searchApartmentCommand);
        List<Long> apartmentsId = new ArrayList<>();

        //todo check if all fields are null or empty
        if (false) {
            log.debug("All fields are null!");
            throw new AllFieldsAreNullException("All fields are null!");
        }

        if (searchApartmentCommand.getDeveloperId() != null) {
            Long developerId = searchApartmentCommand.getDeveloperId();
            log.debug("Developer id: {}", developerId);
            if (developerRepository.existsById(developerId)) {
                List<Building> buildings = buildingRepository.findAllByDeveloperId(developerId);
                log.debug("Found buildings: {}", buildings.size());
                apartmentsId = getApartmentsIdsFromBuildings(buildings);
                log.debug("apartment ids size: {}", apartmentsId.size());
            }
        }

        if (searchApartmentCommand.getStreet() != null) {
            List<Building> buildings = buildingRepository.findAllByStreet(searchApartmentCommand.getStreet());
            log.debug("Found buildings: {}", buildings.size());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartment ids size: {}", apartmentsId.size());
        }


        String ids = "";
        for (int i = 0; i < apartmentsId.size(); i++) {
            ids = ids + "id?" + apartmentsId.get(i) + "&";
        }
        if (ids.length() > 0 && ids != null) {
            ids = ids.substring(0,ids.length()-1);
        }
        log.debug("ids: {}", ids);
        return ids;
    }


    private List<Long> getApartmentsIdsFromBuildings(List<Building> buildings) {
        List<Apartment> apartments = new ArrayList<>();
        buildings.forEach(b -> {
            apartments.addAll(apartmentRepository.findAllByBuildingId(b.getId()));
        });

        List<Long> apartmentsIds = apartments.stream().map(Apartment::getId).collect(Collectors.toList());
        return apartmentsIds;
    }

    private List<Long> getFilteredResult(List<Long> input, List<Long> newIds) {
        List<Long> result = new ArrayList<>();
        if (input.isEmpty()) {
            return newIds;
        } else {
            for (Long id : input) {
                if (newIds.contains(id)) {
                    result.add(id);
                }
            }
            return result;
        }
    }
}
