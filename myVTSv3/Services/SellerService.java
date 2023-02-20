package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;

import java.util.List;

/**
 * @author Petros
 * DS Team id: 39
 * @project myVTSv3
 */

public interface SellerService {

    public List<Seller> getSellers();
    public void saveSeller(Seller seller);

    public Seller findSeller(int id);
    public void deleteSeller(int id);

}
