package it.gm.springboot.dao;

import it.gm.springboot.pojo.User;
import org.apache.ibatis.annotations.*;


import java.util.List;


public interface UserDao {

    @Insert("insert into tb_user(username,password) values(#{username},#{password})")
    int addUser(User user);


    @Delete("delete from tb_user where id=#{id}")
    int delUser(int id);

    @Update("update tb_user set username=#{username},password=#{password} where id=#{id}")
    int updUser(User user);

    @Select("select * from tb_user")
    List<User> findUserAll();

}
