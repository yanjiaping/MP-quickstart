package com.yjp.mybatisplus.entity.tb;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-26
 */
@Data
@TableName("tb_login")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 有效状态
     */
    private String validStatus;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;
}
