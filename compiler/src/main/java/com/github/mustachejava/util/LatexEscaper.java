package com.github.mustachejava.util;

import com.github.mustachejava.MustacheException;

import java.io.IOException;
import java.io.Writer;

public class LatexEscaper implements Escaper{
    @Override
    public void escape(String value, Writer writer) {
        try {
             String escapedText  = value.replaceAll("\\\\", "\\\\textbackslash ")
                    .replaceAll("([#$%&_{}])", "\\\\$1")
                    .replaceAll("([<>])", "\\\u0024$1\\\u0024")
                    .replaceAll("~", "\\\\textasciitilde ")
                    .replaceAll("\\^", "\\\\textasciicircum ");
            writer.write(escapedText);
        } catch (IOException e) {
            throw new MustacheException("Failed to encode value: " + value, e);
        }
    }
}
