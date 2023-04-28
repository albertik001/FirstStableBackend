package com.example.testbackendone.controller;

import com.example.testbackendone.dataparser.DataParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebDataController {

    private final DataParser dataParser;

    public WebDataController() {
        dataParser = new DataParser();
    }

    @GetMapping("/")
    public String showResults(Model model) {
        String url = "https://sumki-dina.com.ua/";
        String cssSelector = "a:nth-child(2n)";
        List<String> parsedData = dataParser.parseData(url, cssSelector);
        List<String> parsedDataSelenium = dataParser.parseDataWithSelenium(url);

        System.out.println("Parsed data size: " + parsedData.size() + parsedDataSelenium.toString());
        for (String data : parsedData) {
            System.out.println("Data: " + data);
        }
        for (String data : parsedDataSelenium) {
            System.out.println(data);
        }

        model.addAttribute("parsedData", parsedDataSelenium);
        return "results";
    }


}
