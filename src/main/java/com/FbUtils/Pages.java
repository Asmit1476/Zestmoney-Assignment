package com.FbUtils;

import com.FBLoginAndPost.FBLoginAndPost;

import com.FbUtils.utils.Base;

public class Pages {

    private static <T extends Base> T getPage(Class<T> pageType) {
        T page;
        try {
            page = pageType.newInstance();
        } catch (InstantiationException e) { //make sure you use JDK 1.7
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return page;
    }




    public static FBLoginAndPost FBLoginAndPost() {return getPage(FBLoginAndPost.class);}






}
