package lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;

/**
 *
 * @author anterova
 */
public class ScrollattavaLista extends JPanel {
    private JPanel mainList;
    private Havaintolista lista;
    
    public ScrollattavaLista(Havaintolista lista) {
        this.lista = lista;
        
        setLayout(new BorderLayout());

        mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;

        add(new JScrollPane(mainList));
        
        for (int i = lista.getHavaintoja() - 1; i >= 0 ; i--) {
            mainList.add( new Havaintopaneeli( lista.get(i) ), gbc, 0 );
        }

        validate();
        repaint();
        
    }
}
