package ke.co.ngonyoku.keroma.Keroma;

import ke.co.ngonyoku.keroma.Keroma.model.Category;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import ke.co.ngonyoku.keroma.Keroma.model.User;
import ke.co.ngonyoku.keroma.Keroma.repository.CategoryRepository;
import ke.co.ngonyoku.keroma.Keroma.repository.MenuItemRepository;
import ke.co.ngonyoku.keroma.Keroma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Category soup = new Category("SOUP");
        Category breakfast = new Category("BREAKFAST");
        Category meat = new Category("MEAT");
        Category fastFoods = new Category("FAST FOODS");

        categoryRepository.save(new Category("PIZZA"));
        categoryRepository.save(new Category("SEA FOOD"));
        categoryRepository.save(breakfast);
        categoryRepository.save(new Category("PASTRY"));
        categoryRepository.save(new Category("ALCOHOL"));

//        MenuItem chipsMasala = new MenuItem("Chips Masala", "", 200d);
//        chipsMasala.getCategories().add(categoryRepository.save(fastFoods));
//        MenuItem beef = new MenuItem("Beef STEAK", "2KG Roasted Beef Steak and Ugali", 2500d);
//        beef.getCategories().add(categoryRepository.save(meat));
//        MenuItem chickenSoup = new MenuItem("Chicken Soup", "1 bowl of Chicken Soup, \n", 2500d);
//        chickenSoup.getCategories().add(categoryRepository.save(soup));
//
//        menuItemRepository.save(chipsMasala);
//        menuItemRepository.save(beef);
//        menuItemRepository.save(chickenSoup);
    }
}
