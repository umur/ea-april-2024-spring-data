package springData.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springData.example.demo.Repository.CategoryRepo;
import springData.example.demo.domain.Category;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }
    public Optional<Category> getCategoryById(Long id){
        return categoryRepo.findById(id);
    }
    public void createCategory(Category category){
        categoryRepo.save(category);
    }
    public void updateCategory(Category category){
        categoryRepo.save(category);
    }
    public void deleteCategoryById(long id){
        categoryRepo.deleteById(id);
    }
}
