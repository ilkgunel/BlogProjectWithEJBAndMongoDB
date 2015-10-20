/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.jsfbeans;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 *
 * @author ilkaygunel
 */
public class Test {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
            DB db=mongoClient.getDB("BlogProject");
            DBCollection collection=db.getCollection("articles");
            
        DBCursor cursor = collection.find();
            try {
               while(cursor.hasNext()) {
                   System.out.println(cursor.next());
               }
            } finally {
               cursor.close();
            }
    }
}
