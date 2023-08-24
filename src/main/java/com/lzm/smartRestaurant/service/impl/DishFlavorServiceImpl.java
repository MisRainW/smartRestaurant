package com.lzm.smartRestaurant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzm.smartRestaurant.entity.DishFlavor;
import com.lzm.smartRestaurant.mapper.DishFlavorMapper;
import com.lzm.smartRestaurant.mapper.DishMapper;
import com.lzm.smartRestaurant.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
