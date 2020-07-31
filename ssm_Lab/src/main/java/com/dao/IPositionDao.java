package com.dao;

import com.domain.Position;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("positionDao")
//@CacheNamespace(blocking = true)// mybatis 基于注解方式实现配置二级缓存
public interface IPositionDao {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from position")
    @Results(id = "positionMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "positionName", property = "positionName"),
    })
    List<Position> findAll();

    /**
     * 根据ID查询产品
     * @param positionId
     * @return
     */
    @Select("select * from position where id = #{id}")
    @ResultMap("positionMap")
    Position findPositionById(Integer positionId);

    /**
     * 根据姓名查询产品
     * @param positionName
     * @return
     */
    @Select("select * from position where positionName = #{positionName}")
    Position findPositionByName(String positionName);

    /**
     * 插入产品数据
     * @SelectKety: 确定插入数据的主键
     * @param position
     */
//    @Insert("insert into position(positionName) values (#{positionName})")
//    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
//    void savePosition(Position position);
}
