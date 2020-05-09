package com.leyou.item.service.impl;

import com.leyou.common.exception.LyExeption;
import com.leyou.item.entity.Brand;
import com.leyou.item.entity.Category_brand;
import com.leyou.item.entity.PeopleKey;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryBrandMapper;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;
    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public Page<Brand> PageableBrand(Integer pageId, Integer pageSize,Boolean desc,String sortBy,String key) {
        //页面加载不排序
        Pageable pageable = PageRequest.of(pageId, pageSize);
        //判断
        if (sortBy != null) {
            //设置分页，默认为false为升序
            pageable = PageRequest.of(pageId, pageSize, Sort.by(Sort.Direction.ASC, sortBy));
            if (desc != null && desc) {
                //设置分页，success为true时为降序
                pageable = PageRequest.of(pageId, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
            }
        }
     /*
        //进行查询
       if(StringUtils.isNotBlank(key)){
           String s = key;
           char[] arr = s.toCharArray();
           char ch = arr[0];
            Page<Brand> brandPage = brandMapper.findAllByNameLikeOrLetter(pageable,"%"+key+"%",ch);
           return brandPage;
        }else{
          Page<Brand> brandPage = brandMapper.findAll(pageable);
        }*/

        //a===> 实体类
        //b===>  ????
        //c===>  表达式
        Page<Brand> brandPage = brandMapper.findAll((a, b, c) -> {
            //添加条件
            if (StringUtils.isNotBlank(key)) {
                String s = key;
                char[] arr = s.toCharArray();
                char ch = arr[0];
                Predicate letter = c.equal(a.get("letter"), ch);
                Predicate name = c.like(a.get("name"), "%" + key.trim() + "%");
                return c.or(letter, name);
            }
            return null;
        }, pageable);
        List<Brand> brandList = brandPage.getContent();
        if (CollectionUtils.isEmpty(brandList)){
            throw new LyExeption(HttpStatus.NOT_FOUND.value(),"查询结果集为空！");
        }
        return brandPage;
       }


    /**
     * 新增品牌
     * @param brand 新增的数据
     * @return
     */
    @Override
    public Boolean CreateBrand(Brand brand) {
        try {
            Brand brands = brandMapper.save(brand);
            List<Integer> categories = brand.getCids();
            for (Integer category : categories) {
                categoryBrandMapper.save(new Category_brand(new PeopleKey(category,brands.getId())));
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
