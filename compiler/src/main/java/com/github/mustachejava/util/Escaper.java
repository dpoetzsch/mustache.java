package com.github.mustachejava.util;

import java.io.Writer;

public interface Escaper {
    void escape(String value, Writer writer);
}
