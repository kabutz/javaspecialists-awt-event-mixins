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

package eu.javaspecialists.tjsn.gui.lambda.mixin;

import javax.swing.event.*;
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
