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
     *根据条件查询
     * @return
     */
    List<Department> findDepartments(String searchStr);

    /**
     * 查询总数
     * @param searchStr
     * @return
     */
    int getTotalCount(String searchStr);

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
