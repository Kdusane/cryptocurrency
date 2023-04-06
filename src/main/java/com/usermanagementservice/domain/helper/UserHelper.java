package com.usermanagementservice.domain.helper;

import com.usermanagementservice.domain.enums.Role;
import com.usermanagementservice.domain.enums.Status;
import com.usermanagementservice.domain.requestDTOs.user.CreateUserRequestDto;
import com.usermanagementservice.domain.response.UserResponse;
import com.usermanagementservice.entity.Users;

public class UserHelper {

    private UserHelper() {
    }

    public static Users requestDtoToEntity(CreateUserRequestDto requestDto) {
        Users users = Users.builder().emailId(requestDto.getEmailId()).firstName(requestDto.getFirstName()).lastName(requestDto.getLastName()).mobileNumber(requestDto.getMobileNumber()).password(requestDto.getPassword()).quantity(requestDto.getQuantity()).role(Role.valueOf(requestDto.getRole())).status(Status.valueOf(requestDto.getStatus())).build();
        users.setId(requestDto.getId());
        return users;
    }

    public static UserResponse entityToResponse(Users users) {
        return UserResponse.builder().emailId(users.getEmailId()).firstName(users.getFirstName()).status(String.valueOf(users.getStatus())).id(users.getId()).mobileNumber(users.getMobileNumber()).role(String.valueOf(users.getRole())).quantity(users.getQuantity()).build();
    }
}
