package it.gm.springboot.controller;

import it.gm.springboot.pojo.User;
import it.gm.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/addUser")
    public String addUser(User user){
        int i = this.userService.addUser(user);
        if (i > 0) {
            System.out.println("增加成功！");
            return "success";
        }else {
            System.out.println("增加失败");
            return "error";
        }
    }

    @RequestMapping("/delUser")
    public String delUser(int id){
        int result=this.userService.delUser(id);
        if (result > 0) {
            System.out.println("删除成功");
            return "success";
        }else{
            System.out.println("删除失败");
            return "error";
        }
    }

    @RequestMapping("/updUser")
    public String updUser(User user){
        int result=this.userService.updUser(user);
        if (result>0){
            System.out.println("修改成功");
            return "success";
        }else {
            System.out.println("修改失败");
            return "error";
        }
    }


    @ResponseBody
    @RequestMapping("/findUserAll")
    public ModelAndView findUserAll(){
        List<User> list=this.userService.findUserAll();
        for (User user:list
             ) {
            System.out.println(user.toString());

        }

        ModelAndView mv = new ModelAndView("select");
        mv.addObject("list",list);
        return mv;
    }


}
