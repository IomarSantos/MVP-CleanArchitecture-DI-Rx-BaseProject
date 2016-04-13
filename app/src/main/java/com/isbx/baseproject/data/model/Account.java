
package com.isbx.baseproject.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("mediaId")
    @Expose
    private Integer mediaId;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("realm")
    @Expose
    private String realm;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("emailVerified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("verificationToken")
    @Expose
    private String verificationToken;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    private Account(Builder builder) {
        setEmail(builder.email);
        password = builder.password;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     * The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     * The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     * The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     * The mediaId
     */
    public Integer getMediaId() {
        return mediaId;
    }

    /**
     *
     * @param mediaId
     * The mediaId
     */
    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The realm
     */
    public String getRealm() {
        return realm;
    }

    /**
     *
     * @param realm
     * The realm
     */
    public void setRealm(String realm) {
        this.realm = realm;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The emailVerified
     */
    public Boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     *
     * @param emailVerified
     * The emailVerified
     */
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     *
     * @return
     * The verificationToken
     */
    public String getVerificationToken() {
        return verificationToken;
    }

    /**
     *
     * @param verificationToken
     * The verificationToken
     */
    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     *
     * @param lastUpdated
     * The lastUpdated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    public static final class Builder {
        private String email;
        private String password;

        public Builder() {
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}