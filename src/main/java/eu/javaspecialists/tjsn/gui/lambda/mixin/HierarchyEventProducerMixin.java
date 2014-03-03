package eu.javaspecialists.tjsn.gui.lambda.mixin;

import java.awt.event.*;
import java.util.function.*;

public interface HierarchyEventProducerMixin {
  default void addHierarchyAncestorMovedListener(Consumer<HierarchyEvent> c) {
    addHierarchyBoundsListener(
        new HierarchyBoundsAdapter() {
          public void ancestorMoved(HierarchyEvent e) {
            c.accept(e);
          }
        }
    );
  }

  default void addHierarchyAncestorResizedListener(Consumer<HierarchyEvent> c) {
    addHierarchyBoundsListener(
        new HierarchyBoundsAdapter() {
          public void ancestorResized(HierarchyEvent e) {
            c.accept(e);
          }
        }
    );
  }

  public void addHierarchyBoundsListener(HierarchyBoundsListener l);
}
