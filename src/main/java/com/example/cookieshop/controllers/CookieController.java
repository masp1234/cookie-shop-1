package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Basket;
import com.example.cookieshop.models.Cookie;
import com.example.cookieshop.repositories.CookieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CookieController {
    CookieRepository repo = new CookieRepository();

    @GetMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("basket") == null) {
            session.setAttribute("basket", new Basket(new ArrayList<Cookie>()));
        }
        return "index";
    }

    @GetMapping("/basket")
    public String basket(HttpSession session, Model model){
        Basket basket = (Basket) session.getAttribute("basket");
        model.addAttribute("basket", basket.getCookieList());

        return "basket";
    }

    @GetMapping("/shop")
    public String shop(HttpSession session, Model cookieModel){
        cookieModel.addAttribute("cookies",repo.getAllCookies());
        return "shop";
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam int id, HttpSession session){

        // session.getAttribute giver en reference, så man behøver ikke setAttribute igen.
        // basket og session.getAttribute("basket") refererer til det samme.
        Basket basket = (Basket) session.getAttribute("basket");
        Cookie cookie = repo.getCookieById(id);
        basket.addCookie(cookie);


        return "redirect:/shop";
    }
}
