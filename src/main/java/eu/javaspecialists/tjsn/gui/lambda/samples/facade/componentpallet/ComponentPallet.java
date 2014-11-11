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

package eu.javaspecialists.tjsn.gui.lambda.samples.facade.componentpallet;

import eu.javaspecialists.tjsn.gui.lambda.facade.*;

import javax.swing.*;
import java.awt.*;

public class ComponentPallet extends JFrame {
    public ComponentPallet() {
        super("ComponentPallet");
        setLayout(new GridLayout(0, 3));
        JLabel label = new JLabel("New Improved Label");
        addListeners(label);
        add(label);

        JTree tree = new JTree();
        addListeners(tree);
        addTreeListeners(tree);
        add(tree);

        JButton button = new JButton("Cool Button");
        addListeners(button);
        addButtonListeners(button);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        add(buttonPanel);

        JTextField textField = new JTextField("some text");
        addListeners(textField);
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(textField);
        add(textFieldPanel);

        JCheckBox checkBox = new JCheckBox("Are you Happy?");
        addListeners(checkBox);
        addButtonListeners(checkBox);
        add(checkBox);

        JComboBox<String> comboBox = new JComboBox<>(
                new String[]{"option1", "option2", "option3"});
        addListeners(comboBox);
        add(comboBox);

        JTable table = new JTable(
                new Object[][]{{"1", "2", "3"}, {"apples", "oranges", "pears"}},
                new Object[]{"col1", "col2", "col3"});
        addListeners(table);
        add(new JScrollPane(table));


        JTextArea textArea = new JTextArea("Hey\nthere\nsport", 3, 4);
        addListeners(textArea);
        add(textArea);
    }

    private void addButtonListeners(AbstractButton c) {
        c.addActionListener(e -> show(c, "action happened", e));
        c.addChangeListener(e -> show(c, "change happened", e));
        c.addItemListener(e -> show(c, "item happened", e));
    }

    private void addTreeListeners(JTree c) {
        c.addTreeSelectionListener(e -> show(c, "item selected", e));
        c.addTreeWillExpandListener(TreeWillExpandListeners.forTreeWillExpand(e -> show(c, "tree /will/ expand", e)));
        c.addTreeWillExpandListener(TreeWillExpandListeners.forTreeWillCollapse(e -> show(c, "tree /will/ collapse", e)));
        c.addTreeExpansionListener(TreeExpansionListeners.forTreeExpanded(e -> show(c, "tree expanded", e)));
        c.addTreeExpansionListener(TreeExpansionListeners.forTreeCollapsed(e -> show(c, "tree collapsed", e)));
    }

    private void addListeners(JComponent c) {
        c.addFocusListener(FocusListeners.forFocusGainedListener(e -> show(c, "gained focus", e)));
        c.addFocusListener(FocusListeners.forFocusLostListener(e -> show(c, "lost focus", e)));
        c.addMouseListener(MouseListeners.forMouseClicked(e -> show(c, "mouse clicked", e)));
        c.addMouseListener(MouseListeners.forMouseEntered(e -> show(c, "mouse entered", e)));
        c.addMouseListener(MouseListeners.forMouseExited(e -> show(c, "mouse exited", e)));
        c.addMouseListener(MouseListeners.forMousePressed(e -> show(c, "mouse pressed", e)));
        c.addMouseListener(MouseListeners.forMouseReleased(e -> show(c, "mouse released", e)));
        c.addKeyListener(KeyListeners.forKeyPressedListener(e -> show(c, "key pressed", e)));
        c.addKeyListener(KeyListeners.forKeyReleasedListener(e -> show(c, "key released", e)));
        c.addKeyListener(KeyListeners.forKeyTypedListener(e -> show(c, "key typed", e)));
    }

    private void show(Object component, String what, Object event) {
        System.out.printf("%s %s : %s%n", component.getClass().getSimpleName(),
                what, event);
    }


    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            ComponentPallet calc =
                    new ComponentPallet();
            calc.setSize(400, 300);
            calc.setVisible(true);
            calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });
    }
}