package com.hollysys.hiadsp.uaa.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hollysys.hiadsp.common.model.permission.MenuInfo;

/**
 * 
 * <p>
 * 树形结构所用类。
 * <p>
 *
 * 创建日期 2015年7月16日<br>
 * @author  $litong$<p>
 * @since  1.0.0
 */
public class MenuTreeBO {
    private String id;
    private String name;
    private String ename;
    private String appType;// 一级分类（01：web；02：console）
    private String routeState;
    private String parentId;
    private String parentName;
    private String icon;// 资源（如：菜单的图标）
    private String isshow;
    private Integer orderNo;
    private String permValue;
    private Integer level;
    private String isLeaf;
    private String description;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String updator;
    private boolean flag =  false;// 标记是否遍历过
    private List<MenuTreeBO> children;

    public MenuTreeBO() {}

    public MenuTreeBO(MenuInfo menu) {
    	this.id = menu.getCode();
       this.parentId = menu.getParentCode();
       this.parentName = menu.getParentName();
       this.name = menu.getName();
       this.orderNo = menu.getOrderNo();
       this.icon = menu.getIcon();
       this.isshow = menu.getIsshow();
       this.permValue= menu.getPermValue();
       this.creator = menu.getCreator();
       this.createTime = menu.getCreateTime();
       this.description = menu.getDescription();
       this.routeState = menu.getRouteState();
    }
    
    public void setRouteState(String routeState) {
		this.routeState = routeState;
	}
    
    public String getRouteState() {
		return routeState;
	}
    private void setFlag(boolean flag) {
		this.flag = flag;
	}
    private boolean findFlag(){
    	return flag;
    }

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPermValue() {
        return permValue;
    }

    public void setPermValue(String permValue) {
        this.permValue = permValue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public boolean isFlag() {
        return flag;
    }

	public List<MenuTreeBO> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTreeBO> children) {
		this.children = children;
	}

	/**
	 * 把查询到的集合变成树形表格，并排序
	 * 
	 * @param treeList
	 * @return
	 */
	public static List<MenuTreeBO> tranAndSort(List<MenuTreeBO> treeList){
		List<MenuTreeBO> tree = MenuTreeBO.tran(treeList);
		sortChildren(tree);
		return tree;
	}
	private static void sortChildren(List<MenuTreeBO> subMenus) {
		if (subMenus.size() != 0) {
			// 对兄弟节点进行排序
			Collections.sort(subMenus, new Comparator<MenuTreeBO>(){
				@Override
				public int compare(MenuTreeBO o1, MenuTreeBO o2) {
					int result;
					int sort1 = o1.getOrderNo();
					int sort2 = o2.getOrderNo();
					result = sort1 - sort2;
					if(result == 0){
						String id1 = o1.getId();
						String id2 = o2.getId();
						result = id1.compareTo(id2);
					}
					return result;
				}
				
			});
			// 对子节点进行排序
			for (Iterator<MenuTreeBO> it = subMenus.iterator(); it.hasNext();) {
				sortChildren(it.next().getChildren());
			}
		}
	} 
	
    /**
     * 把查询到的集合变成树形表格
     * 
     * @param treeList
     * @return
     */
    public static List<MenuTreeBO> tran(List<MenuTreeBO> treeList) {
        List<MenuTreeBO> newTreeList = new ArrayList<MenuTreeBO>();
        for (MenuTreeBO treeBO : treeList) {
            if (treeBO.getParentId().equals(treeBO.getId()) || "0".equals(treeBO.getParentId())) {
            	treeBO.setFlag(true);
                newTreeList.add(treeBO);
                setChild(treeBO, treeList);
            }
        }
        return newTreeList;
    }

    /**
     * 设置树的子节点
     * 
     * @param TreeBO
     * @param treeList
     */
    private static void setChild(MenuTreeBO treeBO, List<MenuTreeBO> treeList) {
        List<MenuTreeBO> childBOs = new ArrayList<MenuTreeBO>();
        for (MenuTreeBO childTree : treeList) {
            if (isParent(treeBO, childTree)) {
            	if(!childTree.findFlag()){
            		childBOs.add(childTree);
            		childTree.setFlag(true);
            		setChild(childTree, treeList);
            	}
            }
        }
        treeBO.setChildren(childBOs);
    }

    /**
     * 是否为父节点(菜单)
     * 
     * @param treeList
     * @param treeBO
     * @return
     */
    private static boolean isParent(MenuTreeBO treeBO, MenuTreeBO childTree) {
        return treeBO.getId().equals(childTree.getParentId());
    }
}
