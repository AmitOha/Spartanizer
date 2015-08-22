package org.spartan.refactoring.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.spartan.hamcrest.CoreMatchers.is;
import static org.spartan.hamcrest.MatcherAssert.assertThat;
import static org.spartan.hamcrest.MatcherAssert.iz;
import static org.spartan.refactoring.utils.Into.i;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;
import org.junit.Test;

@SuppressWarnings({ "static-method", "javadoc" }) public class ExtractTest {
  @Test public void core() {
    final Statement s = null;
    assertThat(Extract.core(s), nullValue());
  }
  @Test public void plus() {
    final Expression e = Into.e("a + 2 < b");
    final Expression plus = Extract.firstPlus(e);
    assertThat(plus, iz("a+2"));
  }
  @Test public void operandsCount() {
    assertThat(Extract.operands(i("a+b+c+(d+e)+f")).size(), is(5));
  }
  @Test public void operandsOfNullIsNull() {
    assertThat(Extract.operands(null), is(nullValue()));
  }
}
