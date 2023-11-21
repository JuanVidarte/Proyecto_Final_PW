package com.proyectofinal;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The {@code LocalDateTimeFormatter} class is a custom Spring {@code Formatter} implementation
 * for formatting and parsing {@code LocalDateTime} objects using a specified {@code DateTimeFormatter}.
 * This class is typically used in conjunction with Spring MVC to handle date and time formatting
 * in web applications.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    /**
     * The {@code DateTimeFormatter} used for formatting and parsing {@code LocalDateTime} objects.
     */
    private final DateTimeFormatter formatter;

    /**
     * Constructs a new {@code LocalDateTimeFormatter} with the specified {@code DateTimeFormatter}.
     *
     * @param formatter The {@code DateTimeFormatter} to be used for formatting and parsing.
     */
    public LocalDateTimeFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Parses the given text into a {@code LocalDateTime} object using the configured {@code DateTimeFormatter}.
     *
     * @param text   The text to be parsed into a {@code LocalDateTime} object.
     * @param locale The locale to be used for parsing (not used in this implementation).
     * @return A {@code LocalDateTime} object parsed from the input text.
     * @throws ParseException If the parsing fails.
     */
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text, formatter);
    }

    /**
     * Formats the given {@code LocalDateTime} object into a string using the configured {@code DateTimeFormatter}.
     *
     * @param object The {@code LocalDateTime} object to be formatted.
     * @param locale The locale to be used for formatting (not used in this implementation).
     * @return A formatted string representing the input {@code LocalDateTime} object.
     */
    @Override
    public String print(LocalDateTime object, Locale locale) {
        return formatter.format(object);
    }
}