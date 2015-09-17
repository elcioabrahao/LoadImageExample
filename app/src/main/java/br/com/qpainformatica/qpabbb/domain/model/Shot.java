package br.com.qpainformatica.qpabbb.domain.model;

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
    private String short_url;
    private int views_count;
    private String rebound_source_id;
    private String image_url;
    private String image_teaser_url;
    private String image_400_url;
    private Player player;
    private String created_at;

    public Shot() {
    }

    public Shot(long id, String title, String description, int height, int width, int likes_count, int comments_count, int rebounds_count, String url, String short_url, int views_count, String rebound_source_id, String image_url, String image_teaser_url, String image_400_url, Player player, String created_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.height = height;
        this.width = width;
        this.likes_count = likes_count;
        this.comments_count = comments_count;
        this.rebounds_count = rebounds_count;
        this.url = url;
        this.short_url = short_url;
        this.views_count = views_count;
        this.rebound_source_id = rebound_source_id;
        this.image_url = image_url;
        this.image_teaser_url = image_teaser_url;
        this.image_400_url = image_400_url;
        this.player = player;
        this.created_at = created_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public String getRebound_source_id() {
        return rebound_source_id;
    }

    public void setRebound_source_id(String rebound_source_id) {
        this.rebound_source_id = rebound_source_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_teaser_url() {
        return image_teaser_url;
    }

    public void setImage_teaser_url(String image_teaser_url) {
        this.image_teaser_url = image_teaser_url;
    }

    public String getImage_400_url() {
        return image_400_url;
    }

    public void setImage_400_url(String image_400_url) {
        this.image_400_url = image_400_url;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
