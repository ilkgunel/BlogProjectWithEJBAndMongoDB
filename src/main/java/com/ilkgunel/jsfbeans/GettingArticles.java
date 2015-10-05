package com.ilkgunel.jsfbeans;

/**
 * Created by ilkaygunel on 13/09/15.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilkaygunel
 */


import com.ilkgunel.ejbinterfaces.GetArticlesInterface;
import com.mongodb.*;

import com.ilkgunel.pojo.ArticlePojo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class GettingArticles implements Serializable{

    @EJB
    private GetArticlesInterface getArticlesInterfaceObject;

    public  List<ArticlePojo> getArtciles() {
        return getArticlesInterfaceObject.getArtciles();
    }
}
