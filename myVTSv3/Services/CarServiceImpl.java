package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects.CarDAO;
import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDAO carDAO;

    @Override
    @Transactional
    public List<Car> getCars() {
        return carDAO.findAll();
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carDAO.save(car);
    }

    @Override
    @Transactional
    public Car findCar(int id) {
        return carDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        carDAO.delete(id);
    }
}
