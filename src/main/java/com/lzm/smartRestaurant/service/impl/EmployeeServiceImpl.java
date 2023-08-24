package com.lzm.smartRestaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzm.smartRestaurant.entity.Employee;
import com.lzm.smartRestaurant.mapper.EmployeeMapper;
import com.lzm.smartRestaurant.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    /**
     * 根据id删除员工
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        employeeLambdaQueryWrapper.eq(Employee::getId, id);

        //正常删除分类
        super.removeById(id);
    }
}
