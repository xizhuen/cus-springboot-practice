package mbassessment.services;

import mbassessment.models.Place;
import mbassessment.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public List<Place> list() {
        return placeRepository.findAll();
    }

//    Pagination
    @Transactional
    public Page<Place> list(Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return placeRepository.findAll(pageRequest);
    }

    @Transactional
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Transactional
    public Place get(Long id) {

        Optional<Place> placeOptional = placeRepository.findById(id);
        if (placeOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Place not found");
        }
        return placeOptional.get();
    }

//    Call 3rd Party
    public Object get3rdParty() {
        String uri = "https://cat-fact.herokuapp.com/facts/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    @Transactional
    public Place update(Long id, Place place) {
        Optional<Place> placeOptional = placeRepository.findById(id);
        if (placeOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Place not found");
        }
        Place existingPlace = placeOptional.get();
        existingPlace.setName(place.getName());
        return placeRepository.save(existingPlace);
    }

    @Transactional
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}
