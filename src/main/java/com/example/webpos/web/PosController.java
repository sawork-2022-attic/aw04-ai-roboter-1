package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class PosController {

    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    private PosService posService;

    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/")
    public String pos(Model model) {
        request.getSession(true);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", cart);
        return "index";
    }

    @GetMapping("/add")
    public String addByGet(@RequestParam(name = "pid") String pid, Model model) {

        posService.add(cart, pid, 1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", cart);
        return "index";
    }
}
