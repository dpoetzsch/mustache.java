package com.github.mustachejava.util;

import java.io.IOException;
import java.io.Writer;

public class IndentableCharArray {
    private static final char[] NEWLINE = new char[] { '\n' };

    char[][] lines;

    public IndentableCharArray(String s) {
        String[] ls = s.split("\n");
        lines = new char[ls.length][];

        for (int i = 0; i < ls.length; ++i) {
            lines[i] = ls[i].toCharArray();
        }
    }

    public void appendText(Writer writer, char[] indent) throws IOException {
        writer.write(lines[0]);
        for (int i = 1; i < lines.length; ++i) {
            writer.write(NEWLINE);
            writer.write(indent);
            writer.write(lines[i]);
        }
    }
}
