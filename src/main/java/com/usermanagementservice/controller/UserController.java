package com.usermanagementservice.controller;

import com.usermanagementservice.domain.requestDTOs.user.CreateUserRequestDto;
import com.usermanagementservice.domain.requestDTOs.user.UpdateUserRequestDto;
import com.usermanagementservice.domain.response.BaseResponse;
import com.usermanagementservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<BaseResponse> createUser(@RequestBody @Valid CreateUserRequestDto resquestDtos){
        log.info("inside Create User"+resquestDtos);
        return ResponseEntity.ok().body(userService.saveToDb(resquestDtos));


    }
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> userById(@PathVariable UUID id){
        log.info("got user of "+id);
        return ResponseEntity.ok()
                .body(userService.findUserById(id));

    }
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> UpdateUserById( @RequestBody  UpdateUserRequestDto requestDto, @PathVariable UUID id){
        log.info("User Updated Successfully"+requestDto);
        return ResponseEntity.ok()
                .body(userService.updateUsers(requestDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> DeleteUserById(@PathVariable UUID id){
        log.info("User deleted Successfully" +id);
        return ResponseEntity.ok()
                .body(userService.deleteUserById(id));
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<BaseResponse> findAllUsers(){
        return ResponseEntity.ok()
                .body(userService.findAllUser());
    }



}
