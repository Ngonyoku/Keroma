package ke.co.ngonyoku.keroma.Keroma;

import ke.co.ngonyoku.keroma.Keroma.model.Category;
import ke.co.ngonyoku.keroma.Keroma.model.Image;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import ke.co.ngonyoku.keroma.Keroma.model.User;
import ke.co.ngonyoku.keroma.Keroma.repository.CategoryRepository;
import ke.co.ngonyoku.keroma.Keroma.repository.MenuItemRepository;
import ke.co.ngonyoku.keroma.Keroma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        User adminUser = new User(1L, "ADMIN", "ADMIN", "kbanda.0fficial@gmail.com", "root");
        userRepository.save(adminUser);

        MenuItem chipsMasala = new MenuItem("Chips Masala", "Chips Karanga", 150D);
        MenuItem burger = new MenuItem("Chicken Burger", "Chicken burger", 150D);
        MenuItem ugaliBeef = new MenuItem("Ugali Beef", "Ugali, Beef Stew", 150D);
        MenuItem ugaliSmaki = new MenuItem("Ugali Samaki", "Ugali, Tilapia Fish", 250D);
        MenuItem pilau = new MenuItem("Pilau", "Rice Pilau, Beef Stew", 150D);
        MenuItem ugaliMatumbo = new MenuItem("Ugali Matumbo", "Ugali, Matumbo", 130D);

        chipsMasala.addImage(new Image(null, "chips_masala.jpg", chipsMasala));
        burger.addImage(new Image(null, "burger.jpg", burger));
        ugaliSmaki.addImage(new Image(null, "ugali_samaki.jpg", ugaliSmaki));
        ugaliBeef.addImage(new Image(null, "ugali_beef.jpg", ugaliBeef));
        ugaliMatumbo.addImage(new Image(null, "ugali_matumbo.jpg", ugaliMatumbo));
        pilau.addImage(new Image(null, "pilau.jpg", pilau));

        menuItemRepository.save(chipsMasala);
        menuItemRepository.save(ugaliBeef);
        menuItemRepository.save(burger);
        menuItemRepository.save(ugaliSmaki);
        menuItemRepository.save(pilau);
        menuItemRepository.save(ugaliMatumbo);
    }
}
