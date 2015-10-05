package com.ilkgunel.ejbclasses;

import com.ilkgunel.ejbinterfaces.GetArticlesInterface;
import com.ilkgunel.pojo.ArticlePojo;
import com.mongodb.*;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilkaygunel on 05/10/15.
 */
@Stateless
public class GetArticlesEjbBean implements GetArticlesInterface{

    public List<ArticlePojo> getArtciles() {
        ArticlePojo articlePojo;
        List<ArticlePojo> articleList=new ArrayList<ArticlePojo>();
        try
        {
            MongoClient mongoClient = new MongoClient("localhost",27017);
            DB db=mongoClient.getDB("BlogProject");
            DBCollection collection=db.getCollection("articles");
            /*BasicDBObject doc = new BasicDBObject("articleId", "1")
                    .append("articleTitle", "JSF Nedir? Giriş")
                    .append("articleContent", "JSF Nedir? JSF Javanın Standart Web Çatısıdır. Bileşen Tabanlıdır. 3.parti kütüphanelerle desteklenir. ")
                    .append("articleAuthor", "İlkay Günel");
            collection.insert(doc);

            DBObject dBObject=collection.findOne();
            System.out.println(dBObject);*/

            DBCursor cursor = collection.find();
            try {
                while(cursor.hasNext())
                {
                    DBObject dbObject=cursor.next();

                    articlePojo=new ArticlePojo();
                    articlePojo.setArticleId(Integer.parseInt(dbObject.get("articleId").toString()));
                    articlePojo.setArticleTitle(dbObject.get("articleTitle").toString());
                    articlePojo.setArticleAuthor(dbObject.get("articleAuthor").toString());
                    articlePojo.setArticleContent(dbObject.get("articleContent").toString());
                    articleList.add(articlePojo);
                }
            }
            finally
            {
                cursor.close();
            }
               /*
            BasicDBObject basicDBObject=new BasicDBObject();
            basicDBObject.put("name", "MongoDB");
            collection.remove(basicDBObject);*/
        }
        catch (Exception e)
        {
            System.err.println("Bir Hata Meydana Geldi!"+e);
        }
        return articleList;
    }
}
