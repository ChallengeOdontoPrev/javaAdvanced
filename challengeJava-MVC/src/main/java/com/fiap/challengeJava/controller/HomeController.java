package com.fiap.challengeJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(Model model) {
        return new ModelAndView("home");
    }

    @PostMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("home");
    }

    @PostMapping("/cadastro-atendente")
    public ModelAndView cadastroAtendente(Model model) {
        return new ModelAndView("cadastro-atendente");
    }

    @PostMapping("/cadastro-dentista")
    public ModelAndView cadastroDentista(Model model) {
        return new ModelAndView("cadastro-dentista");
    }

    @PostMapping("/login")
    public ModelAndView login(Model model) {
        return new ModelAndView("login");
    }

}

