package mbassessment.controllers;

import mbassessment.models.Place;
import mbassessment.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Place> getPlaces() {
        return placeService.list();
    }

    @GetMapping(value = "/listByPage", produces = "application/json")
    public Page<Place> getPlacesWithPaging(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize){
        return placeService.list(pageNo,pageSize);

    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public Place save(@RequestBody Place place) {
        return placeService.save(place);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Place get(@PathVariable Long id) {
        return placeService.get(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Place update(@PathVariable Long id, @RequestBody Place place) {
        return placeService.update(id, place);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable Long id) {
        placeService.delete(id);
    }

    @GetMapping(value = "/3rdParty", produces = "application/json")
    public Object get() {
        return placeService.get3rdParty();
    }
}
