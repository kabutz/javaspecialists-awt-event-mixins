package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface KeyEventProducerMixin {
  default void addKeyTypedListener(Consumer<KeyEvent> c) {
    addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        c.accept(e);
      }
    });
  }

  default void addKeyPressedListener(Consumer<KeyEvent> c) {
    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        c.accept(e);
      }
    });
  }

  default void addKeyReleasedListener(Consumer<KeyEvent> c) {
    addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        c.accept(e);
      }
    });
  }

  public void addKeyListener(KeyListener listener);
}
