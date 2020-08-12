package top.llfish.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.llfish.food.model.Food;
import top.llfish.food.repo.FoodRepo;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class foodController {
    @Autowired
    private FoodRepo foodRepo;

    public foodController(FoodRepo foodRepo) {
        super();
    }

    @GetMapping("/all")
    public List<Food> getGogal() {
        return foodRepo.findAllBy();
    }

    @GetMapping("")
    public List<Food> getByFinish(char finished) {
        int test = 0;
        if(finished != '是' && finished != '否') {
            return null;
        }

        return foodRepo.findAllByFinished(finished);
    }

    @PostMapping("/food")
    public boolean addFood(@RequestBody  Food food)
    {
        food.initInFirstTime();
        this.foodRepo.save(food);
        return true;
    }

    @PutMapping("/food/{id}")
    public boolean editFood_Finished(@PathVariable("id") Food food, char finished)
    {
        if(food == null) {
            return false;
        }
        if(finished != '是' && finished != '否'){
            return false;
        }

        food.setFinished(finished);
        foodRepo.save(food);
        return true;
    }

    @DeleteMapping("/food/{id}")
    public boolean deleteFood(int id)
    {
        try {
            foodRepo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
