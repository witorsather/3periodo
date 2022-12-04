import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Exe2TelefonesMenu extends JFrame {
    private JTextField textFieldTelefone;
    private JButton adicionarTelefoneButton;
    private JButton buttonRemoverTelefone;
    private JPanel mainPanel;
    private JTextArea textAreaSaida;
    private JButton listarTelefonesButton;
    private JButton sairButton;

    public Exe2TelefonesMenu() {
        setContentPane(mainPanel);
        setTitle("Bem-Vindo");
        setSize(650, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        List<String> listaTelefones = new ArrayList<String>();

        adicionarTelefoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textAreaSaida.setText("");
                    String telefone = textFieldTelefone.getText();
                    //listaTelefones.add(telefone);
                    textFieldTelefone.setText("");

                    Double.parseDouble(telefone);

                    if (isNumeric(telefone)) {
                        listaTelefones.add(telefone);
                        textFieldTelefone.setText("");

                        // após adicionar telefone lista ele com lista Telefone
                        String texto;
                        texto = "";
                        for (int i = 0; i < listaTelefones.size(); i++) {
                            texto = texto + ("Posição " + i + " = " + listaTelefones.get(i)) + "       ";
                        }
                        textAreaSaida.setText(texto);
                    }
                } catch (Exception exp) {
                    textFieldTelefone.setText("");
                    JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonRemoverTelefone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String texto;
                    texto = "";
                    textAreaSaida.setText("");
                    String telefone = textFieldTelefone.getText();

                    // forma mais fácil de remover telefone
                    //listaTelefones.remove(listaTelefones.indexOf(telefone));

                    Double.parseDouble(telefone);
                    int removeu = 0;

                    for (int i = 0; i < listaTelefones.size(); i++) {
                        if (listaTelefones.get(i).equals(telefone)) {
                            listaTelefones.remove(i);
                            removeu += 1;

                            // após adicionar telefone lista ele com lista Telefone
                            for (int j = 0; j < listaTelefones.size(); j++) {
                                texto = texto + ("Posição " + i + " = " + listaTelefones.get(j)) + "       ";
                            }
                            textAreaSaida.setText(texto);
                        }
                    }
                    if (removeu == 0){
                        JOptionPane.showInternalMessageDialog(null, "Telefone não encontrado!",
                                "informação", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (Exception exp) {
                    textFieldTelefone.setText("");
                    JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números", "alert", JOptionPane.ERROR_MESSAGE);
                }

                textFieldTelefone.setText("");
            }
        });
        listarTelefonesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String telefone = textFieldTelefone.getText();
                    textAreaSaida.setText("");
                    //textAreaSaida.setText(listaTelefones.indexOf(telefone) + listaTelefones.toString());
                    String texto;
                    texto = "";
                    for (int i = 0; i < listaTelefones.size(); i++) {
                        texto = texto + ("Posição " + i + " = " + listaTelefones.get(i)) + "       ";
                    }
                    textAreaSaida.setText(texto);
                } catch (Exception exp) {
                    textFieldTelefone.setText("Error");
                    JOptionPane.showMessageDialog(null, "Valor inválido!", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fechar tela
                dispose();
            }
        });
    }

    public static boolean isNumeric(String telefone) {
        try {
            Double.parseDouble(telefone);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Exe2TelefonesMenu myFrame = new Exe2TelefonesMenu();
    }
}
