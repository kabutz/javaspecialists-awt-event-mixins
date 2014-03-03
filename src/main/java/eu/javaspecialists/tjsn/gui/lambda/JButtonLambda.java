package eu.javaspecialists.tjsn.gui.lambda;

import javax.swing.*;
import eu.javaspecialists.tjsn.gui.lambda.mixin.*;


public class JButtonLambda extends JButton
    implements JComponentEventProducerMixin {
  public JButtonLambda() {
  }

  public JButtonLambda(Icon icon) {
    super(icon);
  }

  public JButtonLambda(String text) {
    super(text);
  }

  public JButtonLambda(Action a) {
    super(a);
  }

  public JButtonLambda(String text, Icon icon) {
    super(text, icon);
  }
}
