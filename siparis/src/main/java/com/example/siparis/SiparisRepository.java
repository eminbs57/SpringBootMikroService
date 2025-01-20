package com.example.siparis;



import com.example.siparis.Siparis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiparisRepository extends JpaRepository<Siparis, Long> {
    // Siparişlerle ilgili özel sorgular burada tanımlanabilir
}
