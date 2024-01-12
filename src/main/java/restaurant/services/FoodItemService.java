package restaurant.services;

import restaurant.dtos.FoodItemDto;

import java.util.List;

public interface FoodItemService {
    List<FoodItemDto> getFoodItems();
    FoodItemDto getFoodItem(long id);
    Long createFoodItem(FoodItemDto foodItem);
    void updateFoodItem(Long id, FoodItemDto foodItem);
    void deleteFoodItem(Long id);
}
