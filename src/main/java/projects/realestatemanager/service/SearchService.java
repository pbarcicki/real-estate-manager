package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
                List<Building> buildings = buildingRepository.findAllByDeveloperIdAndIsActive(developerId, true);
                apartmentsId = getApartmentsIdsFromBuildings(buildings);
                log.debug("buildings by developer: {}", apartmentsId.size());
            }
        }

        if (searchApartmentCommand.getStreet() != null && searchApartmentCommand.getStreet() != "") {
            List<Building> buildings = buildingRepository.findAllByStreet(searchApartmentCommand.getStreet());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by street: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxDistanceToKindergarten() != null) {
            List<Building> buildings = buildingRepository.findAllByMaxDistanceToKindergarten(searchApartmentCommand.getMaxDistanceToKindergarten());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min kindergarten: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxDistanceToSchool() != null) {
            List<Building> buildings = buildingRepository.findAllByMaxDistanceToSchool(searchApartmentCommand.getMaxDistanceToSchool());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min school: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxDistanceToShoppingCenters() != null) {
            List<Building> buildings = buildingRepository.findAllByMaxDistanceToShoppingCenters(searchApartmentCommand.getMaxDistanceToShoppingCenters());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min shopping malls: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxDistanceToPark() != null) {
            List<Building> buildings = buildingRepository.findAllByMaxDistanceToPark(searchApartmentCommand.getMaxDistanceToPark());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min park: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getIsParkingAvailable() != null) {
            List<Building> buildings = buildingRepository.findAllByParking(searchApartmentCommand.getIsParkingAvailable());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by parking: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getIsGarageAvailable() != null) {
            List<Building> buildings = buildingRepository.findAllByGarage(searchApartmentCommand.getIsGarageAvailable());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by garage: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getIsElevatorAvailable() != null) {
            List<Building> buildings = buildingRepository.findAllByElevator(searchApartmentCommand.getIsElevatorAvailable());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by elevator: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getIsConnectedToMedia() != null) {
            List<Building> buildings = buildingRepository.findAllByConnectedToMedia(searchApartmentCommand.getIsConnectedToMedia());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by media: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinBuildingRealizationTerm() != null) {
            List<Building> buildings = buildingRepository.findAllMinRealizationTerm(searchApartmentCommand.getMinBuildingRealizationTerm());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min realization term: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxBuildingRealizationTerm() != null) {
            List<Building> buildings = buildingRepository.findAllMaxRealizationTerm(searchApartmentCommand.getMaxBuildingRealizationTerm());
            List<Long> newIds = getApartmentsIdsFromBuildings(buildings);
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max realization term: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinFloor() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinFloor(searchApartmentCommand.getMinFloor());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min floor: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxFloor() != null) {
            List<Long> newIds = apartmentRepository.findAllByMaxFloor(searchApartmentCommand.getMaxFloor());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max floor: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinArea() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinArea(searchApartmentCommand.getMinArea());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max floor: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxArea() != null) {
            List<Long> newIds = apartmentRepository.findAllByMaxArea(searchApartmentCommand.getMaxArea());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max floor: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinRoomsNumber() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinRooms(searchApartmentCommand.getMinRoomsNumber());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min rooms: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxRoomsNumber() != null) {
            List<Long> newIds = apartmentRepository.findAllByMaxRooms(searchApartmentCommand.getMaxRoomsNumber());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max rooms: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getTypeOfKitchen() != null && searchApartmentCommand.getTypeOfKitchen() != "") {
            List<Long> newIds = apartmentRepository.findAllByTypeOfKitchen(searchApartmentCommand.getTypeOfKitchen());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max kitchen: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinPrice() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinPrice(searchApartmentCommand.getMinPrice());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min price: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxPrice() != null) {
            List<Long> newIds = apartmentRepository.findAllByMaxPrice(searchApartmentCommand.getMaxPrice());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max price: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMinPricePerSquareMeter() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinPricePerM(searchApartmentCommand.getMinPricePerSquareMeter());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by min price per m2: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMaxPricePerSquareMeter() != null) {
            List<Long> newIds = apartmentRepository.findAllByMinPricePerM(searchApartmentCommand.getMaxPricePerSquareMeter());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by max price per m2: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getMarketType() != null && searchApartmentCommand.getMarketType() != "") {
            List<Long> newIds = apartmentRepository.findAllByMarketType(searchApartmentCommand.getMarketType());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by market type: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getWindowsDirection() != null && searchApartmentCommand.getWindowsDirection() != "") {
            List<Long> newIds = apartmentRepository.findAllByWindowsDirection(searchApartmentCommand.getWindowsDirection());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by windows direction: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getView() != null && searchApartmentCommand.getView() != "") {
            List<Long> newIds = apartmentRepository.findAllByView(searchApartmentCommand.getView());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by view: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getStatus() != null && searchApartmentCommand.getStatus() != "") {
            List<Long> newIds = apartmentRepository.findAllByStatus(searchApartmentCommand.getStatus());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by apt status: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getExclusivity() != null) {
            List<Long> newIds = apartmentRepository.findAllByExclusivity(searchApartmentCommand.getExclusivity());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by exclusivity: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getStorageRoom() != null) {
            List<Long> newIds = apartmentRepository.findAllByStorageRoom(searchApartmentCommand.getStorageRoom());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by storage room: {}", apartmentsId.size());
        }

        if (searchApartmentCommand.getOnCorner() != null) {
            List<Long> newIds = apartmentRepository.findAllByStorageRoom(searchApartmentCommand.getOnCorner());
            apartmentsId = getFilteredResult(apartmentsId, newIds);
            log.debug("apartments by corner: {}", apartmentsId.size());
        }

        //filtering apartments - removing not active from the list
        List<Long> finalResults = apartmentRepository.findAllByActive(apartmentsId);
        log.debug("Final result sum: {}", finalResults.size());

        String ids = "";
        for (int i = 0; i < finalResults.size(); i++) {
            ids = ids + finalResults.get(i) + "+";
        }
        if (ids.length() > 0 && ids != null) {
            ids = ids.substring(0, ids.length() - 1);
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
