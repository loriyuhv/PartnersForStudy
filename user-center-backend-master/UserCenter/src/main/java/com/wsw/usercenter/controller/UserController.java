package com.wsw.usercenter.controller;

import com.wsw.usercenter.common.BaseResponse;
import com.wsw.usercenter.common.ErrorCode;
import com.wsw.usercenter.common.ResultUtils;
import com.wsw.usercenter.exception.BusinessException;
import com.wsw.usercenter.model.request.UserRegisterRequest;
import com.wsw.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户表现层
 * @author loriyuhv
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userRegisterRequest 用户注册请求参数
     * @return 响应结果
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        // 校验参数
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 规范写法 获取用户注册参数
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        // 判断参数是否为空
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 调用用户业务层处理
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);

        // 返回成功响应结果
        return ResultUtils.success(result);
    }
}
