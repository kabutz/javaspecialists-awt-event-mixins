package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface MouseEventProducerMixin {
  default void addMouseClickedListener(Consumer<MouseEvent> c) {
    addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  default void addMouseEnteredListener(Consumer<MouseEvent> c) {
    addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  default void addMouseExitedListener(Consumer<MouseEvent> c) {
    addMouseListener(new MouseAdapter() {
      public void mouseExited(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  default void addMousePressedListener(Consumer<MouseEvent> c) {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  default void addMouseReleasedListener(Consumer<MouseEvent> c) {
    addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  public void addMouseListener(MouseListener listener);
}
