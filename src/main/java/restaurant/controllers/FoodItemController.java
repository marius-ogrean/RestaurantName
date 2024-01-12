package restaurant.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import restaurant.dtos.FoodItemDto;
import restaurant.services.FoodItemService;

import java.util.List;

@RestController
@RequestMapping("foodItems")
@Slf4j
@AllArgsConstructor
public class FoodItemController {
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItemDto> getFoodItems() {
        return foodItemService.getFoodItems();
    }

    @GetMapping(value = "/{id}")
    public FoodItemDto getFoodItem(@PathVariable long id) {
        return foodItemService.getFoodItem(id);
    }

    @PostMapping
    public Long createFoodItem(@RequestBody FoodItemDto foodItem) {
        return foodItemService.createFoodItem(foodItem);
    }

    @PutMapping(value = "/{id}")
    public void updateFoodItem(@PathVariable long id, @RequestBody FoodItemDto foodItem) {
        foodItemService.updateFoodItem(id, foodItem);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable long id) {
        foodItemService.deleteFoodItem(id);
    }
}
