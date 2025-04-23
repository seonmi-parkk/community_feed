package org.comunity.user.ui;

import lombok.RequiredArgsConstructor;
import org.comunity.common.ui.Response;
import org.comunity.user.application.UserService;
import org.comunity.user.application.dto.CreateUserRequestDto;
import org.comunity.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 응답값을 통일시켜서 반환 (정해져 있는 응답 인터페이스 형태를 맞춰주면 좋음)
    @PostMapping
    public Response<Long> creatUser(@RequestBody CreateUserRequestDto dto){
        User user = userService.createUser(dto);
        return Response.ok(user.getId());
    }
}
