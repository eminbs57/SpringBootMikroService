package com.example.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Menu {
     
	public Menu() {
	    // Default constructor
	}

	public Menu(String name, String description, Double price) {
	    this.name = name;
	    this.description = description;
	    this.price = price;
	}

	
	@Override
	public String toString() {
	    return "Menu{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", description='" + description + '\'' +
	            ", price=" + price +
	            '}';
	}

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
