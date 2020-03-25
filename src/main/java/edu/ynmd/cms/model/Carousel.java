package edu.ynmd.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Carousel {
    private String carouselid;
    private String title;
    private String description;
    private String picurl;
    private String contenturl;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类
    @Column(name = "carouselid")
    public String getCarouselid() {
        return carouselid;
    }

    public void setCarouselid(String carouselid) {
        this.carouselid = carouselid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picurl")
    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Basic
    @Column(name = "contenturl")
    public String getContenturl() {
        return contenturl;
    }

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carousel carousel = (Carousel) o;

        if (carouselid != null ? !carouselid.equals(carousel.carouselid) : carousel.carouselid != null) return false;
        if (title != null ? !title.equals(carousel.title) : carousel.title != null) return false;
        if (description != null ? !description.equals(carousel.description) : carousel.description != null)
            return false;
        if (picurl != null ? !picurl.equals(carousel.picurl) : carousel.picurl != null) return false;
        if (contenturl != null ? !contenturl.equals(carousel.contenturl) : carousel.contenturl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carouselid != null ? carouselid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picurl != null ? picurl.hashCode() : 0);
        result = 31 * result + (contenturl != null ? contenturl.hashCode() : 0);
        return result;
    }
}
