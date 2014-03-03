/*
 * Copyright (C) 2000-2014 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.javaspecialists.tjsn.gui.lambda;

import eu.javaspecialists.tjsn.gui.lambda.mixin.*;

import javax.swing.*;

public class JButtonLambda extends JButton
        implements JComponentEventProducerMixin, AbstractButtonEventProducerMixin {
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