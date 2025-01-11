package org.kit.spring_ecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private Boolean productAvailable;
    private int stockQuantity;

    // FOR IMAGE HANDLING
    private String imageName;
    private String imageType;
    @Lob // Large Object
    // @Basic(fetch = FetchType.LAZY)
    @Basic(fetch = FetchType.EAGER)
    private byte[] imageData;
}
