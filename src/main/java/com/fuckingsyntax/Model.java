package com.fuckingsyntax;

public class Model {
  public static void staticVoidMethodNoParameters() {
    System.out.println("hello from void static method");
  }

  public static int staticIntMethodNoParameters() {
    return 42;
  }

  public static int staticIntMethodWithIntParameter(final int n) {
    return 42 * n;
  }

  public void voidMethodNoParameters() {
    System.out.println("hello from void method");
  }

  public void voidMethodWithIntParameter(final int n) {
    System.out.println("Hello from the void parameterized method: " + n);
  }

  public int intMethodWithNoParameters() {
    return 42;
  }

  public int intMethodWithIntParameter(final int n) {
    return 42 * n;
  }
}
