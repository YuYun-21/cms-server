package edu.ynmd.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Myfriend {
    private String myfriendid;
    private String content;
    private String pic;
    private Long pbtime;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
    @Column(name = "myfriendid")
    public String getMyfriendid() {
        return myfriendid;
    }

    public void setMyfriendid(String myfriendid) {
        this.myfriendid = myfriendid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pic")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "pbtime")
    public Long getPbtime() {
        return pbtime;
    }

    public void setPbtime(Long pbtime) {
        this.pbtime = pbtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Myfriend myfriend = (Myfriend) o;

        if (myfriendid != null ? !myfriendid.equals(myfriend.myfriendid) : myfriend.myfriendid != null) return false;
        if (content != null ? !content.equals(myfriend.content) : myfriend.content != null) return false;
        if (pic != null ? !pic.equals(myfriend.pic) : myfriend.pic != null) return false;
        if (pbtime != null ? !pbtime.equals(myfriend.pbtime) : myfriend.pbtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = myfriendid != null ? myfriendid.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (pbtime != null ? pbtime.hashCode() : 0);
        return result;
    }
}
