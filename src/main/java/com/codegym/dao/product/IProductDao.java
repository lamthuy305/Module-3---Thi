package com.codegym.dao.product;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Product;
import com.codegym.model.ProductView;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<ProductView> findAllByName(String q);
    List<ProductView> findAllProductView();
}
