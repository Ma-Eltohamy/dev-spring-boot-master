package com.mahmoud.constructorinjection.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
@Scope("prototype")
public class AFirstController {
    public AFirstController() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }
}
