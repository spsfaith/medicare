/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Login;
import Service.LoginService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.Cookie;

/**
 *
 * @author Samaya
 */
@Controller
@RequestMapping("/loginform.htm")
public class LoginController {

    Connection connection;
    
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap modelMap) {
        Login login = new Login();
        modelMap.addAttribute("login", login);
        return "loginForm";
    }
    
    

    @RequestMapping(method = RequestMethod.POST)

    public String loginUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("login") Login login, BindingResult result,
            ModelMap modelMap) {
        String username = login.getUsername();
        String password = login.getPassword();
              
            LoginService loginService = new LoginService();
                    boolean res = loginService.checkLogin(username, password);
                    if(res)
                    {
                        
                        
                        boolean profile = loginService.checkProfile(username);
                        if(profile)
                        {  
                        modelMap.addAttribute("username", username);
                        
                        HttpSession session = request.getSession();
                        String user = request.getParameter("username");
                        
                        session.setAttribute("user", username);
                        session.setAttribute("profile", new Boolean(true));
                        session.setMaxInactiveInterval(1*60);
                        return "index";
                        }
                        else
                        {
                            modelMap.addAttribute("username", username);
                        
                        HttpSession session = request.getSession();
                        String user = request.getParameter("username");
                        
                        session.setAttribute("user", username);
                        session.setAttribute("profile", new Boolean(false));
                        session.setMaxInactiveInterval(1*60);
                        return "index";
                        }
                    }
              
            return "loginForm";
        
    }
        
}
