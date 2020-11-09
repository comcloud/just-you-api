package com.cloud.api.service.VXUser;

import com.cloud.api.bean.entity.Photoalbum;
import com.cloud.api.bean.vo.PhotoalbumVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Set;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/30-12:02
 */
public interface photoAlbumService {
    Set<PhotoalbumVo> getUserPhotoAlbumAll(String YouOpenId, String MyOpenId);
    Photoalbum getUserPhotoByPhotoAlbumID(Long photoAlbumId);
    boolean addPhotoalbum(Photoalbum parent);
    boolean deletePhoto(Long photoId, String function);
    boolean updatePhotoalbum(Photoalbum parent);
    boolean deletephotoAlbum(Long photoAlbumId);


}
