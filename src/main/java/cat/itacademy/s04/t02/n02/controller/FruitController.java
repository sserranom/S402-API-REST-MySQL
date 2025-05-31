package cat.itacademy.s04.t02.n02.controller;

import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService service;

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit){
        Fruit newFruit = service.addFruit(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> update(@RequestBody Fruit fruit){
        Fruit updatedFruit = service.updateFruit(fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<Fruit>> getOne(@PathVariable int id){
        Optional<Fruit> fruit = service.getFruitById(id);
        return ResponseEntity.ok(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<Fruit>>  getAll(){
        return ResponseEntity.ok(service.getAllFruit());
    }

}
