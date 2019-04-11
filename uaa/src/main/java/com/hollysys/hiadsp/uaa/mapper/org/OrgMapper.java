package com.hollysys.hiadsp.uaa.mapper.org;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hollysys.hiadsp.common.model.org.Org;

@Mapper
public interface OrgMapper {
	int deleteByPrimaryKey(String code);

	int insert(Org record);

	int insertSelective(Org record);

	Org selectByPrimaryKey(String code);

	List<Org> selectByParent(String parentCode);

	List<Org> selectByRoot(String rootCode);

	int updateByPrimaryKeySelective(Org record);

	int updateByPrimaryKeyWithBLOBs(Org record);

	int updateByPrimaryKey(Org record);

	Org getRootOrg(String orgCode);

	Org getParentOrg(String orgCode);

	int countByName(@Param("orgName") String orgName,
			@Param("rootCode") String rootCode);

}