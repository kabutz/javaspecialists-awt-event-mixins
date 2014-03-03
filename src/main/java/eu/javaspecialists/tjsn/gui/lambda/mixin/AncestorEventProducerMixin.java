package eu.javaspecialists.tjsn.gui.lambda.mixin;

import javax.swing.event.*;
import java.awt.event.*;
import java.util.function.*;

public interface AncestorEventProducerMixin {
  default void addAncestorAddedListener(Consumer<AncestorEvent> c) {
    addAncestorListener(new AncestorAdapter() {
      public void ancestorAdded(AncestorEvent e) {
        c.accept(e);
      }
    });
  }
  default void addAncestorRemovedListener(Consumer<AncestorEvent> c) {
    addAncestorListener(new AncestorAdapter() {
      public void ancestorRemoved(AncestorEvent e) {
        c.accept(e);
      }
    });
  }
  default void addAncestorMovedListener(Consumer<AncestorEvent> c) {
    addAncestorListener(new AncestorAdapter() {
      public void ancestorMoved(AncestorEvent e) {
        c.accept(e);
      }
    });
  }

  public void addAncestorListener(AncestorListener listener);

  interface AncestorAdapter extends AncestorListener {
    default void ancestorAdded(AncestorEvent event) {
    }

    default void ancestorRemoved(AncestorEvent event) {
    }

    default void ancestorMoved(AncestorEvent event) {
    }
  }
}
