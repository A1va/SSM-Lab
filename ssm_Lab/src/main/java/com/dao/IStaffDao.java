package com.dao;

import com.domain.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IStaffDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from staff")
    @Results(id = "staffMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "staffName", property = "staffName"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "email", property = "email"),
            @Result(column = "salary", property = "salary"),
            @Result(column = "hireDate", property = "hireDate"),
            @Result(property = "department", column = "departmentId",
                    one = @One(select = "com.dao.IDepartmentDao.findDepartmentById", fetchType = FetchType.EAGER)),
            @Result(property = "position", column = "positionId",
                    one = @One(select = "com.dao.IPositionDao.findPositionById", fetchType = FetchType.EAGER))
    })
    List<Staff> findAll();

    /**
     * 根据ID查询产品
     * @param staffId
     * @return
     */
    @Select("select * from staff where id = #{id}")
    @ResultMap("staffMap")
    Staff findStaffById(Integer staffId);

    /**
     * 根据姓名查询产品
     * @param staffName
     * @return
     */
    @Select("select * from staff where staffName = #{staffName}")
    Staff findStaffByName(String staffName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param staff
     */
    @Insert("insert into staff(positionId, departmentId, staffName, sex, phoneNum, email, salary, hireDate) values (#{positionId}, #{departmentId}, #{staffName}, #{sex}, #{phoneNum}, #{email}, #{salary}, #{hireDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    void saveStaff(Staff staff);

    /**
     * 删除产品数据
     * @param staffId
     */
    @Delete("delete from staff where id = #{id}")
    void deleteStaff(Integer staffId);

    /**
     * 更新产品数据
     * @param staff
     */
    @Update("update staff set positionId = #{positionId}, departmentId = #{departmentId}, staffName = #{staffName}, sex = #{sex}, phoneNum = #{phoneNum}, email = #{email}, salary = #{salary}, hireDate = #{hireDate} where id = #{id}")
    void updateStaff(Staff staff);

    /**
     * 查找产品总数量
     * @return
     */
    @Select("select count(*) from staff")
    int findTotalStaff();
}
