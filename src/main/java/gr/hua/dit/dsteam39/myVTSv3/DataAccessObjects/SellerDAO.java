package gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public interface SellerDAO {

    public List<Seller> findAll();

    public void save(Seller seller);

    public Seller findById(int id);

    // public Seller findByVATNumber(int VATnumber);

    public void delete(int id);
}
