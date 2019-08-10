package com.yjp.mybatisplus.controller.tb;

import com.yjp.mybatisplus.core.AuthorizedUser;
import com.yjp.mybatisplus.core.Result;
import com.yjp.mybatisplus.param.LoginParam;
import com.yjp.mybatisplus.service.tb.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/tb/login")
@Api(value = "用户登录")
public class LoginController {
    @Autowired
    private ILoginService iLoginService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/userLogin")
    public Result userLogin(@RequestHeader HttpHeaders headers, @RequestBody @Valid LoginParam loginParam) {
        AuthorizedUser authorizedUser = iLoginService.userLogin(headers, loginParam);
        return Result.quickOK(authorizedUser);
    }

    @PostMapping("/userLogout")
    public Result userLogout(@RequestHeader HttpHeaders headers) {
        String success = iLoginService.userLogout(headers);
        return Result.quickOK(success);
    }
}
