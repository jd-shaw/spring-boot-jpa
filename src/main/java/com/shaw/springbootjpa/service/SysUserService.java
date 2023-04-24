package com.shaw.springbootjpa.service;

import com.shaw.springbootjpa.entity.SysUser;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author shaw
 * @date 2023/3/20
 */
public interface SysUserService {

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    SysUser insertUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    SysUser updateUser(SysUser user);

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    SysUser selectUserById(String id);

    /**
     * 根据ID查找用户信息
     *
     * @param id
     * @return
     */
    Optional<SysUser> findById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 根据ID删除用户信息
     *
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据用户名称查询用户信息(使用jpql查询)
     *
     * @param userName
     * @return
     */
    SysUser findUserByUserName(String userName);

    /**
     * 根据用户编号查询用户信息(使用sql查询)
     *
     * @param userCode
     * @return
     */
    SysUser findUserByUserCode(String userCode);

    /**
     * 根据ID更新用户信息(使用jpql更新)
     *
     * @param id
     * @param userName
     * @return
     */
    int updateUserById(String id, String userName);

    /**
     * 使用Specification实现条件查询
     *
     * @param userName
     * @return
     */
    List<SysUser> selectUserBySpecification(String userName);

    /**
     * 多条件分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param userName
     * @return
     */
    Page<SysUser> selectPageUserBySpecification(int pageNum, int pageSize, String userName);
}
