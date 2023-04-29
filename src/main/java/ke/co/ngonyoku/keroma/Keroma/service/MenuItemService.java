package ke.co.ngonyoku.keroma.Keroma.service;

import jakarta.persistence.EntityNotFoundException;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import ke.co.ngonyoku.keroma.Keroma.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

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
}
