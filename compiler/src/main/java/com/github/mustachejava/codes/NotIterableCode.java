package com.github.mustachejava.codes;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.TemplateContext;

import java.io.Writer;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Runs the enclosed template once if the value is falsey.
 */
public class NotIterableCode extends IterableCode {

  public NotIterableCode(TemplateContext templateContext, DefaultMustacheFactory df, Mustache mustache, String variable) {
    super(templateContext, df, mustache, variable, "^");
  }

  @Override
  public Writer execute(Writer writer, char[] indent, final List<Object> scopes) {
    Object resolved = get(scopes);
    writer = handle(writer, indent, resolved, scopes);
    appendText(writer, indent);
    return writer;
  }

  protected Writer handle(Writer writer, char[] indent, Object resolved, List<Object> scopes) {
    if (resolved instanceof Callable) {
      writer = handleCallable(writer, indent, (Callable) resolved, scopes);
    } else {
      writer = execute(writer, indent, resolved, scopes);
    }
    return writer;
  }

  @Override
  protected Writer execute(Writer writer, char[] indent, Object resolve, List<Object> scopes) {
    return oh.falsey(this, writer, indent, resolve, scopes);
  }

  @Override
  public Writer next(Writer writer, char[] indent, Object object, List<Object> scopes) {
    return run(writer, indent, scopes);
  }
}
