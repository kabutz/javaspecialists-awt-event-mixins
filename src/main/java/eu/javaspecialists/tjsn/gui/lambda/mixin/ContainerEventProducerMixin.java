package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface ContainerEventProducerMixin {
  default void addComponentAddedListener(Consumer<ContainerEvent> c) {
    addContainerListener(new ContainerAdapter() {
      public void componentAdded(ContainerEvent e) {
        c.accept(e);
      }
    });
  }

  default void addComponentRemovedListener(Consumer<ContainerEvent> c) {
    addContainerListener(new ContainerAdapter() {
      public void componentRemoved(ContainerEvent e) {
        c.accept(e);
      }
    });
  }

  public void addContainerListener(ContainerListener listener);
}
