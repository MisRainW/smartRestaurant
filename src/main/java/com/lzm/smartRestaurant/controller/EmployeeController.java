package com.lzm.smartRestaurant.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzm.smartRestaurant.common.R;
import com.lzm.smartRestaurant.entity.Employee;
import com.lzm.smartRestaurant.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 管理员登录
     *
     * @param request
     * @param employee
     * @return
     */

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        //1、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());//等值查询 wrapper.eq(实体类::查询字段,条件值)
        Employee emp = employeeService.getOne(queryWrapper);//getOne方法

        //3、如果没有查询到则返回登录失败结果
        if (emp == null) {
            return R.error("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if (!emp.getPassword().equals(password)) {
            return R.error("登录失败");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果

        if (emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }

    /**
     * 员工退出
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清理Session中保存的当前员工的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    /**
     * 新增员工
     *
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee) {
        log.info("新增员工，员工信息：{}", employee.toString());

        //设置初始密码123456，需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employeeService.save(employee);

        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {},pageSize = {},name = {}", page, pageSize, name);

        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);//like模糊查询
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 根据id修改员工信息
     *
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Employee employee) {
        log.info(employee.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}", id);

        employeeService.updateById(employee);

        return R.success("员工信息修改成功");
    }

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id) {
        log.info("根据id查询员工信息...");
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return R.success(employee);
        }
        return R.error("没有查询到对应员工信息");
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        log.info("删除分类，id为：{}", id);
        employeeService.remove(id);

        return R.success("员工删除删除成功");
    }

}
