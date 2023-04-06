package com.usermanagementservice.service;

import com.usermanagementservice.domain.requestDTOs.user.CreateUserRequestDto;
import com.usermanagementservice.domain.requestDTOs.user.UpdateUserRequestDto;
import com.usermanagementservice.domain.response.BaseResponse;

import java.util.UUID;

public interface UserService {
    BaseResponse saveToDb(CreateUserRequestDto resquestDto);

    BaseResponse findUserById(UUID id);

    BaseResponse findAllUser();

    BaseResponse updateUsers(UpdateUserRequestDto requestDto, UUID id);

    BaseResponse deleteUserById(UUID id);


}
