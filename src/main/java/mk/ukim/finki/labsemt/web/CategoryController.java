package mk.ukim.finki.labsemt.web;

import mk.ukim.finki.labsemt.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping("list-categories")
    public List<Category> listAllCategories(){
        return Arrays.asList(Category.values());
    }
}
