import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Christopher Kurcz
 */

public final class RoomSchedulerMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form RoomSchedulerMainFrame
     */
    public RoomSchedulerMainFrame() {
        initComponents();
        rebuildFacultyComboBoxes();
        rebuildDateComboBoxes();
        rebuildRoomComboBoxes();
        rebuildReservationsTable();
        rebuildWaitlistTable();
        rebuildFacultyStatusTable();
    }
    
    
    public void rebuildFacultyComboBoxes(){
        reserveFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(FacultyQueries.getFacultyList().toArray()));
        cancellationFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(FacultyQueries.getFacultyList().toArray()));
        facultyStatusFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(FacultyQueries.getFacultyList().toArray()));    
    }
    
    public void rebuildDateComboBoxes(){
        reserveScheduleDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(DateQueries.getDateList().toArray())); 
        reserveDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(DateQueries.getDateList().toArray()));
        cancellationDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(DateQueries.getDateList().toArray()));
    }
    
    public void rebuildRoomComboBoxes(){
        ArrayList<Room> rooms = RoomQueries.getRoomListByName();
        String[] roomArray = new String[rooms.size()];
        for (int i = 0; i < rooms.size(); i++){
            roomArray[i] = rooms.get(i).getName() + " ("+rooms.get(i).getSeats()+" seats)";
        }
        removeRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel(roomArray)); 
    }

    
    public void rebuildReservationsTable(){
        ArrayList<ReservationEntry> reservations = ReservationsQueries.getReservationsList();
        String[][] reservationsTableArray = new String[reservations.size()][3];
        for(int i = 0; i < reservations.size(); i++){
            reservationsTableArray[i][0] = reservations.get(i).getFaculty();
            reservationsTableArray[i][1] = reservations.get(i).getRoom().getName();
            reservationsTableArray[i][2] = reservations.get(i).getDate().toString();
        }
        
        reservationScheduleTable.setModel(new javax.swing.table.DefaultTableModel( 
            reservationsTableArray,
            new String [] {
                "Faculty Name", "Reserved Room", "Date"
            }
        ));
    }
    
    
    public void rebuildReservationsTableBySingleDate(Date date){
        ArrayList<ReservationEntry> reservations = ReservationsQueries.getReservationsBySingleDate(date);
        String[][] reservationsTableArray = new String[reservations.size()][2];
        for(int i = 0; i < reservations.size(); i++){
            reservationsTableArray[i][0] = reservations.get(i).getFaculty();
            reservationsTableArray[i][1] = reservations.get(i).getRoom().getName();
        }
        
        reservationScheduleTable.setModel(new javax.swing.table.DefaultTableModel( 
            reservationsTableArray,
            new String [] {
                "Faculty Name", "Reserved Room"
            }
        ));
    }
    
    
    public void rebuildWaitlistTable(){
        ArrayList<ReservationEntry> waitlist = ReservationsQueries.getWaitlistByDate();
        String[][] waitlistTableArray = new String[waitlist.size()][3];
        for(int i = 0; i < waitlist.size(); i++){
            waitlistTableArray[i][0] = waitlist.get(i).getFaculty();
            waitlistTableArray[i][1] = waitlist.get(i).getDate().toString();
            waitlistTableArray[i][2] = String.valueOf(waitlist.get(i).getSeats());
        }
        
        waitlistTable.setModel(new javax.swing.table.DefaultTableModel( 
            waitlistTableArray,
            new String [] {
                "Faculty Name", "Reservation Date", "Number of Seats"
            }
        ));
    }
    
    
    public void rebuildFacultyStatusTable(){
        String[][] facultyStatusTableArray = new String[0][2];
        
        facultyStatusTable.setModel(new javax.swing.table.DefaultTableModel( 
            facultyStatusTableArray,
            new String [] {
                "Reservation Date", "Room Name"
            }
        ));
    }
    
    
    public void rebuildFacultyStatusTableBySingleFaculty(String faculty){
        ArrayList<ReservationEntry> reservations = ReservationsQueries.getReservationsBySingleFaculty(faculty);
        String[][] reservationsTableArray = new String[reservations.size()][2];
        for(int i = 0; i < reservations.size(); i++){
            reservationsTableArray[i][0] = reservations.get(i).getDate().toString();
            reservationsTableArray[i][1] = reservations.get(i).getRoom().getName();
        }
        
        facultyStatusTable.setModel(new javax.swing.table.DefaultTableModel( 
            reservationsTableArray,
            new String [] {
                "Reservation Date", "Room Name"
            }
        ));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        reservationSchedulePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservationScheduleTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        reserveScheduleDateComboBox = new javax.swing.JComboBox<>();
        reserveScheduleApplyButton = new javax.swing.JButton();
        reserveScheduleClearButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        scheduleTableOptionsStatusLabel = new javax.swing.JLabel();
        reserveRoomPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        reserveFacultyComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        reserveDateComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        reserveSeatsTextField = new javax.swing.JTextField();
        reserveSubmitButton = new javax.swing.JButton();
        reserveStatusLabel = new javax.swing.JLabel();
        waitlistPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        waitlistTable = new javax.swing.JTable();
        facultyStatusPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        facultyStatusFacultyComboBox = new javax.swing.JComboBox<>();
        facultyStatusApplyButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        facultyStatusTable = new javax.swing.JTable();
        facultyStatusTableOptionsStatusLabel = new javax.swing.JLabel();
        cancelReservationPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cancellationFacultyComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cancellationDateComboBox = new javax.swing.JComboBox<>();
        cancellationSubmitButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        cancellationStatusTextArea = new javax.swing.JTextArea();
        addFacultyPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        newFacultyNameTextField = new javax.swing.JTextField();
        newFacultySubmitButton = new javax.swing.JButton();
        newFacultyStatusLabel = new javax.swing.JLabel();
        addDatePanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        newDateSubmitButton = new javax.swing.JButton();
        newDateStatusLabel = new javax.swing.JLabel();
        newDateSpinner = new javax.swing.JSpinner();
        addRoomPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        newRoomNameTextField = new javax.swing.JTextField();
        newRoomSubmitButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        newRoomSeatsTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        newRoomStatusTextArea = new javax.swing.JTextArea();
        dropRoomPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        removeRoomComboBox = new javax.swing.JComboBox<>();
        removeRoomButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        removeRoomStatusTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tiny College Room Scheduler");

        backgroundPanel.setBackground(new java.awt.Color(48, 50, 54));

        titleLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(75, 162, 173));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Tiny College Room Scheduler");

        mainTabbedPane.setBackground(new java.awt.Color(106, 113, 115));
        mainTabbedPane.setForeground(new java.awt.Color(188, 209, 209));
        mainTabbedPane.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        reservationSchedulePanel.setBackground(new java.awt.Color(106, 113, 115));

        jScrollPane2.setBorder(null);

        reservationScheduleTable.setBackground(new java.awt.Color(48, 50, 54));
        reservationScheduleTable.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        reservationScheduleTable.setForeground(new java.awt.Color(188, 209, 209));
        reservationScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(reservationScheduleTable);

        jLabel5.setBackground(new java.awt.Color(48, 50, 54));
        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(75, 162, 173));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Table Options");

        reserveScheduleDateComboBox.setBackground(new java.awt.Color(48, 50, 54));
        reserveScheduleDateComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        reserveScheduleDateComboBox.setForeground(new java.awt.Color(188, 209, 209));
        reserveScheduleDateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        reserveScheduleApplyButton.setBackground(new java.awt.Color(75, 162, 173));
        reserveScheduleApplyButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        reserveScheduleApplyButton.setForeground(new java.awt.Color(188, 209, 209));
        reserveScheduleApplyButton.setText("Apply");
        reserveScheduleApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveScheduleApplyButtonActionPerformed(evt);
            }
        });

        reserveScheduleClearButton.setBackground(new java.awt.Color(75, 162, 173));
        reserveScheduleClearButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        reserveScheduleClearButton.setForeground(new java.awt.Color(188, 209, 209));
        reserveScheduleClearButton.setText("Clear");
        reserveScheduleClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveScheduleClearButtonActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(48, 50, 54));
        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(188, 209, 209));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Please select date:");

        scheduleTableOptionsStatusLabel.setBackground(new java.awt.Color(48, 50, 54));
        scheduleTableOptionsStatusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        scheduleTableOptionsStatusLabel.setForeground(new java.awt.Color(188, 209, 209));
        scheduleTableOptionsStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout reservationSchedulePanelLayout = new javax.swing.GroupLayout(reservationSchedulePanel);
        reservationSchedulePanel.setLayout(reservationSchedulePanelLayout);
        reservationSchedulePanelLayout.setHorizontalGroup(
            reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationSchedulePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationSchedulePanelLayout.createSequentialGroup()
                        .addGroup(reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reserveScheduleDateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationSchedulePanelLayout.createSequentialGroup()
                                .addComponent(reserveScheduleApplyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reserveScheduleClearButton))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addComponent(scheduleTableOptionsStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        reservationSchedulePanelLayout.setVerticalGroup(
            reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationSchedulePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reservationSchedulePanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reserveScheduleDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(reservationSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reserveScheduleApplyButton)
                            .addComponent(reserveScheduleClearButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scheduleTableOptionsStatusLabel)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Reservation Schedule", reservationSchedulePanel);

        reserveRoomPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel2.setBackground(new java.awt.Color(48, 50, 54));
        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(188, 209, 209));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Please select faculty member:");

        reserveFacultyComboBox.setBackground(new java.awt.Color(48, 50, 54));
        reserveFacultyComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        reserveFacultyComboBox.setForeground(new java.awt.Color(188, 209, 209));
        reserveFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setBackground(new java.awt.Color(48, 50, 54));
        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(188, 209, 209));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Please select date:");

        reserveDateComboBox.setBackground(new java.awt.Color(48, 50, 54));
        reserveDateComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        reserveDateComboBox.setForeground(new java.awt.Color(188, 209, 209));
        reserveDateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setBackground(new java.awt.Color(48, 50, 54));
        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(188, 209, 209));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Please enter number of seats:");

        reserveSeatsTextField.setBackground(new java.awt.Color(48, 50, 54));
        reserveSeatsTextField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        reserveSeatsTextField.setForeground(new java.awt.Color(188, 209, 209));

        reserveSubmitButton.setBackground(new java.awt.Color(75, 162, 173));
        reserveSubmitButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        reserveSubmitButton.setForeground(new java.awt.Color(188, 209, 209));
        reserveSubmitButton.setText("Submit");
        reserveSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveSubmitButtonActionPerformed(evt);
            }
        });

        reserveStatusLabel.setBackground(new java.awt.Color(48, 50, 54));
        reserveStatusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        reserveStatusLabel.setForeground(new java.awt.Color(188, 209, 209));
        reserveStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout reserveRoomPanelLayout = new javax.swing.GroupLayout(reserveRoomPanel);
        reserveRoomPanel.setLayout(reserveRoomPanelLayout);
        reserveRoomPanelLayout.setHorizontalGroup(
            reserveRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserveRoomPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(reserveRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reserveStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reserveRoomPanelLayout.createSequentialGroup()
                        .addComponent(reserveSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reserveSubmitButton))
                    .addComponent(reserveDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reserveFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        reserveRoomPanelLayout.setVerticalGroup(
            reserveRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserveRoomPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reserveFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reserveDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reserveRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reserveSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reserveSubmitButton))
                .addGap(18, 18, 18)
                .addComponent(reserveStatusLabel)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Reserve a Room", reserveRoomPanel);

        waitlistPanel.setBackground(new java.awt.Color(106, 113, 115));

        jScrollPane1.setBorder(null);

        waitlistTable.setBackground(new java.awt.Color(48, 50, 54));
        waitlistTable.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        waitlistTable.setForeground(new java.awt.Color(188, 209, 209));
        waitlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(waitlistTable);

        javax.swing.GroupLayout waitlistPanelLayout = new javax.swing.GroupLayout(waitlistPanel);
        waitlistPanel.setLayout(waitlistPanelLayout);
        waitlistPanelLayout.setHorizontalGroup(
            waitlistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waitlistPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        waitlistPanelLayout.setVerticalGroup(
            waitlistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waitlistPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Waitlist", waitlistPanel);

        facultyStatusPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel7.setBackground(new java.awt.Color(48, 50, 54));
        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(75, 162, 173));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Table Options");

        jLabel8.setBackground(new java.awt.Color(48, 50, 54));
        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(188, 209, 209));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Please select faculty:");

        facultyStatusFacultyComboBox.setBackground(new java.awt.Color(48, 50, 54));
        facultyStatusFacultyComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        facultyStatusFacultyComboBox.setForeground(new java.awt.Color(188, 209, 209));
        facultyStatusFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        facultyStatusApplyButton.setBackground(new java.awt.Color(75, 162, 173));
        facultyStatusApplyButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        facultyStatusApplyButton.setForeground(new java.awt.Color(188, 209, 209));
        facultyStatusApplyButton.setText("Apply");
        facultyStatusApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyStatusApplyButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);

        facultyStatusTable.setBackground(new java.awt.Color(48, 50, 54));
        facultyStatusTable.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        facultyStatusTable.setForeground(new java.awt.Color(188, 209, 209));
        facultyStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(facultyStatusTable);

        facultyStatusTableOptionsStatusLabel.setBackground(new java.awt.Color(48, 50, 54));
        facultyStatusTableOptionsStatusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        facultyStatusTableOptionsStatusLabel.setForeground(new java.awt.Color(188, 209, 209));
        facultyStatusTableOptionsStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout facultyStatusPanelLayout = new javax.swing.GroupLayout(facultyStatusPanel);
        facultyStatusPanel.setLayout(facultyStatusPanelLayout);
        facultyStatusPanelLayout.setHorizontalGroup(
            facultyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facultyStatusPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(facultyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(facultyStatusApplyButton)
                    .addComponent(facultyStatusFacultyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facultyStatusTableOptionsStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        facultyStatusPanelLayout.setVerticalGroup(
            facultyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facultyStatusPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(facultyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(facultyStatusPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(facultyStatusFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(facultyStatusApplyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(facultyStatusTableOptionsStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        mainTabbedPane.addTab("Faculty Reservations Status", facultyStatusPanel);

        cancelReservationPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel9.setBackground(new java.awt.Color(48, 50, 54));
        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(188, 209, 209));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Please select faculty member:");

        cancellationFacultyComboBox.setBackground(new java.awt.Color(48, 50, 54));
        cancellationFacultyComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        cancellationFacultyComboBox.setForeground(new java.awt.Color(188, 209, 209));
        cancellationFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setBackground(new java.awt.Color(48, 50, 54));
        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(188, 209, 209));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Please select date:");

        cancellationDateComboBox.setBackground(new java.awt.Color(48, 50, 54));
        cancellationDateComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        cancellationDateComboBox.setForeground(new java.awt.Color(188, 209, 209));
        cancellationDateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cancellationSubmitButton.setBackground(new java.awt.Color(75, 162, 173));
        cancellationSubmitButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        cancellationSubmitButton.setForeground(new java.awt.Color(188, 209, 209));
        cancellationSubmitButton.setText("Cancel Reservation");
        cancellationSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellationSubmitButtonActionPerformed(evt);
            }
        });

        jScrollPane5.setBorder(null);

        cancellationStatusTextArea.setEditable(false);
        cancellationStatusTextArea.setBackground(new java.awt.Color(106, 113, 115));
        cancellationStatusTextArea.setColumns(20);
        cancellationStatusTextArea.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        cancellationStatusTextArea.setForeground(new java.awt.Color(188, 209, 209));
        cancellationStatusTextArea.setLineWrap(true);
        cancellationStatusTextArea.setRows(5);
        cancellationStatusTextArea.setBorder(null);
        cancellationStatusTextArea.setCaretColor(new java.awt.Color(106, 113, 115));
        jScrollPane5.setViewportView(cancellationStatusTextArea);

        javax.swing.GroupLayout cancelReservationPanelLayout = new javax.swing.GroupLayout(cancelReservationPanel);
        cancelReservationPanel.setLayout(cancelReservationPanelLayout);
        cancelReservationPanelLayout.setHorizontalGroup(
            cancelReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelReservationPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(cancelReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cancelReservationPanelLayout.createSequentialGroup()
                        .addComponent(cancellationDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancellationSubmitButton))
                    .addComponent(cancellationFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        cancelReservationPanelLayout.setVerticalGroup(
            cancelReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelReservationPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancellationFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cancelReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancellationDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancellationSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Cancel Reservation", cancelReservationPanel);

        addFacultyPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel1.setBackground(new java.awt.Color(48, 50, 54));
        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(188, 209, 209));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Please enter the new faculty member's name:");

        newFacultyNameTextField.setBackground(new java.awt.Color(48, 50, 54));
        newFacultyNameTextField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        newFacultyNameTextField.setForeground(new java.awt.Color(188, 209, 209));

        newFacultySubmitButton.setBackground(new java.awt.Color(75, 162, 173));
        newFacultySubmitButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newFacultySubmitButton.setForeground(new java.awt.Color(188, 209, 209));
        newFacultySubmitButton.setText("Submit");
        newFacultySubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFacultySubmitButtonActionPerformed(evt);
            }
        });

        newFacultyStatusLabel.setBackground(new java.awt.Color(48, 50, 54));
        newFacultyStatusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newFacultyStatusLabel.setForeground(new java.awt.Color(188, 209, 209));
        newFacultyStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newFacultyStatusLabel.setText(" ");

        javax.swing.GroupLayout addFacultyPanelLayout = new javax.swing.GroupLayout(addFacultyPanel);
        addFacultyPanel.setLayout(addFacultyPanelLayout);
        addFacultyPanelLayout.setHorizontalGroup(
            addFacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFacultyPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addFacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newFacultyStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addFacultyPanelLayout.createSequentialGroup()
                        .addGroup(addFacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newFacultyNameTextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newFacultySubmitButton)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        addFacultyPanelLayout.setVerticalGroup(
            addFacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFacultyPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addFacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFacultyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newFacultySubmitButton))
                .addGap(18, 18, 18)
                .addComponent(newFacultyStatusLabel)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Add Faculty", addFacultyPanel);

        addDatePanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel11.setBackground(new java.awt.Color(48, 50, 54));
        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(188, 209, 209));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Please enter the new date:");

        newDateSubmitButton.setBackground(new java.awt.Color(75, 162, 173));
        newDateSubmitButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newDateSubmitButton.setForeground(new java.awt.Color(188, 209, 209));
        newDateSubmitButton.setText("Submit");
        newDateSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDateSubmitButtonActionPerformed(evt);
            }
        });

        newDateStatusLabel.setBackground(new java.awt.Color(48, 50, 54));
        newDateStatusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newDateStatusLabel.setForeground(new java.awt.Color(188, 209, 209));
        newDateStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newDateStatusLabel.setText(" ");

        newDateSpinner.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        newDateSpinner.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout addDatePanelLayout = new javax.swing.GroupLayout(addDatePanel);
        addDatePanel.setLayout(addDatePanelLayout);
        addDatePanelLayout.setHorizontalGroup(
            addDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDatePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newDateStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addDatePanelLayout.createSequentialGroup()
                        .addComponent(newDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newDateSubmitButton))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        addDatePanelLayout.setVerticalGroup(
            addDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDatePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDateSubmitButton)
                    .addComponent(newDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(newDateStatusLabel)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Add Date", addDatePanel);

        addRoomPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel12.setBackground(new java.awt.Color(48, 50, 54));
        jLabel12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(188, 209, 209));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Please enter the new room's name:");

        newRoomNameTextField.setBackground(new java.awt.Color(48, 50, 54));
        newRoomNameTextField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        newRoomNameTextField.setForeground(new java.awt.Color(188, 209, 209));

        newRoomSubmitButton.setBackground(new java.awt.Color(75, 162, 173));
        newRoomSubmitButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newRoomSubmitButton.setForeground(new java.awt.Color(188, 209, 209));
        newRoomSubmitButton.setText("Submit");
        newRoomSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoomSubmitButtonActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(48, 50, 54));
        jLabel13.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(188, 209, 209));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Please enter the number of seats:");

        newRoomSeatsTextField.setBackground(new java.awt.Color(48, 50, 54));
        newRoomSeatsTextField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        newRoomSeatsTextField.setForeground(new java.awt.Color(188, 209, 209));

        jScrollPane4.setBorder(null);

        newRoomStatusTextArea.setEditable(false);
        newRoomStatusTextArea.setBackground(new java.awt.Color(106, 113, 115));
        newRoomStatusTextArea.setColumns(20);
        newRoomStatusTextArea.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        newRoomStatusTextArea.setForeground(new java.awt.Color(188, 209, 209));
        newRoomStatusTextArea.setLineWrap(true);
        newRoomStatusTextArea.setRows(5);
        newRoomStatusTextArea.setBorder(null);
        newRoomStatusTextArea.setCaretColor(new java.awt.Color(106, 113, 115));
        jScrollPane4.setViewportView(newRoomStatusTextArea);

        javax.swing.GroupLayout addRoomPanelLayout = new javax.swing.GroupLayout(addRoomPanel);
        addRoomPanel.setLayout(addRoomPanelLayout);
        addRoomPanelLayout.setHorizontalGroup(
            addRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(addRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addRoomPanelLayout.createSequentialGroup()
                        .addGroup(addRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newRoomNameTextField)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(newRoomSeatsTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newRoomSubmitButton)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        addRoomPanelLayout.setVerticalGroup(
            addRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newRoomNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRoomSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newRoomSubmitButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Add Room", addRoomPanel);

        dropRoomPanel.setBackground(new java.awt.Color(106, 113, 115));

        jLabel14.setBackground(new java.awt.Color(48, 50, 54));
        jLabel14.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(188, 209, 209));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Please select room to remove:");

        removeRoomComboBox.setBackground(new java.awt.Color(48, 50, 54));
        removeRoomComboBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        removeRoomComboBox.setForeground(new java.awt.Color(188, 209, 209));
        removeRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        removeRoomButton.setBackground(new java.awt.Color(75, 162, 173));
        removeRoomButton.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        removeRoomButton.setForeground(new java.awt.Color(188, 209, 209));
        removeRoomButton.setText("Remove Room");
        removeRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRoomButtonActionPerformed(evt);
            }
        });

        jScrollPane6.setBorder(null);

        removeRoomStatusTextArea.setEditable(false);
        removeRoomStatusTextArea.setBackground(new java.awt.Color(106, 113, 115));
        removeRoomStatusTextArea.setColumns(20);
        removeRoomStatusTextArea.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        removeRoomStatusTextArea.setForeground(new java.awt.Color(188, 209, 209));
        removeRoomStatusTextArea.setLineWrap(true);
        removeRoomStatusTextArea.setRows(5);
        removeRoomStatusTextArea.setBorder(null);
        removeRoomStatusTextArea.setCaretColor(new java.awt.Color(106, 113, 115));
        jScrollPane6.setViewportView(removeRoomStatusTextArea);

        javax.swing.GroupLayout dropRoomPanelLayout = new javax.swing.GroupLayout(dropRoomPanel);
        dropRoomPanel.setLayout(dropRoomPanelLayout);
        dropRoomPanelLayout.setHorizontalGroup(
            dropRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropRoomPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(dropRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dropRoomPanelLayout.createSequentialGroup()
                        .addGroup(dropRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(removeRoomComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeRoomButton)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        dropRoomPanelLayout.setVerticalGroup(
            dropRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropRoomPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dropRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeRoomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeRoomButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Drop Room", dropRoomPanel);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainTabbedPane)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFacultySubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFacultySubmitButtonActionPerformed
        String name = newFacultyNameTextField.getText();
        if (name.length() > 50){
            newFacultyStatusLabel.setText("Name entered is too long.");
        } else if (FacultyQueries.inFacultyList(name)){
            newFacultyStatusLabel.setText(name+" is already a faculty member.");
        } else {
            FacultyQueries.addFaculty(name);
            newFacultyStatusLabel.setText(name+" has been successfully added to the faculty. Welcome to Tiny College!");
        }
        
        // rebuild the reservation faculty combo box.
        rebuildFacultyComboBoxes();
    }//GEN-LAST:event_newFacultySubmitButtonActionPerformed

    private void reserveSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveSubmitButtonActionPerformed
        String faculty = reserveFacultyComboBox.getSelectedItem().toString();
        Date date = (Date)reserveDateComboBox.getSelectedItem();
        int seats = Integer.parseInt(reserveSeatsTextField.getText());
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        if (!ReservationsQueries.facultyDateInReservationList(faculty,date)){
            ReservationEntry newReservationEntry = new ReservationEntry(faculty, new Room("Waitlisted",0), date, seats, currentTimestamp, true);
            ReservationsQueries.addReservationEntry(newReservationEntry);
            
            Room roomReceived = ReservationsQueries.getRoomByFacultyDate(faculty, date);
            if (roomReceived != null){
                reserveStatusLabel.setText("Reservation for "+faculty+" on "+date+" with "+seats+" seats successfully created. Scheduled room: "+roomReceived.getName());
            } else {
                reserveStatusLabel.setText("Reservation for "+faculty+" on "+date+" with "+seats+" seats successfully created. Status: Waitlisted");
            }
                
            rebuildReservationsTable();
            rebuildWaitlistTable();
        } else {
            reserveStatusLabel.setText("Reservation for "+faculty+" on "+date+" has already been made");
        }  
    }//GEN-LAST:event_reserveSubmitButtonActionPerformed

    private void reserveScheduleApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveScheduleApplyButtonActionPerformed
        Date date = (Date)reserveScheduleDateComboBox.getSelectedItem();
        rebuildReservationsTableBySingleDate(date);
        scheduleTableOptionsStatusLabel.setText("Options applied");
    }//GEN-LAST:event_reserveScheduleApplyButtonActionPerformed

    private void reserveScheduleClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveScheduleClearButtonActionPerformed
        rebuildReservationsTable();
        scheduleTableOptionsStatusLabel.setText("Options cleared");
    }//GEN-LAST:event_reserveScheduleClearButtonActionPerformed

    private void facultyStatusApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyStatusApplyButtonActionPerformed
        String facultyName = facultyStatusFacultyComboBox.getSelectedItem().toString();
        rebuildFacultyStatusTableBySingleFaculty(facultyName);
        facultyStatusTableOptionsStatusLabel.setText("Options applied");
    }//GEN-LAST:event_facultyStatusApplyButtonActionPerformed

    private void cancellationSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellationSubmitButtonActionPerformed
        String facultyName = cancellationFacultyComboBox.getSelectedItem().toString();
        Date date = (Date)cancellationDateComboBox.getSelectedItem();
        if (ReservationsQueries.facultyDateInReservationList(facultyName, date)){
            ReservationsQueries.removeReservationEntry(facultyName, date);
            cancellationStatusTextArea.setText("Reservation for "+facultyName+" on "+date.toString()+" has been successfully removed.");
            rebuildReservationsTable();
            rebuildWaitlistTable();
            rebuildFacultyStatusTable();
        } else {
            cancellationStatusTextArea.setText("Reservation for "+facultyName+" on "+date.toString()+" does not exist.");
        }
    }//GEN-LAST:event_cancellationSubmitButtonActionPerformed

    private void newDateSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDateSubmitButtonActionPerformed
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String spinnerValue = formater.format(newDateSpinner.getValue());
        Date newDate = Date.valueOf(spinnerValue);
        
        if (DateQueries.inDateList(newDate)){
            newDateStatusLabel.setText(newDate.toString()+" is already in the dates list.");
        } else {
            DateQueries.addDate(newDate);
            newDateStatusLabel.setText(newDate.toString()+" has been successfully added to the dates list.");
        }
        
        rebuildDateComboBoxes();
    }//GEN-LAST:event_newDateSubmitButtonActionPerformed

    private void newRoomSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoomSubmitButtonActionPerformed
        String name = newRoomNameTextField.getText();
        int seats = Integer.parseInt(newRoomSeatsTextField.getText());
        
        if (RoomQueries.inRoomList(name)){
            newRoomStatusTextArea.setText("A room with name "+name+" is already in the rooms list");
        } else {
            Room newRoom = new Room(name, seats);
            RoomQueries.addRoom(newRoom);
            newRoomStatusTextArea.setText("A room with "+seats+" seats and name "+name+" has been successfully added to the rooms list.");
        }
        
        rebuildReservationsTable();
        rebuildWaitlistTable();
        rebuildFacultyStatusTable();
        rebuildRoomComboBoxes();
    }//GEN-LAST:event_newRoomSubmitButtonActionPerformed

    private void removeRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRoomButtonActionPerformed
        int roomIndex = removeRoomComboBox.getSelectedIndex();
        Room selectedRoom = RoomQueries.getRoomListByName().get(roomIndex);
        if (selectedRoom != null){
            if (RoomQueries.inRoomList(selectedRoom.getName())){
                RoomQueries.removeRoom(selectedRoom);
                removeRoomStatusTextArea.setText("Room with name "+selectedRoom.getName()+" has been successfully removed.");
                
                ReservationsQueries.updateReservations();
            }
        }
        
        rebuildReservationsTable();
        rebuildWaitlistTable();
        rebuildFacultyStatusTable();
        rebuildRoomComboBoxes();
    }//GEN-LAST:event_removeRoomButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoomSchedulerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomSchedulerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomSchedulerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomSchedulerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomSchedulerMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDatePanel;
    private javax.swing.JPanel addFacultyPanel;
    private javax.swing.JPanel addRoomPanel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel cancelReservationPanel;
    private javax.swing.JComboBox<String> cancellationDateComboBox;
    private javax.swing.JComboBox<String> cancellationFacultyComboBox;
    private javax.swing.JTextArea cancellationStatusTextArea;
    private javax.swing.JButton cancellationSubmitButton;
    private javax.swing.JPanel dropRoomPanel;
    private javax.swing.JButton facultyStatusApplyButton;
    private javax.swing.JComboBox<String> facultyStatusFacultyComboBox;
    private javax.swing.JPanel facultyStatusPanel;
    private javax.swing.JTable facultyStatusTable;
    private javax.swing.JLabel facultyStatusTableOptionsStatusLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JSpinner newDateSpinner;
    private javax.swing.JLabel newDateStatusLabel;
    private javax.swing.JButton newDateSubmitButton;
    private javax.swing.JTextField newFacultyNameTextField;
    private javax.swing.JLabel newFacultyStatusLabel;
    private javax.swing.JButton newFacultySubmitButton;
    private javax.swing.JTextField newRoomNameTextField;
    private javax.swing.JTextField newRoomSeatsTextField;
    private javax.swing.JTextArea newRoomStatusTextArea;
    private javax.swing.JButton newRoomSubmitButton;
    private javax.swing.JButton removeRoomButton;
    private javax.swing.JComboBox<String> removeRoomComboBox;
    private javax.swing.JTextArea removeRoomStatusTextArea;
    private javax.swing.JPanel reservationSchedulePanel;
    private javax.swing.JTable reservationScheduleTable;
    private javax.swing.JComboBox<String> reserveDateComboBox;
    private javax.swing.JComboBox<String> reserveFacultyComboBox;
    private javax.swing.JPanel reserveRoomPanel;
    private javax.swing.JButton reserveScheduleApplyButton;
    private javax.swing.JButton reserveScheduleClearButton;
    private javax.swing.JComboBox<String> reserveScheduleDateComboBox;
    private javax.swing.JTextField reserveSeatsTextField;
    private javax.swing.JLabel reserveStatusLabel;
    private javax.swing.JButton reserveSubmitButton;
    private javax.swing.JLabel scheduleTableOptionsStatusLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel waitlistPanel;
    private javax.swing.JTable waitlistTable;
    // End of variables declaration//GEN-END:variables
}
