package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.org.Org;

public interface OrgService {
    /**
     * 新增组织
     * @param org
     * @return
     */
    public int addOrg(Org org);
    /**
     * 编辑组织
     * @param org
     * @return
     */
    public int saveOrg(Org org);
    /**
     * 删除组织
     * @param org
     * @return
     */
    public int delOrgByCode(String orgCode);
    /**
     * 获取组织详细信息
     * @param code
     * @return
     */
    public Org getOrg(String code);
    /**
     * 分页获取组织
     * @return
     */
    public List<Org> getPageOrgList();
    /**
     * 获取所有下级组织
     * @param parentCode
     * @return
     */
    public List<Org> getOrgListByParent(String parentCode);
    /**
     * 获取所有下级组织
     * @param parentCode
     * @return
     */
    public List<Org> getOrgListByRoot(String rootCode);
    /**
     * 根据名称检查组织是否存在
     * @param orgName
     * @return
     */
    public boolean checkOrgExistByName(String orgName,String rootCode);
    /**
     * 获取上级组织信息
     * @param orgCode
     * @return
     */
    public Org getParentOrg(String orgCode);
    /**
     * 获取根组织信息
     * @param orgCode
     * @return
     */
    public Org getRootOrg(String orgCode);
}
