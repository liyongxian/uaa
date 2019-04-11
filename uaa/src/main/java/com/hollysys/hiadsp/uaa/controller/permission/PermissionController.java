/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.controller.permission;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.common.model.permission.InterfaceInfo;
import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.permission.PermissionUtils;
import com.hollysys.hiadsp.common.model.permission.dto.MenuDto;
import com.hollysys.hiadsp.common.model.role.RolePermission;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetElementListResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetElementResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetInterfaceListResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetInterfaceResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetMenuListResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetMenuResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetSysMenusResponse;
import com.hollysys.hiadsp.uaa.service.PermissionService;
import com.hollysys.hiadsp.uaa.service.RolePermissionService;
import com.hollysys.hiadsp.uaa.service.UserRoleService;

/**
 * <p>
 * 权限管理控制器。
 * <p>
 * 
 * 创建日期 2016年11月29日<br>
 * 
 * @author wanghq
 *         <p>
 * @since 1.0.0
 */
@Api(tags = { "permission-controller" })
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    private Logger logger = LoggerFactory.getLogger(PermissionController.class);

    /**
     * 
     * @return 菜单列表
     */
    @ApiOperation(value = "获取所有菜单列表", notes = "用户运营菜单管理")
    @RequestMapping(value = "/getALlMenuList", method = { RequestMethod.GET })
    public @ResponseBody GetMenuListResponse getALlMenuList() {
	GetMenuListResponse response = new GetMenuListResponse();
	response.setSuccess(false);
	List<Permission> permissionList = permissionService.getPermissionList(null, Permission.RES_TYPE_MENU, null);
	List<MenuInfo> menuList = PermissionUtils.permList2MenuList(permissionList);
	response.setMenuList(menuList);
	response.setSuccess(true);
	response.setMsg("获取菜单列表成功");
	return response;
    }
    /**
     * 
     * @return 元素列表
     */
    @ApiOperation(value = "获取所有元素列表", notes = "用户运营元素管理")
    @RequestMapping(value = "/getALlElementList", method = { RequestMethod.GET })
    public @ResponseBody GetElementListResponse getALlElementList() {
	GetElementListResponse response = new GetElementListResponse();
	response.setSuccess(false);
	List<Permission> permissionList = permissionService.getPermissionList(null, Permission.RES_TYPE_ELEMENT, null);
	List<ElementInfo> elementList = PermissionUtils.permList2ElementList(permissionList);
	response.setElementList(elementList);
	response.setSuccess(true);
	response.setMsg("获取元素列表成功");
	return response;
    }
    /**
     * 
     * @return 接口列表
     */
    @ApiOperation(value = "获取所有接口列表", notes = "用户运营接口管理")
    @RequestMapping(value = "/getALlInterfaceList", method = { RequestMethod.GET })
    public @ResponseBody GetInterfaceListResponse getALlInterfaceList() {
	GetInterfaceListResponse response = new GetInterfaceListResponse();
	response.setSuccess(false);
	List<Permission> permissionList = permissionService.getPermissionList(null, Permission.RES_TYPE_INTERFACE, null);
	List<InterfaceInfo> interfaceList = PermissionUtils.permList2InterfaceList(permissionList);
	response.setInterfaceList(interfaceList);
	response.setSuccess(true);
	response.setMsg("获取接口列表成功");
	return response;
    }
    /**
     * 查询菜单详情
     * @param id
     * @return GetMenuResponse
     */
    @ApiOperation(value = "查询菜单详情", notes = "用户运营菜单管理")
    @RequestMapping(value = "/getMenuById", method = { RequestMethod.GET })
    public @ResponseBody GetMenuResponse getMenuById(@ApiParam(name="菜单ID",required=true) @RequestParam(value="id",required=true)String id) {
	GetMenuResponse response = new GetMenuResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("菜单ID不能为空");
	   return response;
	}
	Permission permission = permissionService.getPermission(id);
	if(permission == null){
	    logger.error("execute getMenuById error menu is not exist,id="+id);
	    response.setMsg("获取菜单信息失败");
	    return response;
	}
	MenuInfo menuInfo = PermissionUtils.perm2Menu(permission);
	if(menuInfo == null){
	    logger.error("execute perm2Menu error,id="+id);
	    response.setMsg("获取菜单信息失败");
	    return response;
	}
	response.setSuccess(true);
	response.setMsg("获取菜单信息成功");
	response.setMenuInfo(menuInfo);
	return response;
    }
    /**
     * 查询元素详情
     * @param id
     * @return GetElementResponse
     */
    @ApiOperation(value = "查询元素详情", notes = "用户运营元素管理")
    @RequestMapping(value = "/getElementById", method = { RequestMethod.GET })
    public @ResponseBody GetElementResponse getElementById(@ApiParam(name="元素ID",required=true) @RequestParam(value="id",required=true)String id) {
	GetElementResponse response = new GetElementResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("元素ID不能为空");
	   return response;
	}
	Permission permission = permissionService.getPermission(id);
	if(permission == null){
	    logger.error("execute getElementById error element is not exist,id="+id);
	    response.setMsg("获取元素信息失败");
	    return response;
	}
	ElementInfo elementInfo = PermissionUtils.perm2Element(permission);
	if(elementInfo == null){
	    logger.error("execute perm2Element error,id="+id);
	    response.setMsg("获取元素信息失败");
	    return response;
	}
	response.setSuccess(true);
	response.setMsg("获取元素信息成功");
	response.setElementInfo(elementInfo);
	return response;
    }
    /**
     * 查询接口详情
     * @param id
     * @return BaseResponse
     */
    @ApiOperation(value = "查询接口详情", notes = "用户运营接口管理")
    @RequestMapping(value = "/getInterfaceById", method = { RequestMethod.GET })
    public @ResponseBody GetInterfaceResponse getInterfaceById(@ApiParam(name="接口ID",required=true) @RequestParam(value="id",required=true)String id) {
	GetInterfaceResponse response = new GetInterfaceResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("接口ID不能为空");
	   return response;
	}
	Permission permission = permissionService.getPermission(id);
	if(permission == null){
	    logger.error("execute getInterfaceById error interface is not exist,id="+id);
	    response.setMsg("获取接口信息失败");
	    return response;
	}
	InterfaceInfo interfaceInfo = PermissionUtils.perm2Interface(permission);
	if(interfaceInfo == null){
	    logger.error("execute perm2Interface error,id="+id);
	    response.setMsg("获取接口信息失败");
	    return response;
	}
	response.setSuccess(true);
	response.setMsg("获取接口信息成功");
	response.setInterfaceInfo(interfaceInfo);
	return response;
    }
    /**
     * 新增菜单
     * @param menuInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "新增菜单", notes = "用户运营菜单管理")
    @RequestMapping(value = "/addMenu", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse addMenu(@RequestBody MenuInfo menuInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(menuInfo.getParentCode() != null && !"".equals(menuInfo.getParentCode()) && !"0".equals(menuInfo.getParentCode())){
	    Permission parent = permissionService.getPermission(menuInfo.getParentCode());
	    if(parent == null){
		response.setSuccess(false);
		response.setMsg("父节点不存在");
		return response;
	    }
	}
	menuInfo.setCode(CodeUtil.getLongCode());
	if(menuInfo.getAppType() == null || "".equals(menuInfo.getAppType())){
	    menuInfo.setAppType(Permission.APP_TYPE_CONSOLE);
	}
	if(menuInfo.getIsshow() != null && "".equals(menuInfo.getIsshow())){
	    menuInfo.setIsshow("1"); 
	}
	if(menuInfo.getParentCode() == null || "".equals(menuInfo.getParentCode())){
	    menuInfo.setParentCode("0");
	    menuInfo.setLevel(1);
	}else{
	    Permission parent = permissionService.getPermission(menuInfo.getParentCode());
	    if(parent != null){
		menuInfo.setLevel(parent.getLevel()+1);
	    }else{
		logger.error("execute getPermission error ,permission is null,id="+menuInfo.getParentCode());
	    }
	}
	menuInfo.setIsLeaf("1");
	menuInfo.setCreateTime(sysDate);
	menuInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.menu2Perm(menuInfo);
	if(permission != null ){
	    int num = permissionService.addPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("新增菜单成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("新增菜单失败");
	    }
	    
	}else{
	    logger.error("execute menu2Perm error ,permission is null,id="+menuInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("新增菜单失败");
	}
	return response;
    }
    /**
     * 新增元素
     * @param elementInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "新增元素", notes = "用户运营元素管理")
    @RequestMapping(value = "/addElement", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse addElement(@RequestBody ElementInfo elementInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(elementInfo.getParentCode() != null && !"".equals(elementInfo.getParentCode()) && !"0".equals(elementInfo.getParentCode())){
	    Permission parent = permissionService.getPermission(elementInfo.getParentCode());
	    if(parent == null){
		response.setSuccess(false);
		response.setMsg("父节点不存在");
		return response;
	    }
	}
	elementInfo.setCode(CodeUtil.getLongCode());
	if(elementInfo.getAppType() == null || "".equals(elementInfo.getAppType())){
	    elementInfo.setAppType(Permission.APP_TYPE_WEB);
	}
	if(elementInfo.getState() == null || "".equals(elementInfo.getState())){
	    elementInfo.setState("1"); 
	}
	if(elementInfo.getParentCode() == null || "".equals(elementInfo.getParentCode())){
	    elementInfo.setParentCode("0");
	    elementInfo.setLevel(1);
	}else{
	    Permission parent = permissionService.getPermission(elementInfo.getParentCode());
	    if(parent != null){
		elementInfo.setLevel(parent.getLevel()+1);
	    }else{
		logger.error("execute getPermission error ,permission is null,id="+elementInfo.getParentCode());
	    }
	}
	elementInfo.setIsLeaf("1");
	elementInfo.setCreateTime(sysDate);
	elementInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.element2Perm(elementInfo);
	if(permission != null ){
	    int num = permissionService.addPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("新增元素成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("新增元素失败");
	    }
	    
	}else{
	    logger.error("execute element2Perm error ,permission is null,id="+elementInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("新增元素失败");
	}
	return response;
    }
    /**
     * 新增接口
     * @param interfaceInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "新增接口", notes = "用户运营接口管理")
    @RequestMapping(value = "/addInterface", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse addInterface(@RequestBody InterfaceInfo interfaceInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(interfaceInfo.getParentCode() != null && !"".equals(interfaceInfo.getParentCode()) && !"0".equals(interfaceInfo.getParentCode())){
	    Permission parent = permissionService.getPermission(interfaceInfo.getParentCode());
	    if(parent == null){
		response.setSuccess(false);
		response.setMsg("父节点不存在");
		return response;
	    }
	}
	interfaceInfo.setCode(CodeUtil.getLongCode());
	if(interfaceInfo.getAppType() == null || "".equals(interfaceInfo.getAppType())){
	    interfaceInfo.setAppType(Permission.APP_TYPE_WEB);
	}
	if(interfaceInfo.getState() == null || "".equals(interfaceInfo.getState())){
	    interfaceInfo.setState("1"); 
	}
	if(interfaceInfo.getParentCode() == null || "".equals(interfaceInfo.getParentCode())){
	    interfaceInfo.setParentCode("0");
	    interfaceInfo.setLevel(1);
	}else{
	    Permission parent = permissionService.getPermission(interfaceInfo.getParentCode());
	    if(parent != null){
		interfaceInfo.setLevel(parent.getLevel()+1);
	    }else{
		logger.error("execute getPermission error ,permission is null,id="+interfaceInfo.getParentCode());
	    }
	}
	interfaceInfo.setIsLeaf("1");
	interfaceInfo.setCreateTime(sysDate);
	interfaceInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.interface2Perm(interfaceInfo);
	if(permission != null ){
	    int num = permissionService.addPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("新增接口成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("新增接口失败");
	    }
	    
	}else{
	    logger.error("execute element2Perm error ,permission is null,id="+interfaceInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("新增接口失败");
	}
	return response;
    }
    /**
     * 编辑菜单
     * @param menuInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "编辑菜单", notes = "用户运营菜单管理")
    @RequestMapping(value = "/editMenu", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse editMenu(@RequestBody MenuInfo menuInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(menuInfo.getCode() == null || "".equals(menuInfo.getCode())){
	    response.setMsg("菜单ID不能为空");
	    return response;
	}
	menuInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.menu2Perm(menuInfo);
	if(permission != null ){
	    int num = permissionService.editPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("编辑菜单成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("编辑菜单失败");
	    }
	    
	}else{
	    logger.error("execute menu2Perm error ,permission is null,id="+menuInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("编辑菜单失败");
	}
	return response;
    }
    /**
     * 编辑元素
     * @param elementInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "编辑元素", notes = "用户运营元素管理")
    @RequestMapping(value = "/editElement", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse editElement(@RequestBody ElementInfo elementInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(elementInfo.getCode() == null || "".equals(elementInfo.getCode())){
	    response.setMsg("元素ID不能为空");
	    return response;
	}
	elementInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.element2Perm(elementInfo);
	if(permission != null ){
	    int num = permissionService.editPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("编辑元素成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("编辑元素失败");
	    }
	    
	}else{
	    logger.error("execute element2Perm error ,permission is null,id="+elementInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("编辑元素失败");
	}
	return response;
    }
    /**
     * 编辑接口
     * @param interfaceInfo
     * @return BaseResponse
     */
    @ApiOperation(value = "编辑接口", notes = "用户运营接口管理")
    @RequestMapping(value = "/editInterface", method = { RequestMethod.POST })
    public @ResponseBody BaseResponse editInterface(@RequestBody InterfaceInfo interfaceInfo) {
	Date sysDate = new Date();
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(interfaceInfo.getCode() == null || "".equals(interfaceInfo.getCode())){
	    response.setMsg("接口ID不能为空");
	    return response;
	}
	interfaceInfo.setUpdateTime(sysDate);
	Permission permission = PermissionUtils.interface2Perm(interfaceInfo);
	if(permission != null ){
	    int num = permissionService.editPermission(permission); 
	    if(num > 0){
		response.setSuccess(true);
		response.setMsg("编辑接口成功");
	    }else{
		response.setSuccess(false);
		response.setMsg("编辑接口失败");
	    }
	    
	}else{
	    logger.error("execute interface2Perm error ,permission is null,id="+interfaceInfo.getCode());
	    response.setSuccess(false);
	    response.setMsg("编辑接口失败");
	}
	return response;
    }
    /**
     * 删除菜单
     * @param id
     * @return BaseResponse
     */
    @ApiOperation(value = "删除菜单", notes = "用户运营菜单管理")
    @RequestMapping(value = "/delMenuById", method = { RequestMethod.GET })
    public @ResponseBody BaseResponse delMenuById(@ApiParam(name="菜单ID",required=true) @RequestParam(value="id",required=true)String id) {
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("菜单ID不能为空");
	   return response;
	}
	List<RolePermission> rolePermissionList = rolePermissionService.getRolePermissionListByPerm(id);
	if(rolePermissionList != null && rolePermissionList.size() > 0){
	    response.setMsg("删除失败，存在和菜单关联的角色");
	    return response;
	}
	int num = permissionService.delPermission(id);
	if(num > 0){
	    response.setSuccess(true);
	    response.setMsg("删除菜单信息成功");  
	}else{
	    response.setSuccess(false);
	    response.setMsg("删除菜单信息失败"); 
	}
	return response;
    }
    /**
     * 删除元素
     * @param id
     * @return GetElementResponse
     */
    @ApiOperation(value = "删除元素", notes = "用户运营元素管理")
    @RequestMapping(value = "/delElementById", method = { RequestMethod.GET })
    public @ResponseBody BaseResponse delElementById(@ApiParam(name="元素ID",required=true) @RequestParam(value="id",required=true)String id) {
	BaseResponse response = new BaseResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("元素ID不能为空");
	   return response;
	}
	List<RolePermission> rolePermissionList = rolePermissionService.getRolePermissionListByPerm(id);
	if(rolePermissionList != null && rolePermissionList.size() > 0){
	    response.setMsg("删除失败，存在和元素关联的角色");
	    return response;
	}
	int num = permissionService.delPermission(id);
	if(num > 0){
	    response.setSuccess(true);
	    response.setMsg("删除元素信息成功");  
	}else{
	    response.setSuccess(false);
	    response.setMsg("删除元素信息失败"); 
	}
	return response;
    }
    /**
     * 删除接口
     * @param id
     * @return BaseResponse
     */
    @ApiOperation(value = "删除接口", notes = "用户运营接口管理")
    @RequestMapping(value = "/delInterfaceById", method = { RequestMethod.GET })
    public @ResponseBody GetInterfaceResponse delInterfaceById(@ApiParam(name="接口ID",required=true) @RequestParam(value="id",required=true)String id) {
	GetInterfaceResponse response = new GetInterfaceResponse();
	response.setSuccess(false);
	if(id == null || "".equals(id)){
	   response.setMsg("接口ID不能为空");
	   return response;
	}
	List<RolePermission> rolePermissionList = rolePermissionService.getRolePermissionListByPerm(id);
	if(rolePermissionList != null && rolePermissionList.size() > 0){
	    response.setMsg("删除失败，存在和接口关联的角色");
	    return response;
	}
	int num = permissionService.delPermission(id);
	if(num > 0){
	    response.setSuccess(true);
	    response.setMsg("删除接口信息成功");  
	}else{
	    response.setSuccess(false);
	    response.setMsg("删除接口信息失败"); 
	}
	return response;
    }
   
    
    /**
     * 运营账户超级账户获取所有菜单
     * @return
     */
    @ApiOperation(value = "运营超级账户获取所有菜单", notes = "运营账户超级账户获取所有菜单")
    @RequestMapping(value = "/getAllMenus", method = { RequestMethod.GET })
    public @ResponseBody GetSysMenusResponse getAllMenus(){
    	GetSysMenusResponse resp = new GetSysMenusResponse();
    	List<MenuDto> enterpriseMenus = permissionService.getAllMenus();
    	resp.setMenus(enterpriseMenus);
    	resp.setSuccess(true);
    	resp.setMsg("查询超级用户菜单成功");
    	
    	return resp;
    }
    
}
