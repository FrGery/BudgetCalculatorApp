package hu.progmasters.angularspringexamretakebudget.service;

import hu.progmasters.angularspringexamretakebudget.domain.Category;
import hu.progmasters.angularspringexamretakebudget.dto.incoming.CreateCategoryCommand;
import hu.progmasters.angularspringexamretakebudget.dto.outgoing.CategoryListItem;
import hu.progmasters.angularspringexamretakebudget.respository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryListItem> fetchAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryListItem::new)
                .toList();
    }

    public void createCategory(CreateCategoryCommand command) {
        if (categoryRepository.existsByName(command.getName())) {
            throw new IllegalArgumentException("Category already exists");
        }
        log.atInfo().log("Creating new category with name: {}", command.getName());
        log.atInfo().log("Creating category with name: {}", Category.class.getSimpleName());
        Category category = new Category();
        category.setName(command.getName());
        categoryRepository.save(category);
    }
}
