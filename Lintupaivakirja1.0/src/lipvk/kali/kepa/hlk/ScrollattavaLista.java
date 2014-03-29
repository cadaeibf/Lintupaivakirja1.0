package lipvk.kali.kepa.hlk;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lipvk.ohlo.Havaintolista;

/**
 *
 * @author anterova
 */
//public class ScrollattavaLista extends JPanel {
//    private JPanel mainList;
//    
//    public ScrollattavaLista(Havaintolista lista) {
//        setLayout(new BorderLayout());
//
//        mainList = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//
//        add(new JScrollPane(mainList));
//        
//        for (int i = lista.getHavaintoja() - 1; i >= 0 ; i--) {
//            mainList.add( new Havaintopaneeli( lista.get(i) ), gbc, 0 );
//        }
//
//        validate();
//        repaint();
//        
//    }
//}

public class ScrollattavaLista extends JPanel {
    private JPanel mainList;
    
    public ScrollattavaLista(Havaintolista lista) {
        mainList = new JPanel();
        JScrollPane scrollPane = new JScrollPane(mainList);
        
        for (int i = 0; i < 100; i++) {
            mainList.add( new JLabel("Hello") );
        }
        
        
        add(scrollPane);
    }
}
