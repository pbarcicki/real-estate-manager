package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.exception.AllFieldsAreNullException;
import projects.realestatemanager.web.command.SearchApartmentCommand;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    private final EntityManager entityManager;

    public String search(SearchApartmentCommand searchApartmentCommand) {
        log.debug("Developer filter from : {}", searchApartmentCommand);

        //todo check if all fields are null or empty
        if (false) {
            log.debug("All fields are null!");
            throw new AllFieldsAreNullException("All fields are null!");
        }

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Apartment> aptCriteria = cb.createQuery(Apartment.class);
        Root<Apartment> root = aptCriteria.from(Apartment.class);
        aptCriteria.select(root);

        List<Predicate> searchPredicates = new ArrayList<>();
        searchPredicates.add(cb.equal(root.get("active"), true));

        if (searchApartmentCommand.getDeveloperId() !=null ) {
            root.join("building").join("developer");
            searchPredicates.add(cb.equal(root.get("building").get("developer").get("id"), searchApartmentCommand.getDeveloperId()));
        }

        if (searchApartmentCommand.getStreet() != null && searchApartmentCommand.getStreet() != "") {
            root.join("building");
            searchPredicates.add(cb.equal(root.get("building").get("street"), searchApartmentCommand.getStreet()));
        }

        if (searchApartmentCommand.getMinFloor() != null) {
            searchPredicates.add(cb.gt(root.get("floor"), searchApartmentCommand.getMinFloor()));
        }

        if (searchApartmentCommand.getMaxFloor() != null) {
            searchPredicates.add(cb.lt(root.get("floor"), searchApartmentCommand.getMaxFloor()));
        }

        if (searchApartmentCommand.getMinArea() != null) {
            searchPredicates.add(cb.gt(root.get("area"), searchApartmentCommand.getMinArea()));
        }

        if (searchApartmentCommand.getMaxArea() != null) {
            searchPredicates.add(cb.lt(root.get("area"), searchApartmentCommand.getMaxArea()));
        }

        if (searchApartmentCommand.getMinRoomsNumber() != null) {
            searchPredicates.add(cb.gt(root.get("roomsNumber"), searchApartmentCommand.getMinRoomsNumber()));
        }

        if (searchApartmentCommand.getMaxRoomsNumber() != null) {
            searchPredicates.add(cb.lt(root.get("roomsNumber"), searchApartmentCommand.getMaxRoomsNumber()));
        }

        if (searchApartmentCommand.getTypeOfKitchen() != null && searchApartmentCommand.getTypeOfKitchen() != "") {
            searchPredicates.add(cb.equal(root.get("typeOfKitchen"), searchApartmentCommand.getTypeOfKitchen()));
        }

        if (searchApartmentCommand.getMinPrice() != null) {
            searchPredicates.add(cb.gt(root.get("price"), searchApartmentCommand.getMinPrice()));
        }

        if (searchApartmentCommand.getMaxPrice() != null) {
            searchPredicates.add(cb.lt(root.get("price"), searchApartmentCommand.getMaxPrice()));
        }

        if (searchApartmentCommand.getMinPricePerSquareMeter() != null) {
            searchPredicates.add(cb.gt(root.get("pricePerSquareMeter"), searchApartmentCommand.getMinPricePerSquareMeter()));
        }

        if (searchApartmentCommand.getMaxPricePerSquareMeter() != null) {
            searchPredicates.add(cb.lt(root.get("pricePerSquareMeter"), searchApartmentCommand.getMaxPricePerSquareMeter()));
        }

        if (searchApartmentCommand.getMarketType() != null && searchApartmentCommand.getMarketType() != "") {
            searchPredicates.add(cb.equal(root.get("marketType"), searchApartmentCommand.getMarketType()));
        }

        if (searchApartmentCommand.getMaxDistanceToKindergarten() != null) {
            root.join("building");
            searchPredicates.add(cb.lt(root.get("building").get("distanceToKindergarten"), searchApartmentCommand.getMaxDistanceToKindergarten()));
        }

        if (searchApartmentCommand.getMaxDistanceToSchool() != null) {
            root.join("building");
            searchPredicates.add(cb.lt(root.get("building").get("distanceToSchool"), searchApartmentCommand.getMaxDistanceToSchool()));
        }

        if (searchApartmentCommand.getMaxDistanceToShoppingCenters() != null) {
            root.join("building");
            searchPredicates.add(cb.lt(root.get("building").get("distanceToShoppingCenters"), searchApartmentCommand.getMaxDistanceToShoppingCenters()));
        }

        if (searchApartmentCommand.getMaxDistanceToPark() != null) {
            root.join("building");
            searchPredicates.add(cb.lt(root.get("building").get("distanceToPark"), searchApartmentCommand.getMaxDistanceToPark()));
        }

        if (searchApartmentCommand.getWindowsDirection() != null && searchApartmentCommand.getWindowsDirection() != "") {
            searchPredicates.add(cb.equal(root.get("windowsDirection"), searchApartmentCommand.getWindowsDirection()));
        }

        if (searchApartmentCommand.getView() != null && searchApartmentCommand.getView() != "") {
            searchPredicates.add(cb.equal(root.get("view"), searchApartmentCommand.getView()));
        }

        if (searchApartmentCommand.getStatus() != null && searchApartmentCommand.getStatus() != "") {
            searchPredicates.add(cb.equal(root.get("status"), searchApartmentCommand.getStatus()));
        }

        if (searchApartmentCommand.getExclusivity() != null) {
            searchPredicates.add(cb.equal(root.get("exclusivity"), searchApartmentCommand.getExclusivity()));
        }

        if (searchApartmentCommand.getStorageRoom() != null) {
            searchPredicates.add(cb.equal(root.get("storageRoom"), searchApartmentCommand.getStorageRoom()));
        }

        if (searchApartmentCommand.getOnCorner() != null) {
            searchPredicates.add(cb.equal(root.get("onCorner"), searchApartmentCommand.getOnCorner()));
        }

        if (searchApartmentCommand.getIsParkingAvailable() != null) {
            root.join("building");
            searchPredicates.add(cb.equal(root.get("building").get("isParkingAvailable"), searchApartmentCommand.getIsParkingAvailable()));
        }

        if (searchApartmentCommand.getIsGarageAvailable() != null) {
            root.join("building");
            searchPredicates.add(cb.equal(root.get("building").get("isGarageAvailable"), searchApartmentCommand.getIsGarageAvailable()));
        }

        if (searchApartmentCommand.getIsElevatorAvailable() != null) {
            root.join("building");
            searchPredicates.add(cb.equal(root.get("building").get("isElevatorAvailable"), searchApartmentCommand.getIsElevatorAvailable()));
        }

        if (searchApartmentCommand.getIsConnectedToMedia() != null) {
            root.join("building");
            searchPredicates.add(cb.equal(root.get("building").get("isConnectedToMedia"), searchApartmentCommand.getIsConnectedToMedia()));
        }

        if (searchApartmentCommand.getMinBuildingRealizationTerm() != null) {
            root.join("building");
            searchPredicates.add(cb.greaterThan(root.get("building").get("buildingRealizationTerm"), searchApartmentCommand.getMinBuildingRealizationTerm()));
        }

        if (searchApartmentCommand.getMaxBuildingRealizationTerm() != null) {
            root.join("building");
            searchPredicates.add(cb.lessThan(root.get("building").get("buildingRealizationTerm"), searchApartmentCommand.getMaxBuildingRealizationTerm()));
        }

        aptCriteria.select(root).where(cb.and(searchPredicates.toArray(new Predicate[]{})));
        TypedQuery<Apartment> query = entityManager.createQuery(aptCriteria);

        List<Apartment> apts = query.getResultList();
        log.debug("Received {} apartments", apts.size());

        List<Long> finalResults = query.getResultList().stream().map(apt -> apt.getId()).collect(Collectors.toList());
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
}
