package com.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="BRAND", nullable=false)
	private String brand;
	
	@NotNull
	@Min(0)
	@Max(100000000)
	@Column(name="PRICE", nullable=false)
	private Double price;
	
	@NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEM_ITEM_TYPE", 
             joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "TYPE_ID") })
    private Set<ItemType> itemTypes = new HashSet<ItemType>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<ItemType> getItemTypes() {
		return itemTypes;
	}

	public void setItemTypes(Set<ItemType> itemTypes) {
		this.itemTypes = itemTypes;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Item))
            return false;
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
	@Override
    public String toString() {
        return "Item [id=" + id + ", Name=" + name + ", Brand="+brand+
        		", Price="+price+"]";
    }
	
	
}
