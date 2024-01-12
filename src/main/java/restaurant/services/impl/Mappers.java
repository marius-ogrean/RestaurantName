package restaurant.services.impl;

import restaurant.dtos.*;
import restaurant.entities.*;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Mappers {
    public static CategoryDto mapCategoryToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .groups(category.getChoiceGroups().stream().map(Mappers::mapChoiceGroupToDto).collect(Collectors.toList()))
                .items(category.getFoodItems().stream().sorted(Comparator.comparing(FoodItem::getId)).map(Mappers::mapFoodItemToDto).collect(Collectors.toList()))
                .build();
    }

    public static ChoiceGroupDto mapChoiceGroupToDto(ChoiceGroup choiceGroup) {
        return ChoiceGroupDto.builder()
                .id(choiceGroup.getId())
                .name(choiceGroup.getName())
                .required(choiceGroup.getRequired())
                .options(choiceGroup.getOptions().stream().sorted(Comparator.comparing(Option::getId)).map(Mappers::mapOptionToDto).collect(Collectors.toList()))
                .build();
    }

    public static OptionDto mapOptionToDto(Option option) {
        return OptionDto.builder()
                .id(option.getId())
                .name(option.getName())
                .price(option.getPrice())
                .build();
    }

    public static FoodItemDto mapFoodItemToDto(FoodItem foodItem) {
        return FoodItemDto.builder()
                .id(foodItem.getId())
                .name(foodItem.getName())
                .price(foodItem.getPrice())
                .description(foodItem.getDescription())
                .categoryId(foodItem.getCategory().getId())
                .groups(foodItem.getChoiceGroups().stream().sorted(Comparator.comparing(ChoiceGroup::getId)).map(Mappers::mapChoiceGroupToDto).collect(Collectors.toList()))
                .build();
    }

    public static MenuDto mapMenuToDto(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .currency(menu.getCurrency())
                .categories(menu.getCategories().stream().sorted(Comparator.comparing(Category::getId)).map(Mappers::mapCategoryToDto).collect(Collectors.toList()))
                .build();
    }
}
