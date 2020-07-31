package com.dao;

import com.domain.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface IDepartmentDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from department")
    @Results(id = "departmentMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "departmentName", property = "departmentName"),
    })
    List<Department> findAll();

    /**
     * 根据ID查询产品
     * @param departmentId
     * @return
     */
    @Select("select * from department where id = #{id}")
    @ResultMap("departmentMap")
    Department findDepartmentById(Integer departmentId);

    /**
     * 根据姓名查询产品
     * @param departmentName
     * @return
     */
    @Select("select * from department where departmentName = #{departmentName}")
    Department findDepartmentByName(String departmentName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param department
     */
    @Insert("insert into department(departmentName) values (#{departmentName})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveDepartment(Department department);

    /**
     * 删除产品数据
     * @param departmentId
     */
    @Delete("delete from department where id = #{id}")
    void deleteDepartment(Integer departmentId);

    /**
     * 更新产品数据
     * @param department
     */
    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    void updateDepartment(Department department);

    /**
     * 查找产品总数量
     * @return
     */
    @Select("select count(*) from department")
    int findTotalDepartment();
}
