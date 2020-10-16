package com.seabattle.seabattle.controller;

import com.seabattle.seabattle.entity.Statistic;
import com.seabattle.seabattle.repository.FieldRepo;
import com.seabattle.seabattle.repository.ShipRepo;
import com.seabattle.seabattle.service.Shot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class controller {


    @Autowired
    private FieldRepo fieldRepo;

    @Autowired
    private Shot shotService;

    @Autowired
    ShipRepo shipRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/main")
    public String getAllShips(Model model) {
        model.addAttribute("battlefield", fieldRepo.getBattlefield());
        model.addAttribute("ships", shipRepo.getShips());
        model.addAttribute("statistics", Statistic.getStatistic());
        return "main";
    }

    @PostMapping("/main")
    public String takeShot(@ModelAttribute("x") String x, @ModelAttribute("y") Integer y, Model model) {
        //TODO event handler nullable params
        //information windows
        //check when empty attribute
        //return prev. shot's point
        shotService.takeShot(x, y);
        return "redirect:main";
    }

    @GetMapping("/reset")
    public String resetShips(){
        fieldRepo.resetFields();
        return "redirect:main";
    }


}
