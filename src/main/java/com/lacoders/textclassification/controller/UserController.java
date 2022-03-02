package com.lacoders.textclassification.controller;

import com.lacoders.textclassification.bean.base.Result;
import com.lacoders.textclassification.bean.dto.*;
import com.lacoders.textclassification.bean.vo.AddOrUpdateUserVO;
import com.lacoders.textclassification.bean.vo.UserDetailVO;
import com.lacoders.textclassification.converter.UserConverter;
import com.lacoders.textclassification.dao.model.UserPO;
import com.lacoders.textclassification.service.UserOperateService;
import com.lacoders.textclassification.util.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Objects;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserOperateService userOperateService;

    //新增用户 ， 实现用户注册功能
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<AddOrUpdateUserVO> addUser(@RequestBody AddUserDTO addUserDTO) throws ParseException {
        UserPO userPO = UserConverter.convertAddDTO2PO(addUserDTO);
        Integer userId = userOperateService.addUser(userPO);
        AddOrUpdateUserVO addOrUpdateUser = new AddOrUpdateUserVO();
        addOrUpdateUser.setUserId(userId);
        addOrUpdateUser.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateUser);
    }

    //用户修改 , 实现用户更改密码功能
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Result<AddOrUpdateUserVO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) throws ParseException {
        if (Objects.isNull(updateUserDTO.getUserId())) {
            return ResultUtils.failResult(500,"编辑用户主键id不可为空");
        }
        UserPO userPO = UserConverter.convertUpdateDTO2PO(updateUserDTO);
        Integer userId = userOperateService.updateUser(userPO);
        AddOrUpdateUserVO addOrUpdateUserVO = new AddOrUpdateUserVO();
        addOrUpdateUserVO.setUserId(userId);
        addOrUpdateUserVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateUserVO);
    }

    //查找用户
    @RequestMapping(value = "/queryUserDetail", method = RequestMethod.GET)
    public Result<UserDetailVO> queryUserDetail(@RequestParam("userId") Integer userId) {
        if (Objects.isNull(userId)) {
            return ResultUtils.failResult(500,"查看用户详情主键id不可为空");
        }
        UserPO userPO = userOperateService.queryDetailById(userId);
        if (Objects.isNull(userPO)) {
            return ResultUtils.successMsg(null, "不存在该用户");
        }
        return ResultUtils.successResult(UserConverter.convertPO2DetailVO(userPO));
    }

    //删除用户
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Result<AddOrUpdateUserVO> deleteUser(@RequestBody DeleteUserDTO deleteUserDTO) {
        if (Objects.isNull(deleteUserDTO.getUserId())) {
            return ResultUtils.failResult(500,"删除新闻主键id不可为空");
        }
        Integer userId = deleteUserDTO.getUserId();
        UserPO userPO = buildDeletedUserPO(userId);
        userOperateService.updateUser(userPO);
        AddOrUpdateUserVO addOrUpdateUserVO = new AddOrUpdateUserVO();
        addOrUpdateUserVO.setUserId(userId);
        addOrUpdateUserVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateUserVO);
    }

    //删除用户 ，假删除
    private UserPO buildDeletedUserPO(Integer userId) {
        UserPO userPO = new UserPO();
        userPO.setUserId(userId);
        userPO.setDeleted(1);
        return userPO;
    }

}