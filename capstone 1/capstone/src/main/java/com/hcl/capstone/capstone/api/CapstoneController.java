package com.hcl.capstone.capstone.api;


import com.hcl.capstone.capstone.dto.ProductDto;
import com.hcl.capstone.capstone.service.CapstoneServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CapstoneController {
    @Autowired
    CapstoneServiceMain capstoneService;
    @PostMapping("/productData")
    public void setProductData(@RequestBody String data){
       capstoneService.parseJson(data);
    }
    @GetMapping("/getProductData")
    public ResponseEntity<List<ProductDto>> getProductData(){
        return new ResponseEntity<>(capstoneService.getProductData(), HttpStatus.OK);
    }
}
