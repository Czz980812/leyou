package com.leyou.item.mapper;

import com.leyou.item.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryMapper extends JpaRepository<Category,Integer> {

    //根据字段查询
    public List<Category> findByParentId(Integer parentId);

}
