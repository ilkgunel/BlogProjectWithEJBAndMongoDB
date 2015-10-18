package com.ilkgunel.jsfbeans;

import com.ilkgunel.pojo.ArticlePojo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * Created by ilkaygunel on 18/10/15.
 */
@ManagedBean
@SessionScoped
public class Preview {
    @ManagedProperty(value = "#{saveArticle}")
    private SaveArticle saveArticleObject;

    ArticlePojo articlePojoObject=new ArticlePojo();

    public SaveArticle getSaveArticleObject() {
        return saveArticleObject;
    }

    public void setSaveArticleObject(SaveArticle saveArticleObject) {
        this.saveArticleObject = saveArticleObject;
    }

    public void previewMethod(ActionEvent event)
    {
        articlePojoObject.setArticleTitle(saveArticleObject.articlePojoObject.getArticleTitle());
        articlePojoObject.setArticleContent(saveArticleObject.articlePojoObject.getArticleContent());
    }
}
