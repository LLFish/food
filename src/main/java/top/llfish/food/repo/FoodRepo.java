package top.llfish.food.repo;

import org.springframework.data.repository.CrudRepository;
import top.llfish.food.model.Food;

import java.util.List;

public interface FoodRepo extends CrudRepository<Food, Integer> {
    public List<Food> findAllBy();
    public List<Food> findAllByFinished(char finished);
}
