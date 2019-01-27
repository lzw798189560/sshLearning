package com.lzw.action;

import com.lzw.entity.User;
import com.lzw.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() throws Exception{
        if(userService.login(user)) {
            ActionContext.getContext().getSession()
                    .put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
