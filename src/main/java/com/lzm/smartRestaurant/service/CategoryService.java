package com.lzm.smartRestaurant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzm.smartRestaurant.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
