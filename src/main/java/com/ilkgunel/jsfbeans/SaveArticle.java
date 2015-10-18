package com.ilkgunel.jsfbeans;

import com.ilkgunel.pojo.ArticlePojo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by ilkaygunel on 18/10/15.
 */
@ManagedBean
@SessionScoped
public class SaveArticle {
    ArticlePojo articlePojoObject=new ArticlePojo();

    public ArticlePojo getArticlePojoObject() {
        return articlePojoObject;
    }

    public void setArticlePojoObject(ArticlePojo articlePojoObject) {
        this.articlePojoObject = articlePojoObject;
    }
}
