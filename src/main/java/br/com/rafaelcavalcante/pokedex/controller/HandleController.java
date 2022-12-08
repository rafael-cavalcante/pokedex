package br.com.rafaelcavalcante.pokedex.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class HandleController implements ErrorController {

    @GetMapping
    private String errorHandle(HttpServletRequest request, Model model){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Class<?> exceotionType = (Class<?>) request.getAttribute("javax.servlet.error.exception_type");
        String erroMensage = (String) request.getAttribute("javax.servlet.error.message");
        String requentURI = (String) request.getAttribute("javax.servlet.error.request_uri");
        String serveletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("exception", exception);

        System.out.println(statusCode);

        switch (statusCode){
            case 404:
                return "erros/404";
            case 500:
                return "error2";
            default:
                return "erros/404";
        }
    }

}
