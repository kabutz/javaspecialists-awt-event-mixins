package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface FocusEventProducerMixin {
  default void addFocusGainedListener(Consumer<FocusEvent> c) {
    addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent e) {
        c.accept(e);
      }
    });
  }

  default void addFocusLostListener(Consumer<FocusEvent> c) {
    addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent e) {
        c.accept(e);
      }
    });
  }

  public void addFocusListener(FocusListener listener);
}
