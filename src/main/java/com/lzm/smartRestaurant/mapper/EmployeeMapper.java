package com.lzm.smartRestaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzm.smartRestaurant.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
