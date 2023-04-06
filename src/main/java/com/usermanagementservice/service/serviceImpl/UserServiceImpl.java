package com.usermanagementservice.service.serviceImpl;

import com.usermanagementservice.constants.ConstantUtils;
import com.usermanagementservice.domain.helper.UserHelper;
import com.usermanagementservice.domain.requestDTOs.user.CreateUserRequestDto;
import com.usermanagementservice.domain.requestDTOs.user.UpdateUserRequestDto;
import com.usermanagementservice.domain.response.BaseResponse;
import com.usermanagementservice.domain.response.UserResponse;
import com.usermanagementservice.entity.Users;
import com.usermanagementservice.exception.NotFoundException;
import com.usermanagementservice.exception.ValidationException;
import com.usermanagementservice.repository.UserRespository;
import com.usermanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRespository userRespository;

    @Override
    public BaseResponse saveToDb(CreateUserRequestDto requestDto) {
        Optional<Users> userById = userRespository.findById(requestDto.getId());
        if (userById.isPresent()) {
            throw new ValidationException(ConstantUtils.USER_ALREADY_EXIST);
        } else {
            Users users = UserHelper.requestDtoToEntity(requestDto);
            userRespository.save(users);
            UserResponse response = UserHelper.entityToResponse(users);
            return new BaseResponse(HttpStatus.CREATED.value(), ConstantUtils.USER_CREATED_SUCCESSFULLY,ConstantUtils.USER_CREATED_SUCCESSFULLY,response,null);
        }

    }

    @Override
    public BaseResponse findUserById(UUID id) {
        Optional<Users> user = userRespository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(ConstantUtils.USER_NOT_FOUND);
        } else {
            return new BaseResponse(HttpStatus.OK.value(),ConstantUtils.USER_RETRIEVE_SUCCESSFULLY,ConstantUtils.USER_RETRIEVE_SUCCESSFULLY,user.get(),null);
        }
    }

    @Override
    public BaseResponse findAllUser() {
        List<Users> userlist = userRespository.findAll();
        return new BaseResponse(HttpStatus.OK.value(),ConstantUtils.USER_RETRIEVE_SUCCESSFULLY,ConstantUtils.USER_RETRIEVE_SUCCESSFULLY,userlist,null);
    }

    @Override
    public BaseResponse updateUsers(UpdateUserRequestDto requestDto, UUID id) {
        Optional<Users> user = userRespository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(ConstantUtils.USER_NOT_FOUND);
        } else {
            updateUser(user.get(), requestDto);
            UserResponse response = UserHelper.entityToResponse(user.get());
            return new BaseResponse(HttpStatus.OK.value(),ConstantUtils.USER_UPDATE_SUCCESSFULLY,ConstantUtils.USER_UPDATE_SUCCESSFULLY,response,null);
        }
    }

    @Override
    public BaseResponse deleteUserById(UUID id) {
        Optional<Users> user = userRespository.findById(id);
        userRespository.delete(user.get());
        return new BaseResponse(HttpStatus.OK.value(),ConstantUtils.USER_DELETED_SUCCESSFULLY,ConstantUtils.USER_DELETED_SUCCESSFULLY,user.get(),null);
    }

    private Users updateUser(Users users, UpdateUserRequestDto requestDto) {
        if (!Objects.isNull(requestDto.getFirstName()) && !requestDto.getFirstName().isEmpty()) {
            users.setFirstName(requestDto.getFirstName());
        }
        if (!Objects.isNull(requestDto.getLastName()) && !requestDto.getLastName().isEmpty()) {
            users.setLastName(requestDto.getLastName());
        }
        if (!Objects.isNull(requestDto.getMobileNumber()) && !requestDto.getMobileNumber().isEmpty()) {
            users.setMobileNumber(requestDto.getMobileNumber());
        }
        if (!Objects.isNull(requestDto.getMobileNumber()) && !requestDto.getMobileNumber().isEmpty()) {
            users.setMobileNumber(requestDto.getMobileNumber());
        }
        if (!Objects.isNull(requestDto.getEmailId()) && !requestDto.getEmailId().isEmpty()) {
            users.setEmailId(requestDto.getEmailId());
        }

        return userRespository.save(users);
    }
}
