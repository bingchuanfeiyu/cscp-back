package com.cscp.userServer.controller;

import com.cscp.common.security.TokenExtractService;
import com.cscp.common.security.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author chen kezhuo
 * @discription
 * @date 2020/3/6 - 12:17
 */
@RestController
public class TestController {
    @Autowired
    TokenExtractService tokenExtractService;

    @RequestMapping("/getUID")
    public String getUID(HttpServletRequest httpServletRequest) {
        return tokenExtractService.currentUserId(httpServletRequest);
    }


    @RequestMapping("/getUID2")
    public String getUID2(Authentication authentication) {
        return UserInfoUtil.getUID(authentication);
    }
}
