package com.nefeed.dingtalkrobot.entity;

public class CronInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cron_info.cron_id
     *
     * @mbg.generated
     */
    private Integer cronId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cron_info.cron
     *
     * @mbg.generated
     */
    private String cron;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cron_info.gmt_create
     *
     * @mbg.generated
     */
    private Integer gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cron_info.gmt_modify
     *
     * @mbg.generated
     */
    private Integer gmtModify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cron_info.del
     *
     * @mbg.generated
     */
    private Boolean del;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cron_info.cron_id
     *
     * @return the value of cron_info.cron_id
     *
     * @mbg.generated
     */
    public Integer getCronId() {
        return cronId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cron_info.cron_id
     *
     * @param cronId the value for cron_info.cron_id
     *
     * @mbg.generated
     */
    public void setCronId(Integer cronId) {
        this.cronId = cronId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cron_info.cron
     *
     * @return the value of cron_info.cron
     *
     * @mbg.generated
     */
    public String getCron() {
        return cron;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cron_info.cron
     *
     * @param cron the value for cron_info.cron
     *
     * @mbg.generated
     */
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cron_info.gmt_create
     *
     * @return the value of cron_info.gmt_create
     *
     * @mbg.generated
     */
    public Integer getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cron_info.gmt_create
     *
     * @param gmtCreate the value for cron_info.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Integer gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cron_info.gmt_modify
     *
     * @return the value of cron_info.gmt_modify
     *
     * @mbg.generated
     */
    public Integer getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cron_info.gmt_modify
     *
     * @param gmtModify the value for cron_info.gmt_modify
     *
     * @mbg.generated
     */
    public void setGmtModify(Integer gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cron_info.del
     *
     * @return the value of cron_info.del
     *
     * @mbg.generated
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cron_info.del
     *
     * @param del the value for cron_info.del
     *
     * @mbg.generated
     */
    public void setDel(Boolean del) {
        this.del = del;
    }
}