package com.cloud.api.bean.vo;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-16:57
 */
public class photoVo {
    private Long id;
    private String photoUrl;

    public photoVo() {
    }

    public photoVo(Long photoId, String photoUrl) {
        this.id = photoId;
        this.photoUrl = photoUrl;
    }

    public Long getPhotoId() {
        return id;
    }

    public void setPhotoId(Long photoId) {
        this.id = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "photoVo{" +
                "photoId=" + id +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
