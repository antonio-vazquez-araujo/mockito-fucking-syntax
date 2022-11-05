package com.fuckingsyntax;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
class ModelTest {

  @Test
  void staticVoidMethodNoParameters() {
    try (
        final MockedStatic<Model> modelMockedStatic = mockStatic(Model.class)) {
      modelMockedStatic.when(Model::staticVoidMethodNoParameters).thenCallRealMethod();
      Model.staticVoidMethodNoParameters();
      modelMockedStatic.verify(() -> Model.staticVoidMethodNoParameters(), times(1));
    }
  }

  @Test
  void staticIntMethodNoParameters() {
    try (
        final MockedStatic<Model> modelMockedStatic = mockStatic(Model.class)) {
      modelMockedStatic.when(Model::staticIntMethodNoParameters).thenCallRealMethod();
      Model.staticIntMethodNoParameters();
      modelMockedStatic.verify(() -> Model.staticIntMethodNoParameters(), times(1));
      modelMockedStatic.when(Model::staticIntMethodNoParameters).thenReturn(43);
      assertEquals(43, Model.staticIntMethodNoParameters());
    }
  }

  @Test
  void staticIntMethodWithIntParameter() {
    try (
        final MockedStatic<Model> modelMockedStatic = mockStatic(Model.class)) {
      // ALERT!! With parameterized static methods, use the Class.method(parameter) syntax
      // Do not use any(), it needs anyInt or anyWathever, or eq(value)
      modelMockedStatic.when(() -> Model.staticIntMethodWithIntParameter(anyInt())).thenCallRealMethod();
      Model.staticIntMethodWithIntParameter(42);
      modelMockedStatic.verify(() -> Model.staticIntMethodWithIntParameter(eq(42)), times(1));
      modelMockedStatic.when(() -> Model.staticIntMethodWithIntParameter(anyInt())).thenReturn(43);
      assertEquals(43, Model.staticIntMethodWithIntParameter(123));
    }
  }

  // ALERT: With non static methods use the doCallRealMethod().when... syntax
  @Test
  void voidMethodNoParameters() {
    final Model mockModel = mock(Model.class);
    doCallRealMethod().when(mockModel).voidMethodNoParameters();
    mockModel.voidMethodNoParameters();
    verify(mockModel, times(1)).voidMethodNoParameters();
  }

  @Test
  void voidMethodWithIntParameter() {
    final Model mockModel = mock(Model.class);
    doCallRealMethod().when(mockModel).voidMethodWithIntParameter(anyInt());
    mockModel.voidMethodWithIntParameter(42);
    verify(mockModel, times(1)).voidMethodWithIntParameter(eq(42));
  }

  @Test
  void intMethodWithNoParameters() {
    final Model mockModel = mock(Model.class);
    doCallRealMethod().when(mockModel).intMethodWithNoParameters();
    mockModel.intMethodWithNoParameters();
    verify(mockModel, times(1)).intMethodWithNoParameters();
    Mockito.clearInvocations(mockModel);
    when(mockModel.intMethodWithNoParameters()).thenReturn(43);
    assertEquals(43, mockModel.intMethodWithNoParameters());
  }

  @Test
  void intMethodWithIntParameter() {
    final Model mockModel = mock(Model.class);
    doCallRealMethod().when(mockModel).intMethodWithIntParameter(anyInt());
    mockModel.intMethodWithIntParameter(42);
    verify(mockModel, times(1)).intMethodWithIntParameter(eq(42));
    when(mockModel.intMethodWithIntParameter(anyInt())).thenReturn(43);
    assertEquals(43, mockModel.intMethodWithIntParameter(123));
  }
}
