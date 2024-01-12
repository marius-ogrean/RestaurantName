package restaurant.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.dataAccess.CategoryRepository;
import restaurant.dtos.CategoryDto;
import restaurant.entities.Category;
import restaurant.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    private static final String INVALID_ID_ERROR = "Invalid category id";

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream()
                .map(Mappers::mapCategoryToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(long id) {
        return categoryRepository.findById(id).map(Mappers::mapCategoryToDto).orElse(null);
    }

    @Override
    public Long createCategory(CategoryDto category) {
        var newCategory = Category.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();

        categoryRepository.save(newCategory);

        return newCategory.getId();
    }

    @Override
    public void updateCategory(Long id, CategoryDto category) {
        var existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(INVALID_ID_ERROR));

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        var existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(INVALID_ID_ERROR));
        categoryRepository.delete(existingCategory);
    }
}
