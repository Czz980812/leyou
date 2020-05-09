package com.leyou.item.mapper;

import com.leyou.item.entity.Category_brand;
import com.leyou.item.entity.PeopleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryBrandMapper extends JpaRepository<Category_brand, PeopleKey>, JpaSpecificationExecutor<Category_brand> {
}
