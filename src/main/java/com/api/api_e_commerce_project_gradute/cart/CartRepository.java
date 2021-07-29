package com.api.api_e_commerce_project_gradute.cart;

import com.api.api_e_commerce_project_gradute.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
