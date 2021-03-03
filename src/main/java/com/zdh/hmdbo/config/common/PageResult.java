package com.zdh.hmdbo.config.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author(开发者) Xi
 * @E-mail(邮箱) xxget@live.com
 * @Description(说明) //页面结果
 * @Date(日期) 8:53 2021/3/3
 * @Param(参数)
 * @return(返回)
 * @Version(版本) 1.0.0
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult <T>{

     private long total;
     private List<T> rows;
}
