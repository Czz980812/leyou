package com.leyou.item.service;

import com.leyou.item.entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {

    //分页查询
    public Page<Brand> PageableBrand(Integer pageId,Integer pageSize,Boolean desc,String sortBy,String key);

    //新增品牌
    public Boolean CreateBrand(Brand brand);

}
