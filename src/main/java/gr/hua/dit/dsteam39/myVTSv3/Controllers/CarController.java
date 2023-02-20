package gr.hua.dit.dsteam39.myVTSv3.Controllers;

import gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects.CarDAO;
import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;
import gr.hua.dit.dsteam39.myVTSv3.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired(required = false)
    private CarDAO carDAO;

    @Autowired(required = false)
    private SellerService sellerService;

    @GetMapping("/")
    public List<Car> getAll() {
        return carDAO.findAll();
    }

    @PostMapping("/check")
    @Valid
    Car save(@Valid @RequestBody Car car) {
        car.setId(0);
        carDAO.save(car);
        return car;
    }
    @GetMapping("/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
    Car get(@PathVariable int id) {
        Car car = carDAO.findById(id);
        return car;
    }

    @PostMapping("/{id}/seller")
    Seller addSeller(@PathVariable int cid, @RequestBody Seller seller) {
        int sellerId = seller.getId();
        Car car = carDAO.findById(cid);

        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nothing to Print");
        }

        if(sellerId != 0) {
            Seller seller1 = sellerService.findSeller(sellerId);
            car.setSeller(seller1);
            sellerService.saveSeller(seller);
            return seller1;
        }

        car.setSeller(seller);
        sellerService.saveSeller(seller);
        return seller;
    }

}

