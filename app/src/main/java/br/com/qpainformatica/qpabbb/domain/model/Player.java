package br.com.qpainformatica.qpabbb.domain.model;

/**
 * Created by eabrahao on 17/09/15.
 */
public class Player {

private int id;
private String name;
private String location;
private int followers_count;
private int draftees_count;
private int likes_count;
private int likes_received_count;
private int comments_count;
private int comments_received_count;
private int rebounds_count;
private int rebounds_received_count;
private String url;
private String avatar_url;
private String username;
private String twitter_screen_name;
private String website_url;
private int drafted_by_player_id;
private int shots_count;
private int following_count;
private String created_at;

    public Player() {
    }

    public Player(int id, String name, String location, int followers_count, int draftees_count, int likes_count, int likes_received_count, int comments_count, int comments_received_count, int rebounds_count, int rebounds_received_count, String url, String avatar_url, String username, String twitter_screen_name, String website_url, int drafted_by_player_id, int shots_count, int following_count, String created_at) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.followers_count = followers_count;
        this.draftees_count = draftees_count;
        this.likes_count = likes_count;
        this.likes_received_count = likes_received_count;
        this.comments_count = comments_count;
        this.comments_received_count = comments_received_count;
        this.rebounds_count = rebounds_count;
        this.rebounds_received_count = rebounds_received_count;
        this.url = url;
        this.avatar_url = avatar_url;
        this.username = username;
        this.twitter_screen_name = twitter_screen_name;
        this.website_url = website_url;
        this.drafted_by_player_id = drafted_by_player_id;
        this.shots_count = shots_count;
        this.following_count = following_count;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getDraftees_count() {
        return draftees_count;
    }

    public void setDraftees_count(int draftees_count) {
        this.draftees_count = draftees_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getLikes_received_count() {
        return likes_received_count;
    }

    public void setLikes_received_count(int likes_received_count) {
        this.likes_received_count = likes_received_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getComments_received_count() {
        return comments_received_count;
    }

    public void setComments_received_count(int comments_received_count) {
        this.comments_received_count = comments_received_count;
    }

    public int getRebounds_count() {
        return rebounds_count;
    }

    public void setRebounds_count(int rebounds_count) {
        this.rebounds_count = rebounds_count;
    }

    public int getRebounds_received_count() {
        return rebounds_received_count;
    }

    public void setRebounds_received_count(int rebounds_received_count) {
        this.rebounds_received_count = rebounds_received_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTwitter_screen_name() {
        return twitter_screen_name;
    }

    public void setTwitter_screen_name(String twitter_screen_name) {
        this.twitter_screen_name = twitter_screen_name;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public int getDrafted_by_player_id() {
        return drafted_by_player_id;
    }

    public void setDrafted_by_player_id(int drafted_by_player_id) {
        this.drafted_by_player_id = drafted_by_player_id;
    }

    public int getShots_count() {
        return shots_count;
    }

    public void setShots_count(int shots_count) {
        this.shots_count = shots_count;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(int following_count) {
        this.following_count = following_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
