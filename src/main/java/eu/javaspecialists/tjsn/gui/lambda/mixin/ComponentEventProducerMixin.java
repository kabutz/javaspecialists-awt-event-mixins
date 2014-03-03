package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface ComponentEventProducerMixin {
  default void addComponentResizedListener(Consumer<ComponentEvent> c) {
    addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent e) {
        c.accept(e);
      }
    });
  }

  default void addComponentMovedListener(Consumer<ComponentEvent> c) {
    addComponentListener(new ComponentAdapter() {
      public void componentMoved(ComponentEvent e) {
        c.accept(e);
      }
    });
  }

  default void addComponentShownListener(Consumer<ComponentEvent> c) {
    addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        c.accept(e);
      }
    });
  }

  default void addComponentHiddenListener(Consumer<ComponentEvent> c) {
    addComponentListener(new ComponentAdapter() {
      public void componentHidden(ComponentEvent e) {
        c.accept(e);
      }
    });
  }


  public void addComponentListener(ComponentListener listener);
}
