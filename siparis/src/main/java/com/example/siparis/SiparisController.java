package com.example.siparis;



import com.example.siparis.Siparis;
import com.example.siparis.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class SiparisController {

    @Autowired
    private SiparisService siparisService;

    
    @GetMapping
    public List<Siparis> getAllOrders() {
        return siparisService.getAllOrders();
    }

    
    @GetMapping("/{id}")
    public Optional<Siparis> getOrderById(@PathVariable Long id) {
        return siparisService.getOrderById(id);
    }

    
    @PostMapping
    public Siparis createOrder(@RequestBody Siparis siparis) {
        return siparisService.createOrder(siparis);
    }

    
    @PutMapping("/{id}")
    public Siparis updateOrder(@PathVariable Long id, @RequestBody Siparis siparis) {
        return siparisService.updateOrder(id, siparis);
    }

    
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
    	siparisService.deleteOrder(id);
    }
}
