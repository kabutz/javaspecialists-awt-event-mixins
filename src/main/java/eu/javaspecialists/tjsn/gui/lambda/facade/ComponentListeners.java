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

package eu.javaspecialists.tjsn.gui.lambda.facade;

import java.awt.event.*;
import java.util.function.*;

public interface ComponentListeners {
    static ComponentListener forComponentResized(Consumer<ComponentEvent> c) {
        return new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                c.accept(e);
            }
        };
    }

    static ComponentListener forComponentMoved(Consumer<ComponentEvent> c) {
        return new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                c.accept(e);
            }
        };
    }

    static ComponentListener forComponentShown(Consumer<ComponentEvent> c) {
        return new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                c.accept(e);
            }
        };
    }

    static ComponentListener forComponentHidden(Consumer<ComponentEvent> c) {
        return new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                c.accept(e);
            }
        };
    }
}