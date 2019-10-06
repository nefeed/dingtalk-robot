package com.nefeed.dingtalkrobot.controller.base;

import com.alibaba.druid.util.StringUtils;
import com.nefeed.dingtalkrobot.enums.ResultCodeEnum;
import com.nefeed.dingtalkrobot.pojo.base.BaseResponse;
import com.nefeed.dingtalkrobot.pojo.base.BaseResult;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-06 11:42
 */
public class BaseController {

    /**
     * 组装失败结果
     *
     * @param resultCodeEnum 失败结果码
     * @return 失败结果
     */
    protected BaseResponse buildErrorResponse(ResultCodeEnum resultCodeEnum) {
        return buildErrorResponse(resultCodeEnum, null);
    }

    /**
     * 组装失败结果
     *
     * @param resultCodeEnum 失败结果码
     * @param errorMsg       失败描述
     * @return 失败结果
     */
    protected BaseResponse buildErrorResponse(ResultCodeEnum resultCodeEnum, String errorMsg) {
        BaseResponse errorResponse = new BaseResponse();
        errorResponse.setResult(buildErrorResult(resultCodeEnum, errorMsg));
        return errorResponse;
    }

    /**
     * 组装成功结果
     *
     * @param successResponse 成功结果
     */
    protected void initSuccessResponse(BaseResponse successResponse) {
        successResponse.setResult(buildSuccessResult());
    }

    /**
     * 构建失败结果
     *
     * @return 失败结果
     */
    protected BaseResult buildErrorResult(ResultCodeEnum resultCodeEnum, String errorMsg) {
        return buildBaseResult(false, resultCodeEnum, errorMsg);
    }

    /**
     * 构建成功结果
     *
     * @return 成功结果
     */
    protected BaseResult buildSuccessResult() {
        return buildBaseResult(true, null, null);
    }

    /**
     * 构建通用结果
     *
     * @param success        结果boolean
     * @param resultCodeEnum 结果码
     * @param errorMsg       结果秒数
     * @return 通用结果
     */
    private BaseResult buildBaseResult(boolean success, ResultCodeEnum resultCodeEnum, String errorMsg) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(success);
        if (success) {
            baseResult.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            baseResult.setResultMsg(ResultCodeEnum.SUCCESS.getDescription());
        } else {
            baseResult.setResultCode(resultCodeEnum.getCode());
            baseResult.setResultMsg(StringUtils.isEmpty(errorMsg) ? resultCodeEnum.getDescription() :
                    errorMsg);
        }
        return baseResult;
    }


}
