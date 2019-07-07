/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
import Login.Startup;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Startup();
            }
        });
    }

}


/*

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        initFields();
    }

    private void initFields() {

    }

*/