/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Agil
 */
public class Cont {
    ModMovie modelContact;
    ViewMovie movieView;
    public String data;
    public Cont(ModMovie modelContact, ViewMovie movieView){
        this.modelContact = modelContact;
        this.movieView = movieView;
        
        if (modelContact.getBanyakData()!=0) {
            String dataMovie[][] = modelContact.readContact();
            movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         movieView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = movieView.getJudul();
                double Alur = Double.parseDouble(movieView.getAlur());
                double Penokohan = Double.parseDouble(movieView.getPenokohan());
                double Akting = Double.parseDouble(movieView.getAkting());
                double Rating = (Alur+Penokohan+Akting)/3;
                modelContact.insertData(Judul, Alur, Penokohan, Akting, Rating);
         
                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = movieView.getJudul();
                double Alur = Double.parseDouble(movieView.getAlur());
                double Penokohan = Double.parseDouble(movieView.getPenokohan());
                double Akting = Double.parseDouble(movieView.getAkting());
                double Rating = (Alur+Penokohan+Akting)/3;
                modelContact.updateData(Judul, Alur, Penokohan, Akting, Rating);

                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                movieView.tfJudul.setText("");
                movieView.tfAlur.setText("");
                movieView.tfPenokohan.setText("");
                movieView.tfAkting.setText("");
            }
        });
        
    
          movieView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = movieView.tabel.getSelectedRow();
                data = movieView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = movieView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = movieView.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelContact.deleteContact(data);
                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}