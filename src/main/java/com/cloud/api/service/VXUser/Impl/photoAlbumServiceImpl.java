package com.cloud.api.service.VXUser.Impl;

import com.cloud.api.bean.entity.Photoalbum;
import com.cloud.api.bean.vo.PhotoalbumVo;
import com.cloud.api.bean.vo.photoVo;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.mapper.VXUser.photoAlbumMapper;
import com.cloud.api.service.VXUser.photoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/30-12:02
 */
@Service
@Transactional
public class photoAlbumServiceImpl implements photoAlbumService {
    @Autowired
    private photoAlbumMapper photoAlbumMapper;
    @Autowired
    private VXUserMapper vXUserMapper;
    @Override
    public Set<PhotoalbumVo> getUserPhotoAlbumAll(String  photoAlbumOpenId, String MyOpenId) {
        Set<PhotoalbumVo> photoalbums = new HashSet<>();
        if(photoAlbumOpenId.equals(MyOpenId)){
            photoalbums.addAll(photoAlbumMapper.selectUserPhotoAlbumAll(photoAlbumOpenId, 55));
            return photoalbums;
        }
        if (vXUserMapper.SelectISTtentionUser(photoAlbumOpenId,MyOpenId)>0){
            photoalbums.addAll(photoAlbumMapper.selectUserPhotoAlbumAll(photoAlbumOpenId, 2));
        }
        if (vXUserMapper.SelectISTtentionUser(MyOpenId,photoAlbumOpenId)>0){
            photoalbums.addAll(photoAlbumMapper.selectUserPhotoAlbumAll(photoAlbumOpenId, 3));
        }
        return photoalbums;
    }

    @Override
    public Photoalbum getUserPhotoByPhotoAlbumID(Long photoAlbumId) {
        Photoalbum photoalbum = photoAlbumMapper.selectUserPhotoByPhotoAlbumID(photoAlbumId);
        List<photoVo> photoVos = photoAlbumMapper.selectPhotoByphotoAlbumId(photoAlbumId);
        HashMap<String, List<photoVo>> map = new HashMap<>();
        for (photoVo photoVo : photoVos) {
            if (map.size()==0){
                List<photoVo> photoVos1 = new ArrayList<>();
                photoVos1.add(photoVo);
                map.put(new SimpleDateFormat("yyyy/MM/dd").format(photoVo.getPhotoTime()),photoVos1);
            }else {
                String format = new SimpleDateFormat("yyyy/MM/dd").format(photoVo.getPhotoTime());
                boolean b = map.containsKey(format);
                if (b){
                    List<photoVo> photoVos1 = map.get(format);
                    photoVos1.add(photoVo);
                    map.put(format,photoVos1);
                }else {
                    List<photoVo> photoVos1 = new ArrayList<>();
                    photoVos1.add(photoVo);
                    map.put(new SimpleDateFormat("yyyy/MM/dd").format(photoVo.getPhotoTime()),photoVos1);
                }
            }
        }
        photoalbum.setPhotoVos(map);
        return  photoalbum;
    }
    @Override
    public boolean addPhotoalbum(Photoalbum parent) {
        Map<String, Object> map = new HashMap<>();
        if (parent.getPhotoalbumName()!=null){
            map.put("photoalbumName", parent.getPhotoalbumName());
        }if(parent.getPhotoalbumDescribe()!=null){
            map.put("photoalbumDescribe", parent.getPhotoalbumDescribe());
        }if (parent.getPhotoAlbumStemPan()!=null){
            map.put("photoAlbumStemPan", parent.getPhotoAlbumStemPan());
        }if (parent.getPhotoalbumPermissions()!=null){
            map.put("photoalbumPermissions",parent.getPhotoalbumPermissions());
        }if (parent.getOpenId()!=null){
            map.put("openId", parent.getOpenId());
        }
        return photoAlbumMapper.insertPhotoalbum(map)>0;
    }
    @Override
    public boolean deletePhoto(Long photoId, String function) {
        return photoAlbumMapper.deletePhoto(photoId,function)>0;
    }

    @Override
    public boolean updatePhotoalbum(Photoalbum parent) {
        Map<String, Object> map = new HashMap<>();
        if (parent.getPhotoalbumName()!=null){
            map.put("photoalbumName", parent.getPhotoalbumName());
        }if(parent.getPhotoalbumDescribe()!=null){
            map.put("photoalbumDescribe", parent.getPhotoalbumDescribe());
        }if (parent.getPhotoAlbumStemPan()!=null){
            map.put("photoAlbumStemPan", parent.getPhotoAlbumStemPan());
        }if (parent.getPhotoalbumPermissions()!=null){
            map.put("photoalbumPermissions",parent.getPhotoalbumPermissions());
        }
        return photoAlbumMapper.updatePhotoalbum(map)>0;
    }


    @Override
    public boolean deletephotoAlbum(Long photoAlbumId) {
        return photoAlbumMapper.deletephotoAlbum(photoAlbumId)>0;
    }
}
