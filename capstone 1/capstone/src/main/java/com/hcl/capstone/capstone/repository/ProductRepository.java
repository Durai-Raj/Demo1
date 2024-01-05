package com.hcl.capstone.capstone.repository;

import com.hcl.capstone.capstone.dto.ProductDto;
import com.hcl.capstone.capstone.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("select NEW com.hcl.capstone.capstone.dto.ProductDto(p.id,p.name,p.price,p.discountedPrice,p.strDate) from ProductEntity p")
    public List<ProductDto> getProductData();

}
