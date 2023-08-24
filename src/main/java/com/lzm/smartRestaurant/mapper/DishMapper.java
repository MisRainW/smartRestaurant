package com.lzm.smartRestaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzm.smartRestaurant.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
