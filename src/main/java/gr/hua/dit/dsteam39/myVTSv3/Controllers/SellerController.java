package gr.hua.dit.dsteam39.myVTSv3.Controllers;


import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;
import gr.hua.dit.dsteam39.myVTSv3.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired(required = false)
    private SellerService sellerService;

    @GetMapping("")
    List<Seller> getall() {
        return sellerService.getSellers();
    }

    @PostMapping("")
    Seller save(@Valid @RequestBody Seller seller) {
        seller.setId(0);
        sellerService.saveSeller(seller);
        return seller;
    }

    @GetMapping("/{id}")
    Seller get(@PathVariable int id) {
        Seller seller = sellerService.findSeller(id);
        return seller;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        sellerService.deleteSeller(id);
    }

}
