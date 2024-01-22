
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    View() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        
        // Add columns to the table model
        for (int i = 1; i <= table.getColumnCount(); i++) {
            tableModel.addColumn(table.getColumnName(i - 1));
        }

         try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                Object[] rowData = new Object[table.getColumnCount()];
                for (int i = 1; i <= table.getColumnCount(); i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == search) {
        String query = "select * from employee where empId = '" + cemployeeId.getSelectedItem() + "'";
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery(query);

            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model (outside the loop)
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            table.setModel(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == print) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == update) {
        setVisible(false);
        new Update(cemployeeId.getSelectedItem());
    } else {
        setVisible(false);
        new Screen();
    }
}


    public static void main(String[] args) {
        new View();
    }
}


