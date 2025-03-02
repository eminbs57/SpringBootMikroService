package com.example.menu;

/*import com.example.menu.model.MenuItem;
import com.example.menu.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;*/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuItemById(Long id) {
        return menuRepository.findById(id);
    }

    public Double getMenuItemPrice(Long id) {
        // Menü öğesinin fiyatını döndür
        return menuRepository.findById(id)
                .map(Menu::getPrice) // Menü öğesinin fiyatını çek
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    public Menu addMenuItem(Menu menuItem) {
        return menuRepository.save(menuItem);
    }

    public Menu updateMenuItem(Long id, Menu menuItem) {
        menuItem.setId(id);
        return menuRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }
}

