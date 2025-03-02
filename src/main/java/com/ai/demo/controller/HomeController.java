package com.ai.demo.controller;

import com.ai.demo.dto.TemplateRequest;
import com.ai.demo.service.AiService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

    @Autowired
    private AiService aiService;
    private final List<String> userMessages = new ArrayList<>();
    private final List<String> aiMessages = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        updatePage(model);
        return "index";
    }

    @GetMapping("/chat")
    public String prompt(@ModelAttribute TemplateRequest tRequest, Model model)  {
        if(!Objects.isNull(tRequest)) {

            userMessages.add(tRequest.getRequest());
            String aiResponse = aiService.extractData(aiService.chat(tRequest.getRequest()));
            aiMessages.add(aiResponse);
        }
        updatePage(model);
        return "index";
    }

    public void updatePage(Model model) {
        model.addAttribute("aiMSG",aiMessages);
        model.addAttribute("userMSG",userMessages);
        model.addAttribute("tRequest", new TemplateRequest());
    }

}
