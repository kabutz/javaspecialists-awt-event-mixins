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

public interface MouseListeners {
    static MouseListener forMouseClicked(Consumer<MouseEvent> c) {
        return new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                c.accept(e);
            }
        };
    }

    static MouseListener forMouseEntered(Consumer<MouseEvent> c) {
        return new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                c.accept(e);
            }
        };
    }

    static MouseListener forMouseExited(Consumer<MouseEvent> c) {
        return new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                c.accept(e);
            }
        };
    }

    static MouseListener forMousePressed(Consumer<MouseEvent> c) {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                c.accept(e);
            }
        };
    }

    static MouseListener forMouseReleased(Consumer<MouseEvent> c) {
        return new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                c.accept(e);
            }
        };
    }
}
