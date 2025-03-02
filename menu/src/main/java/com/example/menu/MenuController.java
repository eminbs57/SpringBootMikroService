package com.example.menu;

/*import com.example.menu.model.MenuItem;
import com.example.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;*/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Tüm menü öğelerini getir
    @GetMapping
    public List<Menu> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    // ID'ye göre menü öğesi getir
    @GetMapping("/{id}")
    public Optional<Menu> getMenuItemById(@PathVariable Long id) {
        return menuService.getMenuItemById(id);
    }

    // Menü öğesinin fiyatını getir
    @GetMapping("/{id}/price")
    public Double getMenuItemPrice(@PathVariable Long id) {
        return menuService.getMenuItemPrice(id);
    }

    // Yeni menü öğesi ekle
    @PostMapping
    public Menu addMenuItem(@RequestBody Menu menuItem) {
        return menuService.addMenuItem(menuItem);
    }

    // Menüyü güncelle
    @PutMapping("/{id}")
    public Menu updateMenuItem(@PathVariable Long id, @RequestBody Menu menuItem) {
        return menuService.updateMenuItem(id, menuItem);
    }

    // Menüyü sil
    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
    }
}
