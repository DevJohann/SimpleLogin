package co.edu.unbosque.controller;
import co.edu.unbosque.model.Conection;
import co.edu.unbosque.model.ConnectionDTO;
import co.edu.unbosque.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{

    private MainView MV;
    //private RegisterForm RF;
    private LoginPanel LP;
    private RegisterPanel RP;
    private Conection objectConnection;
    private ConnectionDTO DBManager;
    
    public Controller() {
        initComponents();
        setListeners();
    }
    
    public void initComponents(){
        MV  = new MainView();
        MV.setVisible(true);
        MV.setLocationRelativeTo(null);
        
       // RF = new RegisterForm();
      //  RF.setVisible(false);
        LP = new LoginPanel();
        MV.add(LP);
        LP.setVisible(true);
      
        RP = new RegisterPanel();
        RP.setVisible(false);
        
        
        objectConnection = new Conection();
        //objectConnection.connectToDB();
        
        DBManager = new ConnectionDTO();
    }
    
    public void setListeners(){
        MV.getLP().getBtnLogin().addActionListener(this);
        MV.getLP().getBtnLogin().setActionCommand("LPLoginBtnEvent");
        
        MV.getLP().getBtnReset().addActionListener(this);
        MV.getLP().getBtnReset().setActionCommand("LPSignupBtnEvent");
        
        MV.getRP().getSignUpBtn().addActionListener(this);
        MV.getRP().getSignUpBtn().setActionCommand("RPSignUpBtnEvent");
        
        MV.getRP().getLogInBtn().addActionListener(this);
        MV.getRP().getLogInBtn().setActionCommand("RPLogInBtnEvent");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      switch(e.getActionCommand()){
          case "LPLoginBtnEvent":
              String username = MV.getLP().getUsernameField().getText();
              String password = String.valueOf(MV.getLP().getPasswordField().getPassword());
              boolean isAllowed = DBManager.checkUserPsswd(username, password);
              if(isAllowed){
                  MV.getLP().getUsernameField().setText("");
                  MV.getLP().getPasswordField().setText("");
                  JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
              }else{
                  MV.getLP().getUsernameField().setText("");
                  MV.getLP().getPasswordField().setText("");
                  JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
              }
              break;
        
          case "LPSignupBtnEvent":
              MV.getLP().setVisible(false);
              MV.getRP().setVisible(true);
              MV.setSize(414, 220);
             
              break;
              
          case "RPSignUpBtnEvent":
              String lastName = MV.getRP().getLastNameField().getText();
              String firstName = MV.getRP().getFirstNameField().getText();
              String passwordToReg = String.valueOf(MV.getRP().getPasswordField().getPassword());
              boolean isRepeated = DBManager.checkUserPsswd(firstName, passwordToReg);
              if(isRepeated){
                  MV.getRP().getFirstNameField().setText("");
                  JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente");
              }else{
                  MV.getRP().getLastNameField().setText("");
                  MV.getRP().getFirstNameField().setText("");
                  MV.getRP().getPasswordField().setText("");
                  DBManager.addUser(lastName, firstName, passwordToReg);
              }
              break;
              
          case "RPLogInBtnEvent":
              MV.getRP().setVisible(false);
              MV.getLP().setVisible(true);
              break;
      }
    }
    
}
