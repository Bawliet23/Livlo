package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.ProductsOrder;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductsOrder extends JpaRepository<ProductsOrder,Long> {

}
