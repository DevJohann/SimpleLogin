package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainView extends javax.swing.JFrame {

    private LoginPanel LP;
    private RegisterPanel RP;
    
    public MainView() {
        initComponents();
        LP = new LoginPanel();
        LP.setVisible(true);
        LP.setSize(this.getSize());
        add(LP);
        
        RP = new RegisterPanel();
        RP.setVisible(false);
        RP.setSize(this.getSize());
        add(RP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public LoginPanel getLP() {
        return LP;
    }

    public void setLP(LoginPanel LP) {
        this.LP = LP;
    }

    public RegisterPanel getRP() {
        return RP;
    }

    public void setRP(RegisterPanel RP) {
        this.RP = RP;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    
}

