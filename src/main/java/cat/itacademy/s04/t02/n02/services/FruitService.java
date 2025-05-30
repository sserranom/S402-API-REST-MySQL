package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository repository;

    public Fruit addFruit(Fruit fruit){
        return repository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit){
        return repository.save(fruit);
    }

    public void deleteFruit(int id){
        repository.deleteById(id);
    }

    public Optional<Fruit> getFruitById(int id){
        return repository.findById(id);
    }

    public List<Fruit> getAllFruit(){
        return repository.findAll();
    }

}
