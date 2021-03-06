package com.nefeed.dingtalkrobot.dao;

import com.nefeed.dingtalkrobot.entity.TeamInfo;

import java.util.List;

public interface TeamInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer teamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    int insert(TeamInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    int insertSelective(TeamInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    TeamInfo selectByPrimaryKey(Integer teamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TeamInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TeamInfo record);

    /**
     * 遍历所有团队
     * @return 所有团队列表
     */
    List<TeamInfo> findAllTeams();
}