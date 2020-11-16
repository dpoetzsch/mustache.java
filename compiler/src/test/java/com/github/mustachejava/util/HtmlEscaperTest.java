package com.github.mustachejava.util;

import junit.framework.TestCase;

import java.io.StringWriter;



public class HtmlEscaperTest extends TestCase {
  protected Escaper escaper = new HtmlEscaper();

  public void testEscape() throws Exception {
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello, world!", sw);
      assertEquals("Hello, world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello & world!", sw);
      assertEquals("Hello &amp; world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello &amp; world!", sw);
      assertEquals("Hello &amp;amp; world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("Hello &amp world!", sw);
      assertEquals("Hello &amp;amp world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp world!", sw);
      assertEquals("&quot;Hello&quot; &amp;amp world!", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp world!&#10;", sw);
      assertEquals("&quot;Hello&quot; &amp;amp world!&amp;#10;", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp <world>!\n", sw);
      assertEquals("&quot;Hello&quot; &amp;amp &lt;world&gt;!&#10;", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp world!\n&sam", sw);
      assertEquals("&quot;Hello&quot; &amp;amp world!&#10;&amp;sam", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp 'world'!\n&sam", sw);
      assertEquals("&quot;Hello&quot; &amp;amp &#39;world&#39;!&#10;&amp;sam", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp 'world'!\n&sam", sw);
      assertEquals("&quot;Hello&quot; &amp;amp &#39;world&#39;!&#10;&amp;sam", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp&#zz 'world'!\n&sam", sw);
      assertEquals("&quot;Hello&quot; &amp;amp&amp;#zz &#39;world&#39;!&#10;&amp;sam", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" &amp&#zz 'world'!\n&sam&#", sw);
      assertEquals("&quot;Hello&quot; &amp;amp&amp;#zz &#39;world&#39;!&#10;&amp;sam&amp;#", sw.toString());
    }
    {
      StringWriter sw = new StringWriter();
      escaper.escape("\"Hello\" =` 'world'!", sw);
      assertEquals("&quot;Hello&quot; &#61;&#96; &#39;world&#39;!", sw.toString());
    }
  }
}
