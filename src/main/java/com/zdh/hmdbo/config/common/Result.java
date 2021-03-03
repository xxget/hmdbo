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
     * 返回码
    **/
    @NonNull
    private Integer code;
    /**
     * 返回信息
     **/
    @NonNull
    private String message;

    /**
     * 其他参数
     **/
    private Object data;


}
