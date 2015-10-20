package com.ilkgunel.jsfbeans;

import com.ilkgunel.pojo.ArticlePojo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by ilkaygunel on 18/10/15.
 */
@ManagedBean
@SessionScoped
public class SaveArticle {
    ArticlePojo articlePojoObject=new ArticlePojo();
    
    String operationMessage="";
    String messageColor="";
    boolean renderingMessage=false;
    
    static int articleId=2;
    
    public ArticlePojo getArticlePojoObject() {
        return articlePojoObject;
    }

    public void setArticlePojoObject(ArticlePojo articlePojoObject) {
        this.articlePojoObject = articlePojoObject;
    }
    
    public void saveArticleToMongoDB()
    {
        try 
        {
            MongoClient mongoClient = new MongoClient("localhost",27017);
            DB db=mongoClient.getDB("BlogProject"); 
            DBCollection collection=db.getCollection("articles");
            BasicDBObject doc = new BasicDBObject("articleId", articleId)
                                .append("articleTitle", articlePojoObject.getArticleTitle())
                                .append("articleContent", articlePojoObject.getArticleContent())
                                .append("articleAuthor", "TestUser");
            collection.insert(doc);
            
            DBObject dBObject=collection.findOne();
            System.out.println(dBObject);
            
            operationMessage="Yazınız Başarılı Bir Şekilde Kaydedildi :)";
            messageColor="green";
            articleId++;
            setRenderingMessage(true);
            /*DBCursor cursor = collection.find();
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
            BasicDBObject basicDBObject=new BasicDBObject();
            basicDBObject.put("name", "MongoDB");
            collection.remove(basicDBObject);*/
        } 
        catch (Exception e) 
        {
            operationMessage="Yazınızın Kaydı Sırasında Bir Hata Meydana Geldi!";
            messageColor="red";
            setRenderingMessage(true);
            System.err.println("Bir Hata Meydana Geldi!");
            System.out.println("Hata"+e);
        }
    }

    public String getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

    public boolean isRenderingMessage() {
        return renderingMessage;
    }

    public void setRenderingMessage(boolean renderingMessage) {
        this.renderingMessage = renderingMessage;
    }
}
