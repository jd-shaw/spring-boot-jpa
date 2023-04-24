package com.shaw.springbootjpa.dao;

import com.shaw.springbootjpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author shaw
 * @date 2023/3/20
 */
@Repository(value = "sysUserRepository")
public interface SysUserRepository extends JpaRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {

    @Query(value = "from sys_user user where user.userName = ?1")
    SysUser findUserByUserName(String userName);

    @Modifying
    @Query(value = "update sys_user set user_name = ?2 where id = ?1")
    int updateUserById(String id, String userName);

    @Query(value = "select * from sys_user where user_code = :userCode", nativeQuery = true)
    SysUser findUserByUserCode(String userCode);
}


