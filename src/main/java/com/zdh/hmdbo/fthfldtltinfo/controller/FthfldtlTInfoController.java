package com.zdh.hmdbo.fthfldtltinfo.controller;



import com.zdh.hmdbo.fthfldtltinfo.service.FthfldtlTInfoService;
import com.zdh.hmdbo.fthfldtltinfo.entity.FthfldtlTInfo;
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
@Api(tags = "整理后的数据表")
@RestController
@RequestMapping("/fthfldtltinfo/fthfldtlTInfo")
public class FthfldtlTInfoController {

    @Autowired
    public FthfldtlTInfoService fthfldtlTInfoService;

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody FthfldtlTInfo fthfldtlTInfo){
        fthfldtlTInfoService.save(fthfldtlTInfo);
        return new Result(StatusCode.SUCCESS,"保存成功");
    }

    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        fthfldtlTInfoService.removeById(id);
        return new Result(StatusCode.SUCCESS,"删除成功");
    }

    @ApiOperation(value = "条件查询", notes = "根据条件查询")
    @PostMapping("/get")
    public Result list(@RequestBody FthfldtlTInfo fthfldtlTInfo){
        List<FthfldtlTInfo> fthfldtlTInfoList = fthfldtlTInfoService.list(new QueryWrapper<>(fthfldtlTInfo));
        return new Result(StatusCode.SUCCESS,"查询成功",fthfldtlTInfoList);
    }

    @ApiOperation(value = "列表（分页）", notes = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum")Long pageNum, @PathVariable("pageSize")Long pageSize){
        IPage<FthfldtlTInfo> page = fthfldtlTInfoService.page(
        new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS,"查询成功",new PageResult<>(page.getTotal(),page.getRecords()));
    }

    @ApiOperation(value = "详情", notes = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id){
        FthfldtlTInfo fthfldtlTInfo = fthfldtlTInfoService.getById(id);
        return new Result(StatusCode.SUCCESS,"查询成功",fthfldtlTInfo);
    }

    @ApiOperation(value = "根据id修改", notes = "根据id修改")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody FthfldtlTInfo fthfldtlTInfo){
        fthfldtlTInfo.setId(Integer.valueOf(id));
        fthfldtlTInfoService.updateById(fthfldtlTInfo);
        return new Result(StatusCode.SUCCESS,"更新成功");
    }


}
