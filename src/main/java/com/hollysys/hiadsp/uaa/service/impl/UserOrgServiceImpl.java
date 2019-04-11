package com.hollysys.hiadsp.uaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.org.Org;
import com.hollysys.hiadsp.common.model.org.OrgAttachUser;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserOrg;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.mapper.org.OrgMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserOrgMapper;
import com.hollysys.hiadsp.uaa.service.UserOrgService;

@Service("userOrgService")
public class UserOrgServiceImpl implements UserOrgService {
	private static Logger logger = LoggerFactory
			.getLogger(UserOrgServiceImpl.class);
	@Autowired
	private UserOrgMapper userOrgMapper;
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public String getOrgCodeByUserCode(String userCode) {
		String orgCode = "";
		UserOrg userOrg = userOrgMapper.selectByUserCode(userCode);
		if (userOrg != null) {
			orgCode = userOrg.getOrgCode();

		} else {
			logger.error("execute getOrgByUserCode error,could not find userOrg,userCode ="
					+ userCode);
		}
		return orgCode;
	}

	@Override
	public String getRootOrgCodeByUserCode(String userCode) {
		String rootOrgCode = "";
		UserOrg userOrg = userOrgMapper.selectByUserCode(userCode);
		if (userOrg != null) {
			String orgCode = userOrg.getOrgCode();
			Org org = orgMapper.getRootOrg(orgCode);
			if (org != null) {
				rootOrgCode = org.getCode();
			} else {
				logger.error("execute getOrgByUserCode error,could not find rootOrg,orgCode ="
						+ orgCode);
			}
		} else {
			logger.error("execute getOrgByUserCode error,could not find userOrg,userCode ="
					+ userCode);
		}
		return rootOrgCode;
	}

	@Override
	public int addUserOrg(UserOrg userOrg) {
		int result = -1;
		if (userOrg == null) {
			logger.error("execute addUserOrg error,userOrg can not be null");
			return result;
		}
		if (userOrg.getCode() == null || "".equals(userOrg.getCode())) {
			userOrg.setCode(CodeUtil.getLongCode());
		}
		result = userOrgMapper.insert(userOrg);
		if (result > 0) {
			logger.info("execute addUserOrg success,code=" + userOrg.getCode());
		} else {
			logger.error("execute addUserOrg error,addUserOrg to db error");
		}
		return result;
	}

	@Override
	public int delUserOrg(String code) {
		int result = -1;
		if (code == null || "".equals(code)) {
			logger.error("execute delUserOrg error,code can not be null");
		}
		result = userOrgMapper.deleteByPrimaryKey(code);
		if (result > 0) {
			logger.info("execute delUserOrg success,code=" + code);
		} else {
			logger.error("execute delUserOrg error,code=" + code);
		}
		return result;
	}

	@Override
	public int delUserOrgByUserCode(String userCode) {
		int result = -1;
		if (userCode == null || "".equals(userCode)) {
			logger.error("execute delUserOrgByUserCode error,userCode can not be null");
			return result;
		}
		result = userOrgMapper.deleteByUserCode(userCode);
		if (result > 0) {
			logger.info("execute delUserOrgByUserCode success,delNum=" + result
					+ ",userCode=" + userCode);
		} else {
			logger.error("execute delUserOrgByUserCode error,userCode="
					+ userCode);
		}
		return result;
	}

	@Override
	public int delUserOrgByOrgCode(String orgCode) {
		int result = -1;
		if (orgCode == null || "".equals(orgCode)) {
			logger.error("execute delUserOrgByOrgCode error,orgCode can not be null");
			return result;
		}
		result = userOrgMapper.deleteByOrgCode(orgCode);
		if (result > 0) {
			logger.info("execute delUserOrgByOrgCode success,delNum=" + result
					+ ",orgCode=" + orgCode);
		} else {
			logger.error("execute delUserOrgByOrgCode error,orgCode=" + orgCode);
		}
		return result;
	}

	@Override
	public Org getOrgByUserCode(String userCode) {
		if (userCode == null || "".equals(userCode)) {
			logger.error("execute getOrgByUserCode error,userCode can not be null");
			return null;
		}
		UserOrg userOrg = userOrgMapper.selectByUserCode(userCode);
		if (userOrg == null) {
			logger.error("execute getOrgByUserCode error,selectByUserCode is null,userCode="
					+ userCode);
			return null;
		}
		Org org = orgMapper.selectByPrimaryKey(userOrg.getCode());
		return org;
	}

	@Override
	public Org getRootOrgByUserCode(String userCode) {
		if (userCode == null || "".equals(userCode)) {
			logger.error("execute getRootOrgByUserCode error,userCode can not be null");
			return null;
		}
		UserOrg userOrg = userOrgMapper.selectByUserCode(userCode);
		if (userOrg == null) {
			logger.error("execute getRootOrgByUserCode error,selectByUserCode is null,userCode="
					+ userCode);
			return null;
		}
		Org org = orgMapper.getRootOrg(userOrg.getCode());
		return org;
	}

	@Override
	public List<User> getUserListByOrgCode(String orgCode) {
		List<User> userList = new ArrayList<User>();
		if (orgCode == null || "".equals(orgCode)) {
			logger.error("execute getUserListByOrgCode error,orgCode can not be null");
			return userList;
		}
		List<UserOrg> userOrgList = userOrgMapper.selectByOrgCode(orgCode);
		if (userOrgList != null && userOrgList.size() > 0) {
			List<String> userCodeList = new ArrayList<String>();
			for (UserOrg userOrg : userOrgList) {
				userCodeList.add(userOrg.getUserCode());
			}
			// 根据用户code列表获取用户信息列表
			userMapper.selectByUserCodeList(userCodeList);
		} else {
			logger.warn("execute getUserListByOrgCode warn,userOrgList is empty,orgCode="
					+ orgCode);
		}
		return userList;
	}

	@Override
	public List<User> getUserListByRootOrgCode(String rootOrgCode) {
		List<User> userList = new ArrayList<User>();
		if (rootOrgCode == null || "".equals(rootOrgCode)) {
			logger.error("execute getUserListByRootOrgCode error,rootOrgCode can not be null");
			return userList;
		}
		List<Org> orgList = orgMapper.selectByRoot(rootOrgCode);
		if (orgList == null || orgList.size() == 0) {
			logger.error("execute getUserListByRootOrgCode error,selectByRoot get null by rootOrgCode，rootOrgCode="
					+ rootOrgCode);
			return userList;
		}
		List<String> orgCodeList = new ArrayList<String>();
		for (Org org : orgList) {
			orgCodeList.add(org.getCode());
		}
		List<UserOrg> userOrgList = userOrgMapper
				.selectByOrgCodeList(orgCodeList);
		if (userOrgList != null && userOrgList.size() > 0) {
			List<String> userCodeList = new ArrayList<String>();
			for (UserOrg userOrg : userOrgList) {
				userCodeList.add(userOrg.getUserCode());
			}
			// 根据用户code列表获取用户信息列表
			userMapper.selectByUserCodeList(userCodeList);
		} else {
			logger.warn("execute getUserListByRootOrgCode warn,selectByOrgCodeList get null by orgCodeList,orgCodeList="
					+ orgCodeList.toString());
		}
		return userList;
	}

	@Override
	public List<String> getUserCodeListByOrgCode(String orgCode) {
		List<String> userCodeList = new ArrayList<String>();
		if (orgCode == null || "".equals(orgCode)) {
			logger.error("execute getUserCodeListByOrgCode error,orgCode can not be null");
			return userCodeList;
		}
		List<UserOrg> userOrgList = userOrgMapper.selectByOrgCode(orgCode);
		if (userOrgList != null && userOrgList.size() > 0) {
			for (UserOrg userOrg : userOrgList) {
				userCodeList.add(userOrg.getUserCode());
			}
		} else {
			logger.warn("execute getUserCodeListByRootOrgCode warn,userOrgList is empty,orgCode="
					+ orgCode);
		}
		return userCodeList;
	}

	@Override
	public List<String> getUserCodeListByRootOrgCode(String rootOrgCode) {
		List<String> userCodeList = new ArrayList<String>();
		if (rootOrgCode == null || "".equals(rootOrgCode)) {
			logger.error("execute getUserCodeListByRootOrgCode error,rootOrgCode can not be null");
			return userCodeList;
		}
		List<Org> orgList = orgMapper.selectByRoot(rootOrgCode);
		if (orgList == null || orgList.size() == 0) {
			logger.error("execute getUserCodeListByRootOrgCode error,rootOrgCode can not be null");
			return userCodeList;
		}
		List<String> orgCodeList = new ArrayList<String>();
		for (Org org : orgList) {
			orgCodeList.add(org.getCode());
		}
		List<UserOrg> userOrgList = userOrgMapper
				.selectByOrgCodeList(orgCodeList);
		if (userOrgList != null && userOrgList.size() > 0) {
			for (UserOrg userOrg : userOrgList) {
				userCodeList.add(userOrg.getUserCode());
			}
		} else {
			logger.warn("execute getUserCodeListByRootOrgCode warn,userOrgList is empty,orgCodeList="
					+ orgCodeList.toString());
		}
		return userCodeList;
	}

	/**
	 * 获取用户组织架构
	 */
	@Override
	public List<OrgAttachUser> getOrgAttachUserList(String userCode) {
		List<OrgAttachUser> orgAttachUserList = new ArrayList<OrgAttachUser>();
		if (userCode == null || "".equals(userCode)) {
			logger.error("execute getOrgAttachUserList error,userCode can not be null");
			return orgAttachUserList;
		}
		String rootOrgCode = this.getRootOrgCodeByUserCode(userCode);
		if (rootOrgCode == null || "".equals(rootOrgCode)) {
			logger.error("execute getOrgAttachUserList error,getRootOrgCodeByUserCode is null,userCode="
					+ userCode);
			return orgAttachUserList;
		}
		List<Org> orgList = orgMapper.selectByRoot(rootOrgCode);
		if (orgList == null || orgList.size() == 0) {
			logger.error("execute getOrgAttachUserList error,orgMapper.selectByRoot is null,rootOrgCode="
					+ rootOrgCode);
			return orgAttachUserList;
		}
		for (Org org : orgList) {
			OrgAttachUser orgAttachUser = new OrgAttachUser();
			orgAttachUser.setCode(org.getCode());
			orgAttachUser.setName(org.getName());
			orgAttachUser.setParentCode(org.getParentCode());
			orgAttachUser.setManagerCode(org.getManagerCode());
			if (org.getManagerCode() != null
					&& !"".equals(org.getManagerCode())) {
				User user = userMapper.get(org.getManagerCode());
				if (user != null) {
					orgAttachUser.setManagerName(user.getName());
				}
			}
			orgAttachUserList.add(orgAttachUser);
		}
		return orgAttachUserList;
	}

}
