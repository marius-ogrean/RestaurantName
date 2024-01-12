package restaurant.services;

import restaurant.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    CategoryDto getCategory(long id);
    Long createCategory(CategoryDto category);
    void updateCategory(Long id, CategoryDto category);
    void deleteCategory(Long id);
}
