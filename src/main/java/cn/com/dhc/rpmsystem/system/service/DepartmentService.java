package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.system.entity.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 添加部门
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 查询所有的部门
     * @return
     */
    List<Department> findAllDepartment();

    /**
     * 根据部门名称查询(支持模糊查询)
     */
    List<Department> findDepartmentByName(String name);

    /**
     * 删除一个部门
     * @param id
     * @return
     */
    int deleteDepartment(int id);

    /**
     * 更新编辑
     * @return
     */
    int updateDepartment(Department department);

}
