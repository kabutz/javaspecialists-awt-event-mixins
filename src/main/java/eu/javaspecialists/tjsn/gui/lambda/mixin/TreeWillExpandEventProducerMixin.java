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

public interface TreeWillExpandEventProducerMixin {
    default void addTreeWillExpandListener(Consumer<TreeExpansionEvent> c) {
        addTreeWillExpandListener(new TreeExpansionAdapter() {
            public void treeWillExpand(TreeExpansionEvent e) {
                c.accept(e);
            }
        });
    }

    default void addTreeWillCollapseListener(Consumer<TreeExpansionEvent> c) {
        addTreeWillExpandListener(new TreeExpansionAdapter() {
            public void treeWillCollapse(TreeExpansionEvent e) {
                c.accept(e);
            }
        });
    }

    public void addTreeWillExpandListener(TreeWillExpandListener listener);

    interface TreeExpansionAdapter extends TreeWillExpandListener {
        default void treeWillExpand(TreeExpansionEvent e) {
        }

        default void treeWillCollapse(TreeExpansionEvent e) {
        }
    }
}