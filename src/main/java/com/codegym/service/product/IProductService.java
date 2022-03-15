package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.model.ProductView;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<ProductView> findAllByName(String q);
    List<ProductView> findAllProductView();


}
