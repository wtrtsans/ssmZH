package com.zynb.service;

import com.github.pagehelper.PageInfo;
import com.zynb.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> getlist();

    PageInfo<Product> getpage(int page, int limit);

    Product findById(Integer id);

    int update(Product product);

}
