package com.nefeed.dingtalkrobot.dao;

import com.nefeed.dingtalkrobot.entity.RobotInfo;

import java.util.List;

public interface RobotInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer robotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    int insert(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    int insertSelective(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    RobotInfo selectByPrimaryKey(Integer robotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RobotInfo record);

    /**
     * 遍历所有机器人
     * @return 所有团队列表
     */
    List<RobotInfo> findAllRobots();

    /**
     * 获取生效的机器人
     */
    RobotInfo selectActiveByPrimaryKey(Integer robotId);
}