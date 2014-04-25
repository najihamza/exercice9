package exe9;

/**
 *
 * @author Hamza NAJI hihihihihihihhihihhi
 */

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.*;
public class editeur_texte implements ActionListener {
   JFrame fenetre = null;
   JEditorPane paneauu = null;
   JMenuItem ouvriree = null;
   JMenuItem sauvgarder = null;
    JMenuItem helps;
   JOptionPane dialog;
   JMenu menuAide=null;
   
   String fileName = "Nouveau Fichier.txt";


   private void OuvrirFenetre() {
      fenetre = new JFrame("Editeur de texte");
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setSize(800,600);
    
      paneauu = new JEditorPane();
      paneauu.setContentType("text/plain");
      paneauu.setText(
         "");
      fenetre.setContentPane(paneauu);

      JMenuBar myBar = new JMenuBar();
      JMenu Menuu = getFileMenu();
      myBar.add(Menuu);
      
      JMenu help = getHelpMenu();
      myBar.add(help);
      
      
      fenetre.setJMenuBar(myBar);

      fenetre.setVisible(true);
   }
   private JMenu getFileMenu() {
      JMenu Menuu = new JMenu("Fichier");
      ouvriree = new JMenuItem("Ouvrir");
      ouvriree.addActionListener(this);
      Menuu.add(ouvriree);

      sauvgarder = new JMenuItem("Enregistrer");
      sauvgarder.addActionListener(this);
      Menuu.add(sauvgarder);
      return Menuu;
   }
   
    private JMenu getHelpMenu() {
     menuAide = new JMenu("Aide");
      
      //helps = new JMenuItem("� propos");
      menuAide.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
      
            dialog = new JOptionPane();
            dialog.showMessageDialog(null, "Editeur de texte simple permet d�ouvrir, de cr�er et d��diter des fichiers texte. ", "Aide", JOptionPane.INFORMATION_MESSAGE);

        
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            

        }

        @Override
        public void menuCanceled(MenuEvent e) {
       

        }

         
    });
      return menuAide;
   }
    
    
   public void actionPerformed(ActionEvent e) {
       
        
      JFileChooser chooser = new JFileChooser();
      chooser.setSelectedFile(new File(fileName));
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

      FileNameExtensionFilter filter = new FileNameExtensionFilter(
        ".txt fichier", "txt");
      chooser.setFileFilter(filter);

      Object cmd = e.getSource();
      try {
         if (cmd == ouvriree) {
            int code = chooser.showOpenDialog(paneauu);
            if (code == JFileChooser.APPROVE_OPTION) {
               File selectedFile = chooser.getSelectedFile();
               fileName = selectedFile.getName();
               FileInputStream fis = 
                  new FileInputStream(selectedFile);
               InputStreamReader in = 
                  new InputStreamReader(fis, Charset.forName("UTF-8")); 
               char[] buffer = new char[1024];
               int n = in.read(buffer);
               String text = new String(buffer, 0, n);
               paneauu.setText(text);
               in.close();
            }
         } else if (cmd == sauvgarder) {
            int code = chooser.showOpenDialog(paneauu);
            if (code == JFileChooser.APPROVE_OPTION) {
               File selectedFile = chooser.getSelectedFile();
               fileName = selectedFile.getName();
               FileOutputStream fos = 
                  new FileOutputStream(selectedFile);
               OutputStreamWriter out = 
                  new OutputStreamWriter(fos, Charset.forName("UTF-8")); 
               out.write(paneauu.getText());
               out.close();
            }
         }
      } catch (Exception f) {
      	 f.printStackTrace();
      }
   }
   public static void main(String[] a) {
	      (new editeur_texte()).OuvrirFenetre();
	   system.out.println("hello");
	   }
}

