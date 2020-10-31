package com.cloud.api.mapper.VXUser;
import	java.util.List;
import java.util.Map;

import com.cloud.api.bean.entity.Photoalbum;
import com.cloud.api.bean.vo.PhotoalbumVo;
import com.cloud.api.bean.vo.photoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/30-12:03
 */
@Mapper
public interface photoAlbumMapper {
    /**
     * 根据用户opnID 获取用户的所有相册
     * @return 返回用户的相册集合
     */
    List<PhotoalbumVo> selectUserPhotoAlbumAll(@Param("YouOpenId") String YouOpenId, @Param("permissions") Integer permissions);

    /**
     *  根据相册Id 获取相册详情信息 加图片
     * @param photoAlbumId
     * @return
     */
    Photoalbum selectUserPhotoByPhotoAlbumID(@Param("photoAlbumId") Long photoAlbumId);

    /**
     * 添加相册
     * @param map
     * @return
     */
    int insertPhotoalbum(Map<String,Object> map);

    /**
     * 根据相册Id查询相册内所有照片
     * @param photoAlbumId
     * @return
     */
    List<photoVo> selectPhotoByphotoAlbumId(@Param("photoAlbumId") Long photoAlbumId);

    /**
     * 删除 照片
     * @param photoId 照片Id
     * @param function 方法  delete ： 删除 restore：恢复  thoroughly：彻底删除
     * @return
     */
    int deletePhoto(@Param("photoId") Long photoId, @Param("function") String function);

    /**
     * 修改相册信息
     * @param map 修改信息集合
     * @return
     */
    int updatePhotoalbum(Map<String,Object> map);

    /**
     * 删除相册
     * @param photoAlbumId 相册Id
     * @return
     */
    int deletephotoAlbum(@Param("photoAlbumId") Long photoAlbumId);


}
