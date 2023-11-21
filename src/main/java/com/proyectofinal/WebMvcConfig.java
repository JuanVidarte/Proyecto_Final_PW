package com.proyectofinal;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The {@code WebMvcConfig} class is a configuration class that implements {@code WebMvcConfigurer}
 * to customize Spring MVC behavior. In this class, a custom formatter, {@code LocalDateTimeFormatter},
 * is registered with the {@code FormatterRegistry} to handle the formatting and parsing of
 * {@code LocalDateTime} objects in the web application.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * Adds custom formatters to the {@code FormatterRegistry}.
     *
     * @param registry The {@code FormatterRegistry} used to register formatters.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Register the custom LocalDateTimeFormatter with a specific date-time pattern.
        registry.addFormatter(new LocalDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
    }
}