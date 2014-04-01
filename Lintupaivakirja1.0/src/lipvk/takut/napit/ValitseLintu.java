/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.kali.kepa.vasen.VasenLohko;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class ValitseLintu implements ActionListener {
    private Lintulaji lintu;
    private VasenLohko vl;

    public ValitseLintu(Lintulaji lintu, VasenLohko vl) {
        this.lintu = lintu;
        this.vl = vl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vl.asetaLintukortti(lintu.getNimi(), lintukortti(lintu));
    }

    private JPanel lintukortti(Lintulaji lintu) {
        JPanel lintukortti = new JPanel( new GridLayout(2,1) );
        
        lintukortti.add( ylaosa(lintu) );
        lintukortti.add( alaosa(lintu) );
        
        return lintukortti;
    }

    private JPanel ylaosa(Lintulaji lintu) {
        JPanel ylaosa = new JPanel( new GridLayout( 1, 2 ) );
        JPanel vasYl = new JPanel( new GridLayout(5, 1) );
        
        vasYl.add( nimikentta(lintu.getNimi()) );
        ylaosa.add(vasYl);
        ylaosa.add( new JLabel("Ääni") );
        
        return ylaosa;
    }
    
    private JPanel nimikentta(String nimi) {
        JPanel nimikentta = new JPanel( new GridLayout(1, 2) );
        
        nimikentta.add(new JLabel("Laji:"));
        nimikentta.add(new JLabel(lintu.getNimi()));
        
        return nimikentta;
    }

    private JPanel alaosa(Lintulaji lintu) {
        JPanel alaosa = new JPanel( new GridLayout(5,1) );
        
        alaosa.add( new JLabel("Havainnot") );
        
        return alaosa;
    }
    
}
