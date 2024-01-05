package com.hcl.capstone.capstone.service;

import com.hcl.capstone.capstone.dto.ProductDto;

import java.util.List;

public interface CapstoneServiceMain {
    public void parseJson(String str);
    public List<ProductDto> getProductData();
}
