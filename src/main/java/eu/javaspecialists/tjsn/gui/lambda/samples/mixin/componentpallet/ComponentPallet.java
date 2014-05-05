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

package eu.javaspecialists.tjsn.gui.lambda.samples.mixin.componentpallet;

import eu.javaspecialists.tjsn.gui.lambda.mixin.*;

import javax.swing.*;
import java.awt.*;

public class ComponentPallet extends JFrame {
    public ComponentPallet() {
        super("ComponentPallet");
        setLayout(new GridLayout(0, 3));
        JLabelLambda label = new JLabelLambda("New Improved Label");
        addListeners(label);
        add(label);

        JTreeLambda tree = new JTreeLambda();
        addListeners(tree);
        addTreeListeners(tree);
        add(tree);

        JButtonLambda button = new JButtonLambda("Cool Button");
        addListeners(button);
        addButtonListeners(button);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        add(buttonPanel);

        JTextFieldLambda textField = new JTextFieldLambda("some text");
        addListeners(textField);
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(textField);
        add(textFieldPanel);

        JCheckBoxLambda checkBox = new JCheckBoxLambda("Are you Happy?");
        addListeners(checkBox);
        addButtonListeners(checkBox);
        add(checkBox);

        JComboBoxLambda<String> comboBox = new JComboBoxLambda<>(
                "option1", "option2", "option3");
        addListeners(comboBox);
        add(comboBox);

        JTableLambda table = new JTableLambda(
                new Object[][]{{"1", "2", "3"}, {"apples", "oranges", "pears"}},
                new Object[]{"col1", "col2", "col3"});
        addListeners(table);
        add(new JScrollPane(table));


        JTextAreaLambda textArea = new JTextAreaLambda("Hey\nthere\nsport", 3, 4);
        addListeners(textArea);
        add(textArea);
    }

    private void addButtonListeners(AbstractButtonEventProducerMixin c) {
        c.addActionListener((e) -> show(c, "action happened", e));
        c.addChangeListener((e) -> show(c, "change happened", e));
        c.addItemListener((e) -> show(c, "item happened", e));
    }

    private void addTreeListeners(JTreeEventProducerMixin c) {
        c.addTreeSelectionListener((e) -> show(c, "item selected", e));
        c.addTreeWillExpandListener((e) -> show(c, "tree /will/ expand", e));
        c.addTreeWillCollapseListener((e) -> show(c, "tree /will/ collapse", e));
        c.addTreeExpandedListener((e) -> show(c, "tree expanded", e));
        c.addTreeCollapsedListener((e) -> show(c, "tree collapsed", e));
    }

    private void addListeners(JComponentEventProducerMixin c) {
        c.addFocusGainedListener((e) -> show(c, "gained focus", e));
        c.addFocusLostListener((e) -> show(c, "lost focus", e));
        c.addMouseClickedListener((e) -> show(c, "mouse clicked", e));
        c.addMouseEnteredListener((e) -> show(c, "mouse entered", e));
        c.addMouseExitedListener((e) -> show(c, "mouse exited", e));
        c.addMousePressedListener((e) -> show(c, "mouse pressed", e));
        c.addMouseReleasedListener((e) -> show(c, "mouse released", e));
        c.addKeyPressedListener((e) -> show(c, "key pressed", e));
        c.addKeyReleasedListener((e) -> show(c, "key released", e));
        c.addKeyTypedListener((e) -> show(c, "key typed", e));
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