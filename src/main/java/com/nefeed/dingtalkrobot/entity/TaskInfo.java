package com.nefeed.dingtalkrobot.entity;

public class TaskInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.task_id
     *
     * @mbg.generated
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.robot_id
     *
     * @mbg.generated
     */
    private Integer robotId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.task_name
     *
     * @mbg.generated
     */
    private String taskName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.task_content
     *
     * @mbg.generated
     */
    private String taskContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.run_times
     *
     * @mbg.generated
     */
    private Integer runTimes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.expect_run_time
     *
     * @mbg.generated
     */
    private Integer expectRunTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.schedule
     *
     * @mbg.generated
     */
    private String schedule;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.gmt_create
     *
     * @mbg.generated
     */
    private Integer gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.gmt_modify
     *
     * @mbg.generated
     */
    private Integer gmtModify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_info.del
     *
     * @mbg.generated
     */
    private Boolean del;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.task_id
     *
     * @return the value of task_info.task_id
     *
     * @mbg.generated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.task_id
     *
     * @param taskId the value for task_info.task_id
     *
     * @mbg.generated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.robot_id
     *
     * @return the value of task_info.robot_id
     *
     * @mbg.generated
     */
    public Integer getRobotId() {
        return robotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.robot_id
     *
     * @param robotId the value for task_info.robot_id
     *
     * @mbg.generated
     */
    public void setRobotId(Integer robotId) {
        this.robotId = robotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.task_name
     *
     * @return the value of task_info.task_name
     *
     * @mbg.generated
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.task_name
     *
     * @param taskName the value for task_info.task_name
     *
     * @mbg.generated
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.task_content
     *
     * @return the value of task_info.task_content
     *
     * @mbg.generated
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.task_content
     *
     * @param taskContent the value for task_info.task_content
     *
     * @mbg.generated
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.type
     *
     * @return the value of task_info.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.type
     *
     * @param type the value for task_info.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.run_times
     *
     * @return the value of task_info.run_times
     *
     * @mbg.generated
     */
    public Integer getRunTimes() {
        return runTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.run_times
     *
     * @param runTimes the value for task_info.run_times
     *
     * @mbg.generated
     */
    public void setRunTimes(Integer runTimes) {
        this.runTimes = runTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.expect_run_time
     *
     * @return the value of task_info.expect_run_time
     *
     * @mbg.generated
     */
    public Integer getExpectRunTime() {
        return expectRunTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.expect_run_time
     *
     * @param expectRunTime the value for task_info.expect_run_time
     *
     * @mbg.generated
     */
    public void setExpectRunTime(Integer expectRunTime) {
        this.expectRunTime = expectRunTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.schedule
     *
     * @return the value of task_info.schedule
     *
     * @mbg.generated
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.schedule
     *
     * @param schedule the value for task_info.schedule
     *
     * @mbg.generated
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.gmt_create
     *
     * @return the value of task_info.gmt_create
     *
     * @mbg.generated
     */
    public Integer getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.gmt_create
     *
     * @param gmtCreate the value for task_info.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Integer gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.gmt_modify
     *
     * @return the value of task_info.gmt_modify
     *
     * @mbg.generated
     */
    public Integer getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.gmt_modify
     *
     * @param gmtModify the value for task_info.gmt_modify
     *
     * @mbg.generated
     */
    public void setGmtModify(Integer gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_info.del
     *
     * @return the value of task_info.del
     *
     * @mbg.generated
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_info.del
     *
     * @param del the value for task_info.del
     *
     * @mbg.generated
     */
    public void setDel(Boolean del) {
        this.del = del;
    }
}