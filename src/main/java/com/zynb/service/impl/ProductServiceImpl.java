package com.zynb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zynb.domain.Product;
import com.zynb.mapper.ProductMapper;
import com.zynb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getlist() {
        return productMapper.selectByExample(null);
    }


    @Override
    public PageInfo<Product> getpage(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Product> products = productMapper.selectByExample(null);
        PageInfo<Product> pageInfo = new PageInfo<Product>(products);
        return pageInfo;
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }
}
