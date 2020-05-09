package com.leyou.item.web;

import com.leyou.item.entity.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/page")
    public ResponseEntity<Page<Brand>> PageableBrand(@RequestParam(value = "page")Integer pageId,
                                     @RequestParam(value = "rows")Integer pageSize,
                                     @RequestParam(value = "desc")Boolean desc,
                                     @RequestParam(value = "sortBy")String sortBy,
                                     @RequestParam(value = "key")String key){
        Page<Brand> brandPage = brandService.PageableBrand(pageId-1,pageSize,desc,sortBy,key);
         return ResponseEntity.status(HttpStatus.OK).body(brandPage);
    }

    @PostMapping("")
    public Boolean addBrand(Brand brand){
        //打桩   测试数据
        System.out.println("brand = " + brand);
        //调用方法
        Boolean success = brandService.CreateBrand(brand);
        //是否添加成功
        return success;
    }
}
