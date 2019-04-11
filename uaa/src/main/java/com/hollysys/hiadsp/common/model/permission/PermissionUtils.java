package com.hollysys.hiadsp.common.model.permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {

    public static MenuInfo perm2Menu(Permission permission) {
	MenuInfo menuInfo = new MenuInfo();
	if (permission != null) {
	    menuInfo.setCode(permission.getCode());
	    menuInfo.setName(permission.getName());
	    menuInfo.setEname(permission.getEname());
	    menuInfo.setParentCode(permission.getParentCode());
	    menuInfo.setParentName(permission.getParentName());
	    menuInfo.setAppType(permission.getAppType());
	    menuInfo.setIcon(permission.getResource());
	    menuInfo.setIsLeaf(permission.getIsLeaf());
	    menuInfo.setIsshow(permission.getState());
	    menuInfo.setLevel(permission.getLevel());
	    menuInfo.setPermValue(permission.getPermValue());
	    menuInfo.setRouteState(permission.getResUri());
	    menuInfo.setDescription(permission.getDescription());
	    menuInfo.setOrderNo(permission.getOrderNo());
	    menuInfo.setUpdator(permission.getUpdator());
	    menuInfo.setUpdateTime(permission.getUpdateTime());
	    menuInfo.setCreator(permission.getCreator());
	    menuInfo.setCreateTime(permission.getCreateTime());
	}
	return menuInfo;
    }

    public static List<MenuInfo> permList2MenuList(List<Permission> permissionList) {
	List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
	if (permissionList != null && permissionList.size() > 0) {
	    for (Permission permission : permissionList) {
		MenuInfo menuInfo = new MenuInfo();
		menuInfo.setCode(permission.getCode());
		menuInfo.setName(permission.getName());
		menuInfo.setEname(permission.getEname());
		menuInfo.setParentCode(permission.getParentCode());
		menuInfo.setParentName(permission.getParentName());
		menuInfo.setAppType(permission.getAppType());
		menuInfo.setIcon(permission.getResource());
		menuInfo.setIsLeaf(permission.getIsLeaf());
		menuInfo.setIsshow(permission.getState());
		menuInfo.setLevel(permission.getLevel());
		menuInfo.setPermValue(permission.getPermValue());
		menuInfo.setRouteState(permission.getResUri());
		menuInfo.setDescription(permission.getDescription());
		menuInfo.setOrderNo(permission.getOrderNo());
		menuInfo.setUpdator(permission.getUpdator());
		menuInfo.setUpdateTime(permission.getUpdateTime());
		menuInfo.setCreator(permission.getCreator());
		menuInfo.setCreateTime(permission.getCreateTime());
		menuInfoList.add(menuInfo);
	    }
	}
	return menuInfoList;
    }

    public static Permission menu2Perm(MenuInfo menuInfo) {
	Permission permission = new Permission();
	if (menuInfo != null) {
	    permission.setCode(menuInfo.getCode());
	    permission.setName(menuInfo.getName());
	    permission.setEname(menuInfo.getEname());
	    permission.setParentCode(menuInfo.getParentCode());
	    permission.setParentName(menuInfo.getParentName());
	    permission.setAppType(menuInfo.getAppType());
	    permission.setResType(Permission.RES_TYPE_MENU);
	    permission.setResSubType("");
	    permission.setResUri(menuInfo.getRouteState());
	    permission.setResource(menuInfo.getIcon());
	    permission.setState(menuInfo.getIsshow());
	    permission.setOrderNo(menuInfo.getOrderNo());
	    permission.setPermValue(menuInfo.getPermValue());
	    permission.setLevel(menuInfo.getLevel());
	    permission.setIsLeaf(menuInfo.getIsLeaf());
	    permission.setDescription(menuInfo.getDescription());
	    permission.setCreateTime(menuInfo.getCreateTime());
	    permission.setCreator(menuInfo.getCreator());
	    permission.setUpdator(menuInfo.getUpdator());
	    permission.setUpdateTime(menuInfo.getUpdateTime());

	}
	return permission;
    }

    public static List<Permission> menuList2PermList(List<MenuInfo> menuInfoList) {
	List<Permission> permissionList = new ArrayList<Permission>();
	if (menuInfoList != null && menuInfoList.size() > 0) {
	    for (MenuInfo menuInfo : menuInfoList) {
		if (menuInfo != null) {
		    Permission permission = new Permission();
		    permission.setCode(menuInfo.getCode());
		    permission.setName(menuInfo.getName());
		    permission.setEname(menuInfo.getEname());
		    permission.setParentCode(menuInfo.getParentCode());
		    permission.setParentName(menuInfo.getParentName());
		    permission.setAppType(menuInfo.getAppType());
		    permission.setResType(Permission.RES_TYPE_MENU);
		    permission.setResSubType("");
		    permission.setResUri(menuInfo.getRouteState());
		    permission.setResource(menuInfo.getIcon());
		    permission.setState(menuInfo.getIsshow());
		    permission.setOrderNo(menuInfo.getOrderNo());
		    permission.setPermValue(menuInfo.getPermValue());
		    permission.setLevel(menuInfo.getLevel());
		    permission.setIsLeaf(menuInfo.getIsLeaf());
		    permission.setDescription(menuInfo.getDescription());
		    permission.setCreateTime(menuInfo.getCreateTime());
		    permission.setCreator(menuInfo.getCreator());
		    permission.setUpdator(menuInfo.getUpdator());
		    permission.setUpdateTime(menuInfo.getUpdateTime());
		    permissionList.add(permission);
		}
	    }
	}
	return permissionList;
    }

    public static ElementInfo perm2Element(Permission permission) {
	ElementInfo elementInfo = new ElementInfo();
	if (permission != null) {
	    elementInfo.setCode(permission.getCode());
	    elementInfo.setName(permission.getName());
	    elementInfo.setEname(permission.getEname());
	    elementInfo.setParentCode(permission.getParentCode());
	    elementInfo.setParentName(permission.getParentName());
	    elementInfo.setAppType(permission.getAppType());
	    elementInfo.setResSubType(permission.getResSubType());
	    elementInfo.setIsLeaf(permission.getIsLeaf());
	    elementInfo.setState(permission.getState());
	    elementInfo.setLevel(permission.getLevel());
	    elementInfo.setPermValue(permission.getPermValue());
	    elementInfo.setDescription(permission.getDescription());
	    elementInfo.setOrderNo(permission.getOrderNo());
	    elementInfo.setUpdator(permission.getUpdator());
	    elementInfo.setUpdateTime(permission.getUpdateTime());
	    elementInfo.setCreator(permission.getCreator());
	    elementInfo.setCreateTime(permission.getCreateTime());
	}
	return elementInfo;
    }

    public static List<ElementInfo> permList2ElementList(List<Permission> permissionList) {
	List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
	if (permissionList != null && permissionList.size() > 0) {
	    for (Permission permission : permissionList) {
		ElementInfo elementInfo = new ElementInfo();
		elementInfo.setCode(permission.getCode());
		elementInfo.setName(permission.getName());
		elementInfo.setEname(permission.getEname());
		elementInfo.setParentCode(permission.getParentCode());
		elementInfo.setParentName(permission.getParentName());
		elementInfo.setAppType(permission.getAppType());
		elementInfo.setResSubType(permission.getResSubType());
		elementInfo.setIsLeaf(permission.getIsLeaf());
		elementInfo.setState(permission.getState());
		elementInfo.setLevel(permission.getLevel());
		elementInfo.setPermValue(permission.getPermValue());
		elementInfo.setDescription(permission.getDescription());
		elementInfo.setOrderNo(permission.getOrderNo());
		elementInfo.setUpdator(permission.getUpdator());
		elementInfo.setUpdateTime(permission.getUpdateTime());
		elementInfo.setCreator(permission.getCreator());
		elementInfo.setCreateTime(permission.getCreateTime());
		elementInfoList.add(elementInfo);
	    }
	}
	return elementInfoList;
    }

    public static Permission element2Perm(ElementInfo elementInfo) {
	Permission permission = new Permission();
	if (elementInfo != null) {
	    permission.setCode(elementInfo.getCode());
	    permission.setName(elementInfo.getName());
	    permission.setEname(elementInfo.getEname());
	    permission.setParentCode(elementInfo.getParentCode());
	    permission.setParentName(elementInfo.getParentName());
	    permission.setAppType(elementInfo.getAppType());
	    permission.setResType(Permission.RES_TYPE_ELEMENT);
	    permission.setResSubType(elementInfo.getResSubType());
	    permission.setResUri("");
	    permission.setState(elementInfo.getState());
	    permission.setOrderNo(elementInfo.getOrderNo());
	    permission.setPermValue(elementInfo.getPermValue());
	    permission.setLevel(elementInfo.getLevel());
	    permission.setIsLeaf(elementInfo.getIsLeaf());
	    permission.setDescription(elementInfo.getDescription());
	    permission.setCreateTime(elementInfo.getCreateTime());
	    permission.setCreator(elementInfo.getCreator());
	    permission.setUpdator(elementInfo.getUpdator());
	    permission.setUpdateTime(elementInfo.getUpdateTime());

	}
	return permission;
    }

    public static List<Permission> elementList2PermList(List<ElementInfo> elementInfoList) {
	List<Permission> permissionList = new ArrayList<Permission>();
	if (elementInfoList != null && elementInfoList.size() > 0) {
	    for (ElementInfo elementInfo : elementInfoList) {
		if (elementInfo != null) {
		    Permission permission = new Permission();
		    permission.setCode(elementInfo.getCode());
		    permission.setName(elementInfo.getName());
		    permission.setEname(elementInfo.getEname());
		    permission.setParentCode(elementInfo.getParentCode());
		    permission.setParentName(elementInfo.getParentName());
		    permission.setAppType(elementInfo.getAppType());
		    permission.setResType(Permission.RES_TYPE_ELEMENT);
		    permission.setResSubType(elementInfo.getResSubType());
		    permission.setResUri("");
		    permission.setState(elementInfo.getState());
		    permission.setOrderNo(elementInfo.getOrderNo());
		    permission.setPermValue(elementInfo.getPermValue());
		    permission.setLevel(elementInfo.getLevel());
		    permission.setIsLeaf(elementInfo.getIsLeaf());
		    permission.setDescription(elementInfo.getDescription());
		    permission.setCreateTime(elementInfo.getCreateTime());
		    permission.setCreator(elementInfo.getCreator());
		    permission.setUpdator(elementInfo.getUpdator());
		    permission.setUpdateTime(elementInfo.getUpdateTime());
		    permissionList.add(permission);
		}
	    }
	}
	return permissionList;
    }

    public static InterfaceInfo perm2Interface(Permission permission) {
	InterfaceInfo interfaceInfo = new InterfaceInfo();
	if (permission != null) {
	    interfaceInfo.setCode(permission.getCode());
	    interfaceInfo.setName(permission.getName());
	    interfaceInfo.setEname(permission.getEname());
	    interfaceInfo.setParentCode(permission.getParentCode());
	    interfaceInfo.setParentName(permission.getParentName());
	    interfaceInfo.setAppType(permission.getAppType());
	    interfaceInfo.setNeedCheck(permission.getResSubType());
	    interfaceInfo.setResUri(permission.getResUri());
	    interfaceInfo.setIsLeaf(permission.getIsLeaf());
	    interfaceInfo.setState(permission.getState());
	    interfaceInfo.setLevel(permission.getLevel());
	    interfaceInfo.setPermValue(permission.getPermValue());
	    interfaceInfo.setDescription(permission.getDescription());
	    interfaceInfo.setOrderNo(permission.getOrderNo());
	    interfaceInfo.setUpdator(permission.getUpdator());
	    interfaceInfo.setUpdateTime(permission.getUpdateTime());
	    interfaceInfo.setCreator(permission.getCreator());
	    interfaceInfo.setCreateTime(permission.getCreateTime());
	}
	return interfaceInfo;
    }

    public static List<InterfaceInfo> permList2InterfaceList(List<Permission> permissionList) {
	List<InterfaceInfo> interfaceInfoList = new ArrayList<InterfaceInfo>();
	if (permissionList != null && permissionList.size() > 0) {
	    for (Permission permission : permissionList) {
		InterfaceInfo interfaceInfo = new InterfaceInfo();
		interfaceInfo.setCode(permission.getCode());
		interfaceInfo.setName(permission.getName());
		interfaceInfo.setEname(permission.getEname());
		interfaceInfo.setParentCode(permission.getParentCode());
		interfaceInfo.setParentName(permission.getParentName());
		interfaceInfo.setAppType(permission.getAppType());
		interfaceInfo.setNeedCheck(permission.getResSubType());
		interfaceInfo.setResUri(permission.getResUri());
		interfaceInfo.setIsLeaf(permission.getIsLeaf());
		interfaceInfo.setState(permission.getState());
		interfaceInfo.setLevel(permission.getLevel());
		interfaceInfo.setPermValue(permission.getPermValue());
		interfaceInfo.setDescription(permission.getDescription());
		interfaceInfo.setOrderNo(permission.getOrderNo());
		interfaceInfo.setUpdator(permission.getUpdator());
		interfaceInfo.setUpdateTime(permission.getUpdateTime());
		interfaceInfo.setCreator(permission.getCreator());
		interfaceInfo.setCreateTime(permission.getCreateTime());
		interfaceInfoList.add(interfaceInfo);
	    }
	}
	return interfaceInfoList;
    }

    public static Permission interface2Perm(InterfaceInfo interfaceInfo) {
	Permission permission = new Permission();
	if (interfaceInfo != null) {
	    permission.setCode(interfaceInfo.getCode());
	    permission.setName(interfaceInfo.getName());
	    permission.setEname(interfaceInfo.getEname());
	    permission.setParentCode(interfaceInfo.getParentCode());
	    permission.setParentName(interfaceInfo.getParentName());
	    permission.setAppType(interfaceInfo.getAppType());
	    permission.setResType(Permission.RES_TYPE_INTERFACE);
	    permission.setResSubType(interfaceInfo.getNeedCheck());
	    permission.setResUri(interfaceInfo.getResUri());
	    permission.setState(interfaceInfo.getState());
	    permission.setOrderNo(interfaceInfo.getOrderNo());
	    permission.setPermValue(interfaceInfo.getPermValue());
	    permission.setLevel(interfaceInfo.getLevel());
	    permission.setIsLeaf(interfaceInfo.getIsLeaf());
	    permission.setDescription(interfaceInfo.getDescription());
	    permission.setCreateTime(interfaceInfo.getCreateTime());
	    permission.setCreator(interfaceInfo.getCreator());
	    permission.setUpdator(interfaceInfo.getUpdator());
	    permission.setUpdateTime(interfaceInfo.getUpdateTime());

	}
	return permission;
    }

    public static List<Permission> interfaceList2PermList(List<InterfaceInfo> interfaceInfoList) {
	List<Permission> permissionList = new ArrayList<Permission>();
	if (interfaceInfoList != null && interfaceInfoList.size() > 0) {
	    for (InterfaceInfo interfaceInfo : interfaceInfoList) {
		if (interfaceInfo != null) {
		    Permission permission = new Permission();
		    permission.setCode(interfaceInfo.getCode());
		    permission.setName(interfaceInfo.getName());
		    permission.setEname(interfaceInfo.getEname());
		    permission.setParentCode(interfaceInfo.getParentCode());
		    permission.setParentName(interfaceInfo.getParentName());
		    permission.setAppType(interfaceInfo.getAppType());
		    permission.setResType(Permission.RES_TYPE_INTERFACE);
		    permission.setResSubType(interfaceInfo.getNeedCheck());
		    permission.setResUri(interfaceInfo.getResUri());
		    permission.setState(interfaceInfo.getState());
		    permission.setOrderNo(interfaceInfo.getOrderNo());
		    permission.setPermValue(interfaceInfo.getPermValue());
		    permission.setLevel(interfaceInfo.getLevel());
		    permission.setIsLeaf(interfaceInfo.getIsLeaf());
		    permission.setDescription(interfaceInfo.getDescription());
		    permission.setCreateTime(interfaceInfo.getCreateTime());
		    permission.setCreator(interfaceInfo.getCreator());
		    permission.setUpdator(interfaceInfo.getUpdator());
		    permission.setUpdateTime(interfaceInfo.getUpdateTime());
		    permissionList.add(permission);
		}
	    }
	}
	return permissionList;
    }

    public static void main(String[] args) {
	
    }

}
