package br.com.qpainformatica.qpabbb.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eabrahao on 17/09/15.
 */
public class Player {

    private int id;
    private String name;
    private String location;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("draftees_count")
    private int drafteesCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("likes_received_count")
    private int likesReceivedCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("comments_received_count")
    private int commentsReceivedCount;
    @SerializedName("rebounds_count")
    private int reboundsCount;
    @SerializedName("rebounds_received_count")
    private int reboundsReceivedCount;
    private String url;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String username;
    @SerializedName("twitter_screen_name")
    private String twitterScreenName;
    @SerializedName("website_url")
    private String websiteUrl;
    @SerializedName("drafted_by_player_id")
    private int draftedByPlayerId;
    @SerializedName("shots_count")
    private int shotsCount;
    @SerializedName("following_count")
    private int followingCount;
    @SerializedName("created_1at")
    private String createdAt;

    public Player() {
    }

    public Player(int id, String name, String location, int followersCount, int drafteesCount, int likesCount, int likesReceivedCount, int commentsCount, int commentsReceivedCount, int reboundsCount, int reboundsReceivedCount, String url, String avatarUrl, String username, String twitterScreenName, String websiteUrl, int draftedByPlayerId, int shotsCount, int followingCount, String createdAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.followersCount = followersCount;
        this.drafteesCount = drafteesCount;
        this.likesCount = likesCount;
        this.likesReceivedCount = likesReceivedCount;
        this.commentsCount = commentsCount;
        this.commentsReceivedCount = commentsReceivedCount;
        this.reboundsCount = reboundsCount;
        this.reboundsReceivedCount = reboundsReceivedCount;
        this.url = url;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.twitterScreenName = twitterScreenName;
        this.websiteUrl = websiteUrl;
        this.draftedByPlayerId = draftedByPlayerId;
        this.shotsCount = shotsCount;
        this.followingCount = followingCount;
        this.createdAt = createdAt;
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

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getDrafteesCount() {
        return drafteesCount;
    }

    public void setDrafteesCount(int drafteesCount) {
        this.drafteesCount = drafteesCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getLikesReceivedCount() {
        return likesReceivedCount;
    }

    public void setLikesReceivedCount(int likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getCommentsReceivedCount() {
        return commentsReceivedCount;
    }

    public void setCommentsReceivedCount(int commentsReceivedCount) {
        this.commentsReceivedCount = commentsReceivedCount;
    }

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public int getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }

    public void setReboundsReceivedCount(int reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public int getDraftedByPlayerId() {
        return draftedByPlayerId;
    }

    public void setDraftedByPlayerId(int draftedByPlayerId) {
        this.draftedByPlayerId = draftedByPlayerId;
    }

    public int getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
