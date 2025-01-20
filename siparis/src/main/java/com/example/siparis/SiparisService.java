package com.example.siparis;



import com.example.menu.MenuService;
import com.example.siparis.Siparis;
import com.example.siparis.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String menuServiceUrl = "http://localhost:8081/api/menu"; 

    public Siparis createOrder(Siparis siparis) {
        
    	
        Double menuItemPrice = getMenuItemPriceFromMenuService(siparis.getMenuId());
        siparis.setTotalPrice(menuItemPrice * siparis.getQuantity());
        return siparisRepository.save(siparis);
    }

    
    private Double getMenuItemPriceFromMenuService(Long menuId) {
        String url = menuServiceUrl + "/" + menuId + "/price";
        return restTemplate.getForObject(url, Double.class);
    }

    public List<Siparis> getAllOrders() {
        return siparisRepository.findAll();
    }

    public Optional<Siparis> getOrderById(Long id) {
        return siparisRepository.findById(id);
    }

    public Siparis updateOrder(Long id, Siparis siparis) {
        siparis.setId(id);
        Double menuItemPrice = getMenuItemPriceFromMenuService(siparis.getMenuId());
        siparis.setTotalPrice(menuItemPrice * siparis.getQuantity());
        return siparisRepository.save(siparis);
    }

    public void deleteOrder(Long id) {
        siparisRepository.deleteById(id);
    }
}

