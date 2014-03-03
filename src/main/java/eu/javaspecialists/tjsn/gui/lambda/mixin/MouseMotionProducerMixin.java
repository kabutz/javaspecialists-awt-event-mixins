package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface MouseMotionProducerMixin {
  default void addMouseDraggedListener(Consumer<MouseEvent> c) {
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        c.accept(e);
      }
    });
  }
  default void addMouseMovedListener(Consumer<MouseEvent> c) {
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        c.accept(e);
      }
    });
  }

  public void addMouseMotionListener(MouseMotionListener listener);
}
