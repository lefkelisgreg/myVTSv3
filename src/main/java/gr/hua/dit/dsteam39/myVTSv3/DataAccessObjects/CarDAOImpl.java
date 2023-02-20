package gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects;


import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public class CarDAOImpl implements CarDAO {


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Car> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Car", Car.class);
        List<Car> cars = query.getResultList();
        return cars;
    }

    @Override
    public void save(Car car) {
        Car car1 = entityManager.merge(car);
    }

    @Override
    public Car findById(int id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public void delete(int id) {
        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);
    }
}
