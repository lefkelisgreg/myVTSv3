package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public interface CarService {

    public List<Car> getCars();

    public void saveCar(Car car);

    public Car findCar(int id);

    public void deleteCar(int id);
}
