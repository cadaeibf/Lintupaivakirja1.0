package lipvk.gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridLayout;
import javax.swing.JPanel;
import lipvk.ohlo.Lintulista;

/**
 *
 * @author anterova
 */
public class Keskuspaneeli extends JPanel {
    private VasenLohko vasenLohko;
    private Havaintolistakaavake havaintolistakaavake;

    public Keskuspaneeli(Lintulista lintulista) {
        super(new GridLayout(1,2));
        
        luoKomponentit(lintulista);
    }

    private void luoKomponentit(Lintulista lintulista) {
        vasenLohko = new VasenLohko();
        havaintolistakaavake = new Havaintolistakaavake(lintulista);
        
        vasenLohko.lisaaTakut();
        
        add(vasenLohko);
        add(havaintolistakaavake);
        
    }

    public void paivitaLintulista(Lintulista lintulista) {
        havaintolistakaavake.paivitaLintulista(lintulista);
    }
    
    
}
