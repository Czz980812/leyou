package com.leyou.item.service;

import com.leyou.item.entity.Category;

import java.util.List;

public interface CategoryService {

    //根据id查询
    public List<Category> queryListByParentId(Integer parentId);
}
