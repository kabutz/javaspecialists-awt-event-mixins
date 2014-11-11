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

package eu.javaspecialists.tjsn.gui.lambda.samples.facade.salaryincrease;

import eu.javaspecialists.tjsn.gui.lambda.facade.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SalaryIncreaseCalculatorJava8 extends JFrame {
    private final JButton salaryIncreaser;
    private int buttonIndex = -1;
    private final Random rand = new Random();

    public SalaryIncreaseCalculatorJava8() {
        super("Salary Calculator");
        setLayout(new GridLayout(0, 3));
        for (int i = 0; i < 12; i++) {
            add(new JLabel(""));
        }
        salaryIncreaser = new JButton("Increase Salary");
        shuffleSalaryButton();
    }

    private void initialize() {
        salaryIncreaser.addFocusListener(
                FocusListeners.forFocusGainedListener(
                        e -> System.out.println("Almost there!"))
        );

        salaryIncreaser.addKeyListener(
                KeyListeners.forKeyPressedListener(
                        e -> {
                            e.consume();
                            System.out.println("Not quite!");
                        }
                )
        );

        salaryIncreaser.addMouseListener(
                MouseListeners.forMouseEntered(
                        e -> shuffleSalaryButton()
                )
        );

        salaryIncreaser.addActionListener(e ->
                        System.out.println("You have just doubled your salary!")
        );
    }

    public void shuffleSalaryButton() {
        int newIndex;
        while ((newIndex = rand.nextInt(12)) == buttonIndex) {
            // look for another
        }
        add(salaryIncreaser, newIndex);
        validate();
        repaint();
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            SalaryIncreaseCalculatorJava8 calc =
                    new SalaryIncreaseCalculatorJava8();
            calc.initialize();
            calc.setSize(400, 300);
            calc.setVisible(true);
            calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });
    }
}