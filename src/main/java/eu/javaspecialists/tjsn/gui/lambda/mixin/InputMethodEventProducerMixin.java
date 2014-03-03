package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface InputMethodEventProducerMixin {
  default void addInputMethodTextChangedListener(Consumer<InputMethodEvent> c) {
    addInputMethodListener(new InputMethodAdapter() {
      public void inputMethodTextChanged(InputMethodEvent e) {
        c.accept(e);
      }
    });
  }

  default void addCaretPositionChangedListener(Consumer<InputMethodEvent> c) {
    addInputMethodListener(new InputMethodAdapter() {
      public void caretPositionChanged(InputMethodEvent e) {
        c.accept(e);
      }
    });
  }

  void addInputMethodListener(InputMethodListener l);

  interface InputMethodAdapter extends InputMethodListener {
    default void inputMethodTextChanged(InputMethodEvent e) {
    }

    default void caretPositionChanged(InputMethodEvent e) {
    }
  }
}
