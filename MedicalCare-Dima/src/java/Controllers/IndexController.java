/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nucur
 */
@Controller
@RequestMapping("/index.htm")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap modelMap) {
        return "index";
    } 
}

