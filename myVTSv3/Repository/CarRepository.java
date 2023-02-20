package gr.hua.dit.dsteam39.myVTSv3.Repository;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
    List<Car> findById(int id);
    List<Car> findByRegisternumber(String registernumber);
}
