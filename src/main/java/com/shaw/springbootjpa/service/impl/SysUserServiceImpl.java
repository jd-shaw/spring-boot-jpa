package com.shaw.springbootjpa.service.impl;

import com.shaw.springbootjpa.dao.SysUserRepository;
import com.shaw.springbootjpa.entity.SysUser;
import com.shaw.springbootjpa.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author shaw
 * @date 2023/3/20
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource(name = "sysUserRepository")
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser insertUser(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public SysUser updateUser(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public SysUser selectUserById(String id) {
        return sysUserRepository.getOne(id);
    }

    @Override
    public Optional<SysUser> findById(String id) {
        return sysUserRepository.findById(id);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        sysUserRepository.deleteById(id);
    }

    @Override
    public SysUser findUserByUserName(String userName) {
        return sysUserRepository.findUserByUserName(userName);
    }

    @Override
    public SysUser findUserByUserCode(String userCode) {
        return sysUserRepository.findUserByUserCode(userCode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserById(String id, String userName) {
        return sysUserRepository.updateUserById(id, userName);
    }

    @Override
    public List<SysUser> selectUserBySpecification(String userName) {
        Specification<SysUser> specification = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("userName").as(String.class), "%" + userName + "%");
            }
        };
        return sysUserRepository.findAll(specification);
    }

    @Override
    public Page<SysUser> selectPageUserBySpecification(int pageNum, int pageSize, String userName) {
        Specification<SysUser> specification = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (StringUtils.hasLength(userName)) {
                    predicateList.add(criteriaBuilder.like(root.get("userName").as(String.class), "%" + userName + "%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return sysUserRepository.findAll(specification, pageable);
    }
}

