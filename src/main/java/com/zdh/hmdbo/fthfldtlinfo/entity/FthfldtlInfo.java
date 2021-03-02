package com.zdh.hmdbo.fthfldtlinfo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxg
 * @since 2021-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_fthfldtl_info")
@ApiModel(value = "FthfldtlInfo对象", description = "")
public class FthfldtlInfo extends Model<FthfldtlInfo> {

    private static final long serialVersionUID = 1L;

    //抄表时间
    @ApiModelProperty(value = "抄表时间")
    @TableField("colltime")
    private Date colltime;

    //表网络类型
    @ApiModelProperty(value = "表网络类型")
    @TableField("porttype")
    private String porttype;

    //gps卡号码参照fthfldev表获取devname
    @ApiModelProperty(value = "gps卡号码 参照fthfldev表获取devname")
    @TableField("portid")
    private String portid;

    //设备逻辑地址（设备号）
    @ApiModelProperty(value = "设备逻辑地址（设备号）")
    @TableField("devaddr")
    private Integer devaddr;

    //密度
    @ApiModelProperty(value = "密度")
    @TableField("density")
    private Float density;

    //温度
    @ApiModelProperty(value = "温度")
    @TableField("tempretu")
    private Float tempretu;

    //计量压力
    @ApiModelProperty(value = "计量压力")
    @TableField("pressure")
    private Float pressure;

    //计量差压
    @ApiModelProperty(value = "计量差压")
    @TableField("diffpres")
    private Float diffpres;

    //瞬时流量
    @ApiModelProperty(value = "瞬时流量")
    @TableField("flow")
    private Float flow;

    //累计流量
    @ApiModelProperty(value = "累计流量")
    @TableField("sumflow")
    private Float sumflow;

    //用户id
    @ApiModelProperty(value = "用户id")
    @TableField("userid")
    private String userid;

    //状态
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private String status;

    //复述
    @ApiModelProperty(value = "复述")
    @TableField("retrycnt")
    private Integer retrycnt;

    @TableField("PREST")
    private Float prest;

    @TableField("DIFFPT")
    private Float diffpt;

    //诊断信息编码
    @ApiModelProperty(value = "诊断信息编码")
    @TableField("resetinfo")
    private Integer resetinfo;

    //市电报警
    @ApiModelProperty(value = "市电报警")
    @TableField("warninfo")
    private Integer warninfo;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
