package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.exceptions.AlreadyExistException;
import cat.itacademy.s04.t02.n02.exceptions.NotFoundException;
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
        if (repository.findByName(fruit.getName()).isPresent()){
            throw new AlreadyExistException(fruit.getName() + " Already Exist");
        }
        return repository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit){
        if (!repository.existsById(fruit.getId())){
            throw new NotFoundException("Fruit" + fruit.getId() + "not found");
        }
        return repository.save(fruit);
    }

    public void deleteFruit(int id){
        if (!repository.existsById(id)){
            throw new NotFoundException("Fruit with id: " + id + " not found");
        }
        repository.deleteById(id);
    }

    public Optional<Fruit> getFruitById(int id){
        if (!repository.existsById(id)) {
            throw new NotFoundException("Fruit with ID " + id + " not found.");

        }
        return repository.findById(id);
    }

    public List<Fruit> getAllFruit(){
        return repository.findAll();
    }

}
