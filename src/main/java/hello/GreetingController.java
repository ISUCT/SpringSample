package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by jskonst on 14.03.17.
 */
@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/calc")
    public String calculate(@RequestParam(value="a", required=false, defaultValue="0") String firstParam,
                            @RequestParam(value="b", required=false, defaultValue="0") String secondParam,
                            Model model) {
        int summ = Integer.parseInt(firstParam) + Integer.parseInt(secondParam);
        model.addAttribute("summ", summ);
        return "templsumm";
    }

    @RequestMapping("/user")
    public String calculate(@RequestParam(value="name", required=false, defaultValue="nope") String usr,Model model) {
        User user1 = new User();
        user1.setAge(10);
        user1.setId(5);
        user1.setName("Test1");
        User user2 = new User();
        user2.setAge(20);
        user2.setId(10);
        user2.setName("Test2");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        model.addAttribute("mdl", users);
        return "users";
    }


}
