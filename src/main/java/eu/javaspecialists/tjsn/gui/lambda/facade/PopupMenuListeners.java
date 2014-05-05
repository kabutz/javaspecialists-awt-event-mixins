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

import javax.swing.event.*;
import java.util.function.*;

public interface PopupMenuListeners {
    static PopupMenuListener forPopupMenuWillBecomeVisible(Consumer<PopupMenuEvent> c) {
        return new PopupMenuAdapter() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                c.accept(e);
            }
        };
    }

    static PopupMenuListener forPopupMenuWillBecomeInvisible(Consumer<PopupMenuEvent> c) {
        return new PopupMenuAdapter() {
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                c.accept(e);
            }
        };
    }

    static PopupMenuListener forPopupMenuCanceled(Consumer<PopupMenuEvent> c) {
        return new PopupMenuAdapter() {
            public void popupMenuCanceled(PopupMenuEvent e) {
                c.accept(e);
            }
        };
    }


    interface PopupMenuAdapter extends PopupMenuListener {

        /**
         * This method is called before the popup menu becomes visible
         */
        default void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        }

        /**
         * This method is called before the popup menu becomes invisible
         * Note that a JPopupMenu can become invisible any time
         */
        default void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        }

        /**
         * This method is called when the popup menu is canceled
         */
        default void popupMenuCanceled(PopupMenuEvent e) {
        }
    }

}
