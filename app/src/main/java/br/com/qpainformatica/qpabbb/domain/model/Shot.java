package br.com.qpainformatica.qpabbb.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eabrahao on 17/09/15.
 */
public class Shot {

    private long id;
    private String title;
    private String description;
    private int height;
    private int width;


    private int likes_count;
    private int comments_count;
    private int rebounds_count;
    private String url;
    @SerializedName("short_url")
    private String shortUrl;
    @SerializedName("views_count")
    private int viewsCount;
    @SerializedName("rebound_source_id")
    private String reboundSourceId;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("image_teaser_url")
    private String imageTeaserUrl;
    @SerializedName("image_400_url")
    private String image400Url;
    private Player player;
    @SerializedName("created_at")
    private String createdAt;

    public Shot() {
    }

    public Shot(long id, String title, String description, int height, int width, int likes_count, int comments_count, int rebounds_count, String url, String shortUrl, int viewsCount, String reboundSourceId, String imageUrl, String imageTeaserUrl, String image400Url, Player player, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.height = height;
        this.width = width;
        this.likes_count = likes_count;
        this.comments_count = comments_count;
        this.rebounds_count = rebounds_count;
        this.url = url;
        this.shortUrl = shortUrl;
        this.viewsCount = viewsCount;
        this.reboundSourceId = reboundSourceId;
        this.imageUrl = imageUrl;
        this.imageTeaserUrl = imageTeaserUrl;
        this.image400Url = image400Url;
        this.player = player;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRebounds_count() {
        return rebounds_count;
    }

    public void setRebounds_count(int rebounds_count) {
        this.rebounds_count = rebounds_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getReboundSourceId() {
        return reboundSourceId;
    }

    public void setReboundSourceId(String reboundSourceId) {
        this.reboundSourceId = reboundSourceId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTeaserUrl() {
        return imageTeaserUrl;
    }

    public void setImageTeaserUrl(String imageTeaserUrl) {
        this.imageTeaserUrl = imageTeaserUrl;
    }

    public String getImage400Url() {
        return image400Url;
    }

    public void setImage400Url(String image400Url) {
        this.image400Url = image400Url;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
