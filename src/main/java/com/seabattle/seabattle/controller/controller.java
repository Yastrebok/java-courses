package com.seabattle.seabattle.controller;

import com.seabattle.seabattle.entity.Statistic;
import com.seabattle.seabattle.repository.FieldRepo;
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

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/main")
    public String getAllShips(Model model) {
        model.addAttribute("field", fieldRepo.getField());
        model.addAttribute("battlefield", fieldRepo.getBattlefield());
        model.addAttribute("statistics", Statistic.getStatistic());
        return "main";
    }

    @PostMapping("/main")
    public String takeShot(@ModelAttribute("x") String x, @ModelAttribute("y") Integer y, Model model) {
        shotService.takeShot(x, y);
        return "redirect:main";
    }

    @GetMapping("/reset")
    public String resetShips(){
        fieldRepo.resetShips();
        return "redirect:main";
    }


}
