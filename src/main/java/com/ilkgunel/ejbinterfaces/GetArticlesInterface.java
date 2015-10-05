package com.ilkgunel.ejbinterfaces;
import com.ilkgunel.pojo.ArticlePojo;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by ilkaygunel on 05/10/15.
 */
@Local
public interface GetArticlesInterface {
    public List<ArticlePojo> getArtciles();
}
