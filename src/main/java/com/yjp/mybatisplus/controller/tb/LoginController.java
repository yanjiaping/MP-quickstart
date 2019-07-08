package com.yjp.mybatisplus.controller.tb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.mybatisplus.core.AuthorizedUser;
import com.yjp.mybatisplus.core.Result;
import com.yjp.mybatisplus.param.LoginParam;
import com.yjp.mybatisplus.service.tb.ILoginService;

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
public class LoginController {
	@Autowired
	private ILoginService iLoginService;

	@PostMapping("/userLogin")
	private Result userlogin(@RequestHeader HttpHeaders headers, @RequestBody @Valid LoginParam loginParam) {
		AuthorizedUser authorizedUser = iLoginService.userLogin(headers, loginParam);
		return Result.quickOK(authorizedUser);
	}

	@PostMapping("/userLogout")
	private Result userLogout(@RequestHeader HttpHeaders headers) {
		String success = iLoginService.userLogout(headers);
		return Result.quickOK(success);
	}
}
