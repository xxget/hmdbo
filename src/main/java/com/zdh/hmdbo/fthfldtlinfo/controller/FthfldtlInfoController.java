package com.zdh.hmdbo.fthfldtlinfo.controller;



import com.zdh.hmdbo.fthfldtlinfo.service.FthfldtlInfoService;
import com.zdh.hmdbo.fthfldtlinfo.entity.FthfldtlInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdh.hmdbo.config.common.PageResult;
import com.zdh.hmdbo.config.common.Result;
import com.zdh.hmdbo.config.common.StatusCode;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author xxg
* @since 2021-03-03
*/

@Slf4j
@Api(tags = "华明系统取数模块")
@RestController
@RequestMapping("/fthfldtlinfo/fthfldtlInfo")
public class FthfldtlInfoController {

    @Autowired
    public FthfldtlInfoService fthfldtlInfoService;

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody FthfldtlInfo fthfldtlInfo){
        fthfldtlInfoService.save(fthfldtlInfo);
        return new Result(StatusCode.SUCCESS,"保存成功");
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        fthfldtlInfoService.removeById(id);
        return new Result(StatusCode.SUCCESS,"删除成功");
    }

    @ApiOperation(value = "条件查询")
    @PostMapping("/get")
    public Result list(@RequestBody FthfldtlInfo fthfldtlInfo){
        List<FthfldtlInfo> fthfldtlInfoList = fthfldtlInfoService.list(new QueryWrapper<>(fthfldtlInfo));
        return new Result(StatusCode.SUCCESS,"查询成功",fthfldtlInfoList);
    }

    @ApiOperation(value = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum")Long pageNum, @PathVariable("pageSize")Long pageSize){
        IPage<FthfldtlInfo> page = fthfldtlInfoService.page(
        new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS,"查询成功",new PageResult<>(page.getTotal(),page.getRecords()));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id){
        FthfldtlInfo fthfldtlInfo = fthfldtlInfoService.getById(id);
        return new Result(StatusCode.SUCCESS,"查询成功",fthfldtlInfo);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody FthfldtlInfo fthfldtlInfo){
        fthfldtlInfo.setId(Integer.valueOf(id));
        fthfldtlInfoService.updateById(fthfldtlInfo);
        return new Result(StatusCode.SUCCESS,"更新成功");
    }


}
