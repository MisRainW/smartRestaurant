package com.lzm.smartRestaurant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzm.smartRestaurant.dto.DishDto;
import com.lzm.smartRestaurant.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    /**
     * 新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
     *
     * @param dishDto
     */
    public void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id查询菜品信息和对应的口味信息
     *
     * @param id
     * @return
     */
    public DishDto getByIdWithFlavor(Long id);

    /**
     * 更新菜品信息,同时更新对应的口味信息
     *
     * @param dishDto
     */
    public void updateWithFlavor(DishDto dishDto);

    /**
     * 删除菜品，同时需要删除菜品和口味的关系
     *
     * @param ids
     */
    public void removeWithFlavor(List<Long> ids);
}
