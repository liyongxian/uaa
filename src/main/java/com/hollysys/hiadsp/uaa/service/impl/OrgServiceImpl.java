package com.hollysys.hiadsp.uaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.org.Org;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.mapper.org.OrgMapper;
import com.hollysys.hiadsp.uaa.service.OrgService;

@Service("orgService")
public class OrgServiceImpl implements OrgService {
    private static Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);
    @Autowired
    private OrgMapper orgMapper;

    @Override
    public int addOrg(Org org) {
	int result = -1;
	if(org == null){
	    logger.error("execute addOrg error,org can not be null");
	    return result;
	}
	if(org.getCode() == null || "".equals(org.getCode())){
	    org.setCode(CodeUtil.getLongCode()); 
	}
	result = orgMapper.insert(org);
	if(result >0){
	    logger.info("execute addOrg success,orgCode="+org.getCode()); 
	}else{
	    logger.error("execute addOrg error,insert into db error,orgCode="+org.getCode());
	}
	return result;
    }

    @Override
    public int saveOrg(Org org) {
	int result = -1;
	if(org == null){
	    logger.error("execute saveOrg error,org can not be null");
	    return result;
	}
	if(org.getCode() == null || "".equals(org.getCode())){
	    logger.error("execute saveOrg error,orgCode can not be null");
	    return result;
	}
	result = orgMapper.updateByPrimaryKey(org);
	if(result >0){
	    logger.info("execute saveOrg success,orgCode="+org.getCode()); 
	}else{
	    logger.error("execute saveOrg error,update into db error,orgCode="+org.getCode());
	}
	return result;
    }

    @Override
    public int delOrgByCode(String code) {
	int result = -1;
	if(code == null || "".equals(code)){
	    logger.error("execute delOrgByCode error,code can not be null");
	    return result;
	}
	result = this.delOrgTree(code);
	if(result >0){
	    logger.info("execute delOrgByCode success,delnum="+result+"orgCode="+code); 
	}else{
	    logger.warn("execute delOrgByCode warn,org does not exist in db,orgCode="+code);
	}
	return result;
    }

    @Override
    public Org getOrg(String code) {
	if(code == null || "".equals(code)){
	    logger.error("execute getOrg error,code can not be null");
	    return null;
	}
	return orgMapper.selectByPrimaryKey(code);
    }

    @Override
    public List<Org> getPageOrgList() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Org> getOrgListByParent(String parentCode) {
	List<Org> orgList = new ArrayList<Org>();
	if(parentCode == null || "".equals(parentCode)){
	    logger.error("execute getOrgListByParent error,code can not be null");
	    return orgList;
	}
	orgList = orgMapper.selectByParent(parentCode);
	return orgList;
    }

    @Override
    public boolean checkOrgExistByName(String orgName,String rootCode) {
	boolean result = false;
	if(orgName == null || "".equals(orgName)){
	    logger.error("execute checkOrgExistByName error,code can not be null");
	    return result;
	}
	int num = orgMapper.countByName(orgName,rootCode);
	result = num>0?false:true;
	return result;
    }

    @Override
    public Org getParentOrg(String orgCode) {
	if(orgCode == null || "".equals(orgCode)){
	    logger.error("execute getParentOrg error,code can not be null");
	    return null;
	}
	return orgMapper.getParentOrg(orgCode);
    }

    @Override
    public Org getRootOrg(String orgCode) {
	if(orgCode == null || "".equals(orgCode)){
	    logger.error("execute getRootOrg error,code can not be null");
	    return null;
	}
	return orgMapper.getRootOrg(orgCode);
    }
    /**
     * 删除自身及下级组织
     * @param orgCode
     * @return
     */
    private int delOrgTree(String orgCode){
	int num = 0;
	if(orgCode == null || "".equals(orgCode)){
	    return num;
	}
	List<Org> childOrgList = orgMapper.selectByParent(orgCode);
	if(childOrgList != null && childOrgList.size() > 0){
	    for(Org org : childOrgList){
		if(org != null && org.getCode() != null && !"".equals(org.getCode())){
		    num += delOrgTree(org.getCode());
		}
	    }
	    
	}else{
	    num += orgMapper.deleteByPrimaryKey(orgCode);
	}
	return num;
    }

    @Override
    public List<Org> getOrgListByRoot(String rootCode) {
	List<Org> orgList = new ArrayList<Org>();
	if(rootCode == null || "".equals(rootCode)){
	    logger.error("execute getOrgListByRoot error,rootCode can not be null");
	    return orgList;
	}
	orgList = orgMapper.selectByRoot(rootCode);
	return orgList;
    }

}
