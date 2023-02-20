package gr.hua.dit.dsteam39.myVTSv3.Controllers;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Buyer;
import gr.hua.dit.dsteam39.myVTSv3.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerRepository buyerRepository;

    @GetMapping("")
    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }
}
