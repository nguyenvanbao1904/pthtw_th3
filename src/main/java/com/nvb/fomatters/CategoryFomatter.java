package com.nvb.fomatters;

import com.nvb.pojo.Category;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFomatter implements Formatter<Category> {

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Category category = new Category();
        category.setId(Integer.parseInt(text));
        return category;
    }

    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
