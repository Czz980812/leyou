package com.leyou.item.service.impl;

import com.leyou.item.entity.Category;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 查询
     * @param parentId
     * @return
     */
    @Override
    public List<Category> queryListByParentId(Integer parentId) {
        List<Category> categoryList = categoryMapper.findByParentId(parentId);
        return categoryList;
    }
}
