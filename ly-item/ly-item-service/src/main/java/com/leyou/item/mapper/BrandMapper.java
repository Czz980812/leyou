package com.leyou.item.mapper;

import com.leyou.item.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface BrandMapper extends JpaRepository<Brand,Integer>, JpaSpecificationExecutor<Brand> {

      //分页
      public Page<Brand> findAllByNameLikeOrLetter(Pageable pageable,String Name,Character Letter);

}
