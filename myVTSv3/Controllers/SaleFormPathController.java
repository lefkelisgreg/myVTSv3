package gr.hua.dit.dsteam39.myVTSv3.Controllers;

import gr.hua.dit.dsteam39.myVTSv3.Entities.Car;
import gr.hua.dit.dsteam39.myVTSv3.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Controller
public class SaleFormPathController {

    @Autowired(required = false)
    private CarService carService;

    @GetMapping("/sell")
    public String showCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "sell";
    }
    @GetMapping("/carslist")
    public String showMyCar(Model model) {
        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return ("mycar");
    }

    @PostMapping(path = "/carform")
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.saveCar(car);
        return "redirect:/";
    }
}
