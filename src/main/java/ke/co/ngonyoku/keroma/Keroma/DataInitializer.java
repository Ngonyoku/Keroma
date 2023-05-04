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
        categoryRepository.save(new Category("RICE"));
        categoryRepository.save(new Category("SEA FOOD"));
        categoryRepository.save(breakfast);
        categoryRepository.save(new Category("PASTRY"));
        categoryRepository.save(new Category("ALCOHOL"));

        User adminUser = new User(1L, "ADMIN", "ADMIN", "kbanda.0fficial@gmail.com", "root");
        userRepository.save(adminUser);

        MenuItem chipsMasala = new MenuItem("Chips Masala", "Chips(Fries) Karanga", 150D);
        chipsMasala.getCategories().add(meat);
        MenuItem burger = new MenuItem("Chicken Burger", "Chicken burger", 250D);
        burger.getCategories().add(fastFoods);
        MenuItem ugaliBeef = new MenuItem("Ugali Beef", "Wet or Dry Fry, Ugali,  Greens (Sukuma Wiki/Cabbage)", 300D);
        MenuItem ugaliSmaki = new MenuItem("Ugali Samaki", "Ugali & Whole Grilled Tilapia Fish", 200D);
        MenuItem pilauBeef = new MenuItem("Pilau & Beef", "Pilau Rice, Beef Stew, Kachumbari(salad)", 350D);
        MenuItem ugaliMatumbo = new MenuItem("Ugali Matumbo", "Ugali, Matumbo", 130D);
        MenuItem chapatiBeans = new MenuItem("Chapati Beans", "(3) Chapati(Chapo), Beans(Mharagwe ,Madondo, mbosho)", 250D);
        MenuItem biryani = new MenuItem("biryani Rice & Beef", "Mixed Rice with vegetables, spices and eggs, Chicken/Beef/Goat meat and potatoes", 100D);
        MenuItem nyamaChoma = new MenuItem("Beef Choma", "1Kg Grilled Beef,\nUgali,\nKachumbari salad", 2000D);
        MenuItem mbuziChoma = new MenuItem("Mbuzi Choma", "Grilled Goat meat(Capra hircus), Ugali, Kachumbari\n1Kg", 2500D);
        MenuItem chickenPilau = new MenuItem("Pilau & Chicken", "1/4 Chicken, Rice Pilau, Kachumbari(salad)", 300d);
        MenuItem chaiMandazi = new MenuItem("Chai Mandazi", "Tea (Chai), 4 piece mandazi", 120d);
        MenuItem ugaliManagu = new MenuItem("Ugali Managu", "Ugali, Managu (African Nightshed), Kachumbari", 200D);
        MenuItem kukuChoma = new MenuItem("Kuku Choma", "Full Grilled Broiller Chicken", 450D);
        MenuItem spanishOmlet = new MenuItem("Spanish Omlette", "4 chicken eggs, green pepper, red pepper", 400D);


        chipsMasala.addImage(new Image(null, "chips_masala.jpg", chipsMasala));
        burger.addImage(new Image(null, "burger.jpg", burger));
        ugaliSmaki.addImage(new Image(null, "ugali_samaki.jpg", ugaliSmaki));
        ugaliBeef.addImage(new Image(null, "ugali_beef.jpg", ugaliBeef));
        ugaliMatumbo.addImage(new Image(null, "ugali_matumbo.jpg", ugaliMatumbo));
        pilauBeef.addImage(new Image(null, "pilau.jpg", pilauBeef));
        chickenPilau.addImage(new Image(null, "chicken_pilau.jpg", chickenPilau));
        nyamaChoma.addImage(new Image(null, "nyama_choma.jpg", nyamaChoma));
        mbuziChoma.addImage(new Image(null, "mbuzi_choma.jpg", mbuziChoma));
        mbuziChoma.addImage(new Image(null, "mbuzi_choma_2.jpg", mbuziChoma));
        kukuChoma.addImage(new Image(null, "kuku_choma.jpg", kukuChoma));
        spanishOmlet.addImage(new Image(null, "spanish_omlette.jpg", spanishOmlet));
        ugaliManagu.addImage(new Image(null, "ugali_managu.png", ugaliManagu));
        chapatiBeans.addImage(new Image(null, "chapati_beans.jpg", chapatiBeans));
        chaiMandazi.addImage(new Image(null, "chai_mandazi.jpg", chaiMandazi));
        biryani.addImage(new Image(null, "biryani.jpeg", biryani));

        menuItemRepository.save(nyamaChoma);
        menuItemRepository.save(mbuziChoma);
        menuItemRepository.save(kukuChoma);
        menuItemRepository.save(spanishOmlet);
        menuItemRepository.save(ugaliManagu);
        menuItemRepository.save(chapatiBeans);
        menuItemRepository.save(chaiMandazi);
        menuItemRepository.save(biryani);
        menuItemRepository.save(chipsMasala);
        menuItemRepository.save(ugaliBeef);
        menuItemRepository.save(burger);
        menuItemRepository.save(ugaliSmaki);
        menuItemRepository.save(pilauBeef);
        menuItemRepository.save(ugaliMatumbo);
        menuItemRepository.save(pilauBeef);
        menuItemRepository.save(chickenPilau);
    }
}
