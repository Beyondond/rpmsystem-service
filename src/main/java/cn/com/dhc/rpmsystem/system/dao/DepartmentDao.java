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
     * @param searchStr
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
     *删除一个部门
     * @param id
     * @return
     */
    int deleteDepartment(int id);

    /**
     * 编辑更新
     * @param department
     * @return
     */
    int updateDepartment(Department department);
}
