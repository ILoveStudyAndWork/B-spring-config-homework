package com.thoughtworks.capability.gtb.demospringconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@RestController
public class LevelController {

    @Autowired
    private Environment env;

    @GetMapping("/level")
    public String getLevel() {
        int levelNumber = Integer.parseInt(Objects.requireNonNull(env.getProperty("levelNumber")));
        return levelNumber < 1 ? "basic" : "advanced";
    }

}
