package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@ResponseBody
public class SkillsController {


    @RequestMapping("/")
    public String main () {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have some skills we would like to learn!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }
    @GetMapping("form")
    public String skillsForm() {
        return "<html>" +
                "<body>" +
                "<form action='skillsTracker' method='get'>" +
                "<label for='name'>Name: </label>" +
                "<br>" +
                "<input type='text' name='name' id='name'>" +
                "<hr>" +
                "<br>" +

                "<label for='favorite'>My favorite language: </label>" +
                "<br>" +
                "<select name='favorite' id='favorite'>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value ='Java'>Java</option>" +
                "<option value ='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<hr>" +

                "<label for='secondFavorite'>My second favorite language: </label>" +
                "<br>" +
                "<select name='secondFavorite' id='secondFavorite'>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value ='Java'>Java</option>" +
                "<option value ='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<hr>" +

                "<label for='thirdFavorite'>My third favorite language: </label>" +
                "<br>" +
                "<select name='thirdFavorite' id='thirdFavorite'>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value ='Java'>Java</option>" +
                "<option value ='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<hr>" +
                "<input type='submit' value='Submit'>" +

                "</form>" +
                "</body>" +
                "</html>";

    }

    @RequestMapping(value="skillsTracker", method = RequestMethod.GET)
    @ResponseBody
    public String skillsTracker(@RequestParam String name,
                                @RequestParam String favorite,
                                @RequestParam String secondFavorite,
                                @RequestParam String thirdFavorite) {
        if (name == "") {
            name = "Butts";
        }
        if (favorite == null) {
            favorite = "farts";
        }
        if (secondFavorite == null) {
            secondFavorite = "fizzlers";
        }
        if (thirdFavorite == null) {
            thirdFavorite = "crack splitter";
        }
        //add validation to make sure they cannot pick the same language more than once
        return submitForm(name, favorite, secondFavorite, thirdFavorite);
}

public static String submitForm(String n, String l1, String l2, String l3) {
        return "<html>" +
                "<body>" +
                "<h1>" + n + "</h1>" +
                "<ol>" +
                "<li>" + l1 + "</li>" +
                "<li>" + l2 + "</li>" +
                "<li>" + l3 + "</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }
}
