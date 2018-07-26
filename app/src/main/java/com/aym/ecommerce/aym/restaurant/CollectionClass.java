package com.aym.ecommerce.aym.restaurant;

/**
 * Created by mani on 26/07/2018.
 */

public class CollectionClass {

    int collection_id;
    int res_count;
    String image_url;
    String url;
    String title;
    String description;
    String share_url;

    public CollectionClass(int collection_id, int res_count, String image_url, String url, String title, String description, String share_url){

        this.collection_id = collection_id;
        this.res_count = res_count;
        this.image_url = image_url;
        this.url = url;
        this.title = title;
        this.description = description;
        this.share_url = share_url;
    }

    public int getRes_count() {
        return res_count;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setRes_count(int res_count) {
        this.res_count = res_count;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
