package cat.itacademy.s04.t02.n02.controller;

import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService service;

    @PostMapping("/add")
    public Fruit add(@RequestBody Fruit fruit){
        return service.addFruit(fruit);
    }

    @PutMapping("/update")
    public Fruit update(@RequestBody Fruit fruit){
        return service.updateFruit(fruit);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        service.deleteFruit(id);
    }

    @GetMapping("/getOne/{id}")
    public Optional<Fruit> getOne(@PathVariable int id){
        return service.getFruitById(id);
    }

    @GetMapping("/getAll")
    public List<Fruit> getAll(){
        return service.getAllFruit();
    }

}
