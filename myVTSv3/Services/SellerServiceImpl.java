package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects.SellerDAO;
import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Petros
 * DS Team id: 39
 * @project myVTSv3
 */

public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDAO sellerDAO;
    @Override
    @Transactional
    public List<Seller> getSellers() {
        return sellerDAO.findAll();
    }

    @Override
    @Transactional
    public void saveSeller(Seller seller) {
        sellerDAO.save(seller);

    }

    @Override
    @Transactional
    public Seller findSeller(int id) {
        return sellerDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteSeller(int id) {
        sellerDAO.delete(id);

    }
}
