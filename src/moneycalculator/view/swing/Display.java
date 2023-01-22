/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package moneycalculator.view.swing;

import java.awt.event.ActionListener;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;

/**
 *
 * @author yabpe
 */
interface Display {
    void refreshMoney(Money m);
    Money getMoneyFrom();
    Currency getCurrencyTo();
    void addConvertListener(ActionListener listener);
}
