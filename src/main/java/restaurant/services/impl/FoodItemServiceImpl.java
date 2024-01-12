package restaurant.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.dataAccess.CategoryRepository;
import restaurant.dataAccess.FoodItemRepository;
import restaurant.dtos.FoodItemDto;
import restaurant.entities.FoodItem;
import restaurant.services.FoodItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
    private FoodItemRepository foodItemRepository;
    private CategoryRepository categoryRepository;

    private static final String INVALID_DATA = "Invalid data";

    @Override
    public List<FoodItemDto> getFoodItems() {
        return foodItemRepository.findAll().stream().map(Mappers::mapFoodItemToDto).collect(Collectors.toList());
    }

    @Override
    public FoodItemDto getFoodItem(long id) {
        return Mappers.mapFoodItemToDto(foodItemRepository.getById(id));
    }

    @Override
    public Long createFoodItem(FoodItemDto foodItem) {
        var category = categoryRepository.findById(foodItem.getCategoryId()).orElseThrow(() -> new RuntimeException(INVALID_DATA + " categoryId " + foodItem.getCategoryId()));

        var newFoodItem = FoodItem.builder()
                .category(category)
                .name(foodItem.getName())
                .description(foodItem.getDescription())
                .price(foodItem.getPrice())
                .build();

        foodItemRepository.save(newFoodItem);
        return newFoodItem.getId();
    }

    @Override
    public void updateFoodItem(Long id, FoodItemDto foodItem) {
        var category = categoryRepository.findById(foodItem.getCategoryId()).orElseThrow(() -> new RuntimeException(INVALID_DATA + " categoryId " + foodItem.getCategoryId()));

        var existingFoodItem = foodItemRepository.findById(id).orElseThrow(() -> new RuntimeException(INVALID_DATA + " id"));
        existingFoodItem.setName(foodItem.getName());
        existingFoodItem.setDescription(foodItem.getDescription());
        existingFoodItem.setPrice(foodItem.getPrice());
        existingFoodItem.setCategory(category);

        foodItemRepository.save(existingFoodItem);
    }

    @Override
    public void deleteFoodItem(Long id) {
        var existingFoodItem = foodItemRepository.findById(id).orElseThrow(() -> new RuntimeException(INVALID_DATA + " id"));
        foodItemRepository.delete(existingFoodItem);
    }
}
