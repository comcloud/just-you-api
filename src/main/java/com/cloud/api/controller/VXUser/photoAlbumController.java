package com.cloud.api.controller.VXUser;

import com.cloud.api.bean.entity.Photoalbum;
import com.cloud.api.service.VXUser.photoAlbumService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/30-12:05
 */
@Controller
@ResponseBody
@RequestMapping("/user")
@Api(value = "用户相册 Controller 层",tags ="处理用户相册操作")
public class photoAlbumController {
    @Autowired
    private photoAlbumService photoAlbumService;
    @Operation(summary="遍历用户相册")
    @GetMapping("/getUserPhotoAlbumAll")
    public Result getUserPhotoAlbumAll(@ApiParam(name = "photoAlbumOpenId", value = "当前相册属于用户的用户OpenID") @RequestParam("photoAlbumOpenId")String  photoAlbumOpenId,
                                       @ApiParam(name = "MyOpenId", value = "访问用户的OPenId")String MyOpenId){
        return ResultGenerator.genSuccessResult(photoAlbumService.getUserPhotoAlbumAll(photoAlbumOpenId,MyOpenId));
    }
    @GetMapping("/getUserPhotoByPhotoAlbumID")
    @Operation(summary = "根据相册ID 访问相册页面")
    public Result getUserPhotoByPhotoAlbumID(@ApiParam(name = "photoAlbumId", value = "当前相册属于用户的用户OpenID") @RequestParam("photoAlbumId") Long photoAlbumId){
        return ResultGenerator.genSuccessResult(photoAlbumService.getUserPhotoByPhotoAlbumID(photoAlbumId));
    }
    @GetMapping("/addPhotoalbum")
    @Operation(summary = "创建用户相册")
    public Result addPhotoalbum(@ApiParam(name = "photoalbum", value = "相册实体类 字段有疑问的化Q我")@RequestBody Photoalbum photoalbum){
        if(photoAlbumService.addPhotoalbum(photoalbum)){
            return ResultGenerator.genSuccessResult("相册新增成功");
        }else {
            return ResultGenerator.genFailResult("创建失败");
        }
    }
    @Operation(summary = "删除照片")
    @GetMapping("/deletePhoto")
    public Result deletePhoto(@ApiParam(name="photoId",value = "照片的Id") Long photoId,
                              @ApiParam(name="function",value = "功能   delete ： 删除 restore：恢复  thoroughly：彻底删除") String function){
        if (photoAlbumService.deletePhoto(photoId, function)){
            return ResultGenerator.genSuccessResult(function+"---》成功");
        }else {
            return ResultGenerator.genFailResult(function+"---》失败");
        }
    }
    @Operation(summary = "修改相册信息")
    @GetMapping("/updatePhotoalbum")
    public  Result updatePhotoalbum(@ApiParam(name = "photoalbum", value = "相册实体类 字段有疑问的化Q我")@RequestBody Photoalbum photoalbum){
        if (photoAlbumService.updatePhotoalbum(photoalbum)){
            return ResultGenerator.genSuccessResult("修改"+"---》成功");
        }else {
            return ResultGenerator.genFailResult("---》失败");
        }
    }
    @Operation(summary = "删除相册")
    @GetMapping("/deletephotoAlbum")
    public Result deletephotoAlbum(@ApiParam(name = "photoAlbumId", value = "当前相册属于用户的用户OpenID") @RequestParam("photoAlbumId") Long photoAlbumId){
        if (photoAlbumService.deletephotoAlbum(photoAlbumId)){
            return ResultGenerator.genSuccessResult("删除"+"---》成功");

        }else {
            return ResultGenerator.genFailResult("---》失败");

        }
    }

}
