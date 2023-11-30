package controller;

import view.InstituicaoGUI;
import view.LoginGUI;

public class Main {
    public static void main(String[] args) {
        // Inicia a tela de login
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        
        // Adiciona um ouvinte de eventos para aguardar o login ser bem-sucedido
        loginGUI.addLoginListener(new LoginListener() {
            @Override
            public void onLoginSuccess() {
                // Quando o login for bem-sucedido, inicia a tela da instituição
                InstituicaoGUI instituicaoGUI = new InstituicaoGUI();
                instituicaoGUI.setVisible(true);
                loginGUI.dispose(); // Fecha a tela de login após o login bem-sucedido
            }
        });
        
    }
}