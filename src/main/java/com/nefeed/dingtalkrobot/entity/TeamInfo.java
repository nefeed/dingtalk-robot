package com.nefeed.dingtalkrobot.entity;

public class TeamInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.team_id
     *
     * @mbg.generated
     */
    private Integer teamId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.team_name
     *
     * @mbg.generated
     */
    private String teamName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.creator_user_id
     *
     * @mbg.generated
     */
    private Integer creatorUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.team_avatar
     *
     * @mbg.generated
     */
    private String teamAvatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.gmt_create
     *
     * @mbg.generated
     */
    private Integer gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.gmt_modify
     *
     * @mbg.generated
     */
    private Integer gmtModify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_info.del
     *
     * @mbg.generated
     */
    private Boolean del;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.team_id
     *
     * @return the value of team_info.team_id
     *
     * @mbg.generated
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.team_id
     *
     * @param teamId the value for team_info.team_id
     *
     * @mbg.generated
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.team_name
     *
     * @return the value of team_info.team_name
     *
     * @mbg.generated
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.team_name
     *
     * @param teamName the value for team_info.team_name
     *
     * @mbg.generated
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.creator_user_id
     *
     * @return the value of team_info.creator_user_id
     *
     * @mbg.generated
     */
    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.creator_user_id
     *
     * @param creatorUserId the value for team_info.creator_user_id
     *
     * @mbg.generated
     */
    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.team_avatar
     *
     * @return the value of team_info.team_avatar
     *
     * @mbg.generated
     */
    public String getTeamAvatar() {
        return teamAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.team_avatar
     *
     * @param teamAvatar the value for team_info.team_avatar
     *
     * @mbg.generated
     */
    public void setTeamAvatar(String teamAvatar) {
        this.teamAvatar = teamAvatar == null ? null : teamAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.status
     *
     * @return the value of team_info.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.status
     *
     * @param status the value for team_info.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.gmt_create
     *
     * @return the value of team_info.gmt_create
     *
     * @mbg.generated
     */
    public Integer getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.gmt_create
     *
     * @param gmtCreate the value for team_info.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Integer gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.gmt_modify
     *
     * @return the value of team_info.gmt_modify
     *
     * @mbg.generated
     */
    public Integer getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.gmt_modify
     *
     * @param gmtModify the value for team_info.gmt_modify
     *
     * @mbg.generated
     */
    public void setGmtModify(Integer gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_info.del
     *
     * @return the value of team_info.del
     *
     * @mbg.generated
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_info.del
     *
     * @param del the value for team_info.del
     *
     * @mbg.generated
     */
    public void setDel(Boolean del) {
        this.del = del;
    }
}