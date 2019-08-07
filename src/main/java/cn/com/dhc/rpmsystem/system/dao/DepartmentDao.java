package cn.com.dhc.rpmsystem.system.dao;

import cn.com.dhc.rpmsystem.system.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    /**
     * 添加部门
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 查询
     * @return
     */
    List<Department> findAllDepartment();


    /**
     *删除一个部门
     * @param id
     * @return
     */
    int deleteDepartment(int id);

}
