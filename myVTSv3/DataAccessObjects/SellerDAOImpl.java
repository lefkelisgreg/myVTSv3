package gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Seller;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Repository
public class SellerDAOImpl implements SellerDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Seller> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Seller", Seller.class);
        List<Seller> sellers = query.getResultList();
        return sellers;
    }

    @Override
    public void save(Seller seller) {
        Seller seller1 = entityManager.merge(seller);
    }

    @Override
    public Seller findById(int id) {
        return entityManager.find(Seller.class, id);
    }

//    @Override
//    public Seller findByVATNumber(int VATnumber) {
//        return entityManager.find(Seller.class, VATnumber);
//    }

    @Override
    public void delete(int id) {
        Seller seller
                 = entityManager.find(Seller.class, id);
        entityManager.remove(seller);
    }
}
