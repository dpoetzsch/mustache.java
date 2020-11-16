package com.github.mustachejava.util;

import junit.framework.TestCase;

import java.io.StringWriter;


public class LatexEscaperTest extends TestCase {
  protected Escaper escaper = new LatexEscaper();

  public void testEscape() throws Exception {
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello, world!", sw);
      assertEquals("Hello, world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello & world!", sw);
      assertEquals("Hello \\& world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello ~ world!", sw);
      assertEquals("Hello \\textasciitilde  world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello _world!", sw);
      assertEquals("Hello \\_world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("&%$#_{}", sw);
      assertEquals("\\&\\%\\$\\#\\_\\{\\}", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello ^ world!", sw);
      assertEquals("Hello \\textasciicircum  world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello \\ world!", sw);
      assertEquals("Hello \\textbackslash  world!", sw.toString());
    }

  }
}
