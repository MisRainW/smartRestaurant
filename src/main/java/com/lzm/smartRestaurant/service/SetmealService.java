package com.lzm.smartRestaurant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzm.smartRestaurant.dto.SetmealDto;
import com.lzm.smartRestaurant.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关系
     *
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关系
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

    /**
     * 根据id查询套餐信息对应的菜品信息
     * @param id
     * @return
     */
    public SetmealDto getByIdWithDish(Long id);

    /**
     * 修改套餐，同时需要修改套餐和菜品的关系
     * @param setmealDto
     */
    public void updateWithDish(SetmealDto setmealDto);

}
