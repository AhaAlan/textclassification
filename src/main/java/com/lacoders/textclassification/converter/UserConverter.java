package com.lacoders.textclassification.converter;

import com.lacoders.textclassification.bean.dto.AddUserDTO;
import com.lacoders.textclassification.bean.dto.UpdateUserDTO;
import com.lacoders.textclassification.bean.vo.UserDetailVO;
import com.lacoders.textclassification.dao.model.UserPO;
import java.text.ParseException;
import java.util.Objects;

public class UserConverter {
    public static UserPO convertAddDTO2PO(AddUserDTO dto) throws ParseException {
        UserPO userPO = new UserPO();
        userPO.setUserName(dto.getUserName());
        userPO.setUserPassword(dto.getUserPassword());
        userPO.setDeleted(dto.getDeleted());
        return userPO;
    }

    public static UserPO convertUpdateDTO2PO(UpdateUserDTO dto) throws ParseException {
        UserPO userPO = new UserPO();
        userPO.setUserId(dto.getUserId());
        userPO.setUserName(dto.getUserName());
        userPO.setUserPassword(dto.getUserPassword());
        userPO.setDeleted(dto.getDeleted());
        return userPO;
    }

    public static UserDetailVO convertPO2DetailVO(UserPO userPO) {
        if (Objects.isNull(userPO)) {
            return null;
        }
        UserDetailVO userDetailVO = new UserDetailVO();
        userDetailVO.setUserId(userPO.getUserId());
        userDetailVO.setUserName(userPO.getUserName());
        userDetailVO.setUserPassword(userDetailVO.getUserPassword());
        userDetailVO.setDeleted(userDetailVO.getDeleted());
        return userDetailVO;

    }

}
