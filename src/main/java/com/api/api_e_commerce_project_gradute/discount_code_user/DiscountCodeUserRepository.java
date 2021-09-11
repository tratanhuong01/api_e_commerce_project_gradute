package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCodeUserRepository extends JpaRepository<DiscountCodeUser,Long> {
}
