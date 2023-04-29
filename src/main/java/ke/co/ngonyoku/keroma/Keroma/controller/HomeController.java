package ke.co.ngonyoku.keroma.Keroma.controller;

import ke.co.ngonyoku.keroma.Keroma.model.Category;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import ke.co.ngonyoku.keroma.Keroma.service.CategoryService;
import ke.co.ngonyoku.keroma.Keroma.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        List<Category> categories = categoryService.getAllCategories();


        model.addAttribute("menuItems", menuItems);
        model.addAttribute("categories", categories);
        return "index";
    }
}
