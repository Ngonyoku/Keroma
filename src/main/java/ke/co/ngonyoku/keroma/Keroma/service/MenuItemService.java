package ke.co.ngonyoku.keroma.Keroma.service;

import jakarta.persistence.EntityNotFoundException;
import ke.co.ngonyoku.keroma.Keroma.model.Category;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import ke.co.ngonyoku.keroma.Keroma.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) {
        MenuItem menuItem = getMenuItemById(id);
        menuItem.setName(menuItemDetails.getName());
        menuItem.setDescription(menuItemDetails.getDescription());
        menuItem.setPrice(menuItemDetails.getPrice());
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        MenuItem menuItem = getMenuItemById(id);
        menuItemRepository.delete(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public Page<MenuItem> getAllMenuItems(int pageSize) {
        Pageable pageable = PageRequest.of(0, pageSize);
        return menuItemRepository.findAll(pageable);
    }

    public Page<MenuItem> getAllMenuItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return menuItemRepository.findAll(pageable);
    }

    public List<MenuItem> getMenuItemByName(String name) {
        return menuItemRepository.findByName(name);
    }

    public MenuItem getMenuItemById(Long id) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        if (menuItem.isPresent()) {
            return menuItem.get();
        } else {
            throw new EntityNotFoundException("MenuItem not found with id: " + id);
        }
    }

    public List<MenuItem> getMenuItemsByPrice(double price) {
        return menuItemRepository.findByPrice(price);
    }

//    public List<MenuItem> getMenuItemsByCategory(Category category) {
//        return menuItemRepository.findByCategory(category);
//    }

    public List<MenuItem> getMenuItemsByCategoryName(String categoryName) {
        return menuItemRepository.findByCategoryName(categoryName);
    }
}
