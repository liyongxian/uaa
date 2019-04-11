package com.hollysys.hiadsp.uaa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.permission.dto.MenuDto;
import com.hollysys.hiadsp.common.model.permission.dto.OrgPermissionDto;
import com.hollysys.hiadsp.common.model.permission.dto.RoleDto;
import com.hollysys.hiadsp.uaa.mapper.permission.PermissionMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserRoleMapper;
import com.hollysys.hiadsp.uaa.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<Permission> getAllPermissionList() {
		return permissionMapper.getAllPermission();
	}

	@Override
	public List<Permission> getPermissionList(String appType, String resType,
			String resSubType) {
		return permissionMapper.getPermissionList(appType, resType, resSubType);
	}

	@Override
	public Permission getPermission(String id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Permission> getChildren(String parentId) {
		return permissionMapper.getChildren(parentId);
	}

	@Override
	public int addPermission(Permission permission) {
		int num = permissionMapper.insert(permission);
		if (num > 0) {
			permissionMapper.updateLeafState(permission.getParentCode(), "0");// 更新父节点为非叶子节点
		}
		return num;
	}

	@Override
	public int editPermission(Permission permission) {
		return permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public int delPermission(String id) {
		return this.delTreePermission(id);
	}

	@Override
	public List<Permission> getPermissionsByRoleCode(String roleCode) {
		return null;
	}

	@Override
	public List<Permission> getPermissionsByLoginName(String loginName) {
		return null;
	}

	@Override
	public int updateLeafState(String id, String isLeaf) {
		return permissionMapper.updateLeafState(id, isLeaf);
	}

	private int delTreePermission(String id) {
		int num = permissionMapper.deleteByPrimaryKey(id);
		List<Permission> childrenList = permissionMapper.getChildren(id);
		if (childrenList != null && childrenList.size() > 0) {
			for (Permission child : childrenList) {
				if (child != null) {
					this.delTreePermission(child.getCode());
				}
			}
		}
		return num;
	}

	@Override
	public List<OrgPermissionDto> getUerPermissions(String userCode,
			boolean needInteraface) {
		return null;
	}

	public List<RoleDto> getUserPermission(String enterpriseCode,
			String userCode, boolean needInterface) {
		return null;
	}

	/**
	 * 运营账户超级账户获取所有菜单
	 * 
	 * @return
	 */
	public List<MenuDto> getAllMenus() {
		return null;
	}

}
