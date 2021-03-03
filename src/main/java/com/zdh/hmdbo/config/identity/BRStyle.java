package com.zdh.hmdbo.config.identity;

/**
 * @Author(开发者) Xi
 * @E-mail(邮箱) xxget@live.com
 * @Description(说明) 定义一个枚举，主要是为了为特定业务生成特定的id
 * @Date(日期) 10:59 2021/2/24
 * @Param(参数)
 * @return(返回)
 * @Version(版本) 1.0.0
**/
public enum BRStyle {
    CO("CO", "主键模块"),
    ;
    private final String code;
    private final String info;

    BRStyle(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}