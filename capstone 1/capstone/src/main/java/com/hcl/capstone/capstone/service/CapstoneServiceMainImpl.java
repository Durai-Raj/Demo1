package com.hcl.capstone.capstone.service;

import com.hcl.capstone.capstone.dto.ProductDto;
import com.hcl.capstone.capstone.entity.Laptop;
import com.hcl.capstone.capstone.entity.ProductEntity;
import com.hcl.capstone.capstone.entity.SmartPhones;
import com.hcl.capstone.capstone.entity.SmartWatch;
import com.hcl.capstone.capstone.repository.ProductRepository;
import capstoneservice.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class CapstoneServiceMainImpl implements CapstoneServiceMain {

    @Autowired
    ProductRepository productRepository;


    @Override
    public void parseJson(String input) {
        JSONObject jsnobject = new JSONObject(input);
        JSONArray jsonArray = jsnobject.getJSONArray("Product");

        List<ProductEntity> lstProductEntity = new ArrayList<>();
        int length = jsonArray.length();

        //loop to get all json objects from data json array
        for (int i = 0; i < length; i++) {
            JSONObject jObj = jsonArray.getJSONObject(i);


           // getting inner array Ingredients


            JSONObject json = (JSONObject) jObj.get("Laptop");
            ProductEntity objLaptop = new Laptop();
            objLaptop.setId(json.getInt("id"));
            objLaptop.setName(json.getString("name"));
            objLaptop.setPrice(json.getDouble("price"));
            objLaptop.setStrDate(json.getString("strdate"));
            lstProductEntity.add(objLaptop);


            json = (JSONObject) jObj.get("SmartPhones");
            ProductEntity objSmartPhone = new SmartPhones();
            objSmartPhone.setId(json.getInt("id"));
            objSmartPhone.setName(json.getString("name"));
            objSmartPhone.setPrice(json.getDouble("price"));
            objSmartPhone.setStrDate(json.getString("strdate"));
            lstProductEntity.add(objSmartPhone);

            json = (JSONObject) jObj.get("SmartWatch");
            ProductEntity objSmartWatch = new SmartWatch();
            objSmartWatch.setId(json.getInt("id"));
            objSmartWatch.setName(json.getString("name"));
            objSmartWatch.setPrice(json.getDouble("price"));
            objSmartWatch.setStrDate(json.getString("strdate"));
            lstProductEntity.add(objSmartWatch);

        }
        ArrayList<ProductEntity> arrayListProductEntity = applyDiscount(lstProductEntity);
        productRepository.saveAll(arrayListProductEntity);
    }

    @Override
    public List<ProductDto> getProductData() {
        return productRepository.getProductData();
    }




    public  ArrayList<ProductEntity> applyDiscount(List<ProductEntity> productEntities){
        int len = productEntities.size();
        ArrayList<ProductEntity> lstProductEntities = new ArrayList<>();
        for(int i=0;i<len;i++){
            ProductEntity objProductEntity = productEntities.get(i);
            double price = objProductEntity.getPrice();
            String strDateFromJson = objProductEntity.getStrDate();
            String name = objProductEntity.getClass().getSimpleName();
            CapstoneServiceInterface capstoneServiceInterface = new CapstoneServiceImpl();
           //CapstoneServiceInterface capstoneServiceInterface =  ServiceLoader.load(CapstoneServiceInterface.class).iterator().next();
            double discount = capstoneServiceInterface.calculateDiscount(price,strDateFromJson,name);
            objProductEntity.setDiscountedPrice(price - discount);
            lstProductEntities.add(objProductEntity);
        }
        return lstProductEntities;
    }




}
