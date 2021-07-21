public class form_Login extends javax.swing.JFrame {
	private static Fase f = new Fase();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public form_Login() throws ClassNotFoundException {
        initComponents();
       this.setLocationRelativeTo(null);              
       con = ConectDb.conectdb();       
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        TxtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("     NOME:");

        Save.setText("SALVAR");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(Save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(Save)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {                                     
         String sql = "Insert into login(nome,score) values(?,?)";
        try {
            PreparedStatement pst = con.prepareCall(sql);
            pst.setString(1, TxtUsuario.getText());
            pst.setLong(2, f.getPontuacao());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");           
        } catch (SQLException ex) {
            Logger.getLogger(form_Login.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }                                     
    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }                                            
    public static void main(String args[]) {       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new form_Login().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(form_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }                
    private javax.swing.JButton Save;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
}
