package gr.hua.dit.dsteam39.myVTSv3.DataAccessObjects;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public interface CarDAO {

    public List<Car> findAll();

    public void save(Car car);
    public Car findById(int id);
    public void delete(int id);
}
