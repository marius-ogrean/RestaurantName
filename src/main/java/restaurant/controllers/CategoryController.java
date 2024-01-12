package restaurant.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import restaurant.dtos.CategoryDto;
import restaurant.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("categories")
@Slf4j
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(value = "/{id}")
    public CategoryDto getCategory(@PathVariable long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Long createCategory(@RequestBody CategoryDto category) {
        return categoryService.createCategory(category);
    }

    @PutMapping(value = "/{id}")
    public void updateCategory(@PathVariable long id, @RequestBody CategoryDto category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}
