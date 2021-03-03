package com.zdh.hmdbo.config.common;

import lombok.*;

/**
 * @Author(开发者) Xi
 * @E-mail(邮箱) xxget@live.com
 * @Description(说明) //返回消息
 * @Date(日期) 8:49 2021/3/3
 * @Param(参数)
 * @return(返回)
 * @Version(版本) 1.0.0
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {

    /**
     * 编码
    **/
    @NonNull
    private Integer code;
    /**
     * 返回消息
     **/
    @NonNull
    private String message;

    /**
     * 数据
     **/
    private Object data;


}
