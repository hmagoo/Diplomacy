package command.input;

import command.Info;
import command.InputBanner;
import map.Country;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hugh on 5/18/2015.
 */
public class SupportInput extends Input implements ActionListener{
    private DefaultComboBoxModel model;
    private InputBanner banner;

    public SupportInput(){

    }

    public SupportInput(InputBanner banner){
        super(banner);
        this.banner = banner;
        model = new DefaultComboBoxModel();
        model.setSelectedItem("choose who to support");

        for (Country support : banner.getCountry().getSupportableCountries()) {
            model.addElement(support);
        }

        setModel(model);
        setSize(longestItem(), 25);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        super.firstAction(banner);
        Info supportAttackInfo = new Info("attack on");
        banner.add(supportAttackInfo);
        SupportAttackInput supportAttack = new SupportAttackInput((Country) getSelectedItem());
        lastAction(banner, supportAttack);
    }
}
