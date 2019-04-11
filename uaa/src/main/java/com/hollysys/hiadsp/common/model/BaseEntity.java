package com.hollysys.hiadsp.common.model;

import java.io.Serializable;

/**
 * 
 * <p>
 * 基础的数据类,其他数据类必须继承本类。
 * <p>
 *
 * 创建日期 2015年7月13日<br>
 * @author  $litong$<p>
 * @since  1.0.0
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//数据库使用的编号
    private String code;//系统使用的编号

    /**
     * id对象是数据库中自增存在的,个个对象操作时候不许操作id对象
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 由系统生成的code(唯一编码)
     * @return
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
   
}
