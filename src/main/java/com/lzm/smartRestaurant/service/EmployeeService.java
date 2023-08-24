package com.lzm.smartRestaurant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzm.smartRestaurant.entity.Employee;

public interface EmployeeService extends IService<Employee> {
    public void remove(Long id);

}
