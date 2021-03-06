package com.cscp.userServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cscp.userServer.dao.entity.Role;
import com.cscp.userServer.dao.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户-角色 服务类
 * </p>
 *
 * @author ckz
 * @since 2019-11-02
 */
public interface IUserRoleService extends IService<UserRole> {

    List<Role> get(String userId);

    void delete(String userId, String roleId);

    void post(String userId, String roleId);
}
