package datvetaufx;

import com.mycompany.datvetausever.entities.CarriageTrainEntity;
import com.mycompany.datvetausever.entities.SeatEntity;
import com.mycompany.datvetausever.entities.StationEntity;
import com.mycompany.datvetausever.entities.TrainEntity;
import datvetaufx.client.Client;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class JFrame extends javax.swing.JFrame {

    private static TrainEntity trainEntityIn = null;

    public JFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();
        buyTicket = new javax.swing.JButton();
        fromStation = new javax.swing.JComboBox<>();
        toStation = new javax.swing.JComboBox<>();
        train = new javax.swing.JComboBox<>();
        carriageTrain = new javax.swing.JComboBox<>();
        seat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        departureDate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        identityNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        buyTicket.setText("Mua");
        buyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyTicketActionPerformed(evt);
            }
        });

        fromStation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        toStation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        train.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainActionPerformed(evt);
            }
        });

        carriageTrain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        carriageTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carriageTrainActionPerformed(evt);
            }
        });

        seat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatActionPerformed(evt);
            }
        });

        jLabel1.setText("Thông Tin Hành Trình");

        jLabel2.setText("Ga đi");

        jLabel3.setText("Ga đến");

        jLabel4.setText("Ngày đi");

        jLabel5.setText("Chọn vé");

        jLabel6.setText("Chọn Tàu");

        jLabel7.setText("Chọn Toa");

        jLabel8.setText("Chọn Vé");

        jLabel9.setText("Tên Người Mua");

        jLabel10.setText("Số CMND");

        fullName.setText("Full Name");

        identityNumber.setText("CMND");

        jLabel12.setText("code");

        code.setText("code");
        code.setEnabled(false);
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        jLabel11.setText("Thông tin đặt vé");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buyTicket)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fullName, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addComponent(identityNumber)
                        .addComponent(code)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(toStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fromStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(train, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carriageTrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(137, 137, 137))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel11)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(train, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carriageTrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(identityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fromStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addComponent(departureDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(buyTicket))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String toStationVaule = toStation.getSelectedItem().toString();
        String fromStationVaule = fromStation.getSelectedItem().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String departureDateVaule = sdf.format(departureDate.getDate());
        try {
            List<TrainEntity> check = Client.sendValueToSever(toStationVaule, fromStationVaule, departureDateVaule);
            JFrame jf = new JFrame();
            jf.train.removeAllItems();
            ArrayList<String> trains = new ArrayList<>();
            check.forEach((trainE) -> {
                trains.add(trainE.getTrainName());
            });
            train.setModel(new DefaultComboBoxModel(trains.toArray()));
            train.setVisible(true);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void buyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyTicketActionPerformed
        int seat_id = 47;
        String toStationVaule = toStation.getSelectedItem().toString();
        String fromStationVaule = fromStation.getSelectedItem().toString();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String departureDateVaule = sdf.format(departureDate.getDate());

            for (CarriageTrainEntity carriageTrain1 : trainEntityIn.getCarriageTrains()) {
                if (carriageTrain1.getCarriageName().equals(carriageTrain.getSelectedItem().toString())) {
                    for (SeatEntity seat1 : carriageTrain1.getSeats()) {
                        if (seat1.getSeatName().equals(seat.getSelectedItem().toString())) {
                            seat_id = seat1.getId();
                        }
                    }
                }
            }
            JFrame jf = new JFrame();
            int codeReturn = Client.insertTicket(departureDateVaule, fullName.getText(),
                    Integer.parseInt(identityNumber.getText()), fromStationVaule, seat_id, toStationVaule);

            code.setText(String.valueOf(codeReturn));
            code.setVisible(true);
            code.revalidate();
            code.repaint();

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buyTicketActionPerformed

    private void trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainActionPerformed
        try {
            String toStationVaule = toStation.getSelectedItem().toString();
            String fromStationVaule = fromStation.getSelectedItem().toString();
            String trainName = train.getSelectedItem().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String departureDateVaule = sdf.format(departureDate.getDate());

            try {
                JFrame jf = new JFrame();
                TrainEntity trainEntity = Client.findTrains(toStationVaule, fromStationVaule, departureDateVaule, trainName);
                trainEntityIn = trainEntity;

                jf.carriageTrain.removeAllItems();
                ArrayList<String> carriageTrains = new ArrayList<>();
                trainEntity.getCarriageTrains().forEach((CarriageTrain) -> {
                    carriageTrains.add(CarriageTrain.getCarriageName());
                });
                carriageTrain.setModel(new DefaultComboBoxModel(carriageTrains.toArray()));
                carriageTrain.setVisible(true);
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException techmaster1) {
        }

    }//GEN-LAST:event_trainActionPerformed

    private void carriageTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carriageTrainActionPerformed
        try {
            JFrame jf = new JFrame();
            jf.seat.removeAllItems();

            ArrayList<String> seats = new ArrayList<>();

            trainEntityIn.getCarriageTrains().forEach((CarriageTrainEntity CarriageTrain) -> {
                if (carriageTrain.getSelectedItem().toString().equals(CarriageTrain.getCarriageName())) {
                    CarriageTrain.getSeats().stream().filter((s) -> (s.isStatus())).forEachOrdered((s) -> {
                        seats.add(s.getSeatName());
                    });
                }
            });

            seat.setModel(new DefaultComboBoxModel(seats.toArray()));
            seat.setVisible(true);
        } catch (NullPointerException techmaster1) {
        }

    }//GEN-LAST:event_carriageTrainActionPerformed

    private void seatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
        try {
            JFrame jf = new JFrame();
            jf.fromStation.removeAllItems();
            List<StationEntity> stations = Client.findStations();
            stations.forEach((station) -> {
                jf.fromStation.addItem(station.getStationName());
            });

            jf.toStation.removeAllItems();
            stations.forEach((station) -> {
                jf.toStation.addItem(station.getStationName());
            });

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    jf.setVisible(true);
                }
            });
        }catch (ConnectException e){
            System.out.println("Vui long khoi dong server truoc khi chay");
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyTicket;
    private javax.swing.JComboBox<String> carriageTrain;
    private javax.swing.JTextField code;
    private com.toedter.calendar.JDateChooser departureDate;
    private javax.swing.JComboBox<String> fromStation;
    private javax.swing.JTextField fullName;
    private javax.swing.JTextField identityNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> seat;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox<String> toStation;
    private javax.swing.JComboBox<String> train;
    // End of variables declaration//GEN-END:variables
}
