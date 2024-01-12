package restaurant.services;

import org.junit.Assert;
import org.junit.Test;
import restaurant.dataAccess.CategoryRepository;
import restaurant.dataAccess.FoodItemRepository;
import restaurant.dtos.FoodItemDto;
import restaurant.entities.Category;
import restaurant.entities.FoodItem;
import restaurant.services.impl.FoodItemServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodItemServiceTest {
    @Test
    public void getFoodItemsTest() {
        FoodItemRepository foodItemRepository = mock(FoodItemRepository.class);
        CategoryRepository categoryRepository = mock(CategoryRepository.class);

        Category category = Category.builder()
                .id(22L)
                .build();

        when(foodItemRepository.findAll()).thenReturn(Arrays.asList(FoodItem.builder()
                        .id(1L)
                        .name("food1")
                        .description("food1 description")
                        .price(BigDecimal.valueOf(15))
                        .category(category)
                        .choiceGroups(new HashSet<>())
                        .build(),
                FoodItem.builder()
                        .id(2L)
                        .name("food2")
                        .description("food2 description")
                        .price(BigDecimal.valueOf(88))
                        .category(category)
                        .choiceGroups(new HashSet<>())
                        .build()));

        var service = new FoodItemServiceImpl(foodItemRepository, categoryRepository);

        var foodItems = service.getFoodItems();

        Assert.assertEquals(2, foodItems.size());

        Assert.assertArrayEquals(new Long[] {1L, 2L}, foodItems.stream().map(FoodItemDto::getId).toArray(Long[]::new));
    }

    private FoodItem savedFoodItem = null;

    private void setSavedFoodItem(FoodItem value) {
        savedFoodItem = value;
    }

    @Test
    public void updateFoodItemTest() {
        FoodItemRepository foodItemRepository = mock(FoodItemRepository.class);
        CategoryRepository categoryRepository = mock(CategoryRepository.class);

        when(categoryRepository.findById(22L)).thenReturn(Optional.of(Category.builder()
                        .id(22L)
                        .name("category")
                        .build()));

        when(foodItemRepository.findById(2L)).thenReturn(Optional.of(FoodItem.builder()
                        .id(2L)
                        .choiceGroups(new HashSet<>())
                        .name("name2")
                        .category(Category.builder()
                                .id(45L)
                                .build())
                        .build()));

        doAnswer(invocationOnMock -> {
            setSavedFoodItem(invocationOnMock.getArgument(0));
            return invocationOnMock.getArgument(0);
        }).when(foodItemRepository).save(any());

        var service = new FoodItemServiceImpl(foodItemRepository, categoryRepository);

        String newName = "updated name2";

        service.updateFoodItem(2L, FoodItemDto.builder()
                        .id(2L)
                        .name(newName)
                        .categoryId(22L)
                        .build());

        Assert.assertEquals(22L, (long)savedFoodItem.getCategory().getId());
        Assert.assertEquals(newName, savedFoodItem.getName());
    }
}
