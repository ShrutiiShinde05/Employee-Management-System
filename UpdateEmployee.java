package employee.management.stystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton update, back;
    JDateChooser tdob;

    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;

        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 300, 150, 30);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600, 300, 150, 30);
        add(tdesignation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(50, 350, 150, 30);
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(200, 350, 150, 30);
        add(taadhar);

        JLabel emp = new JLabel("Employee ID");
        emp.setBounds(400, 350, 150, 30);
        add(emp);

        tempid = new JLabel(empId);
        tempid.setBounds(600, 350, 150, 30);
        add(tempid);

        // 🔥 FETCH DATA FROM DB
        try {
            conn c = new conn();
            String query = "select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.statement.executeQuery(query);

            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tdesignation.setText(rs.getString("designation"));
                taadhar.setText(rs.getString("aadhar")); // ✅ FIXED HERE
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // BUTTONS
        update = new JButton("Update");
        update.setBounds(250, 500, 150, 40);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 500, 150, 40);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == update) {

            String name = tname.getText();
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String designation = tdesignation.getText();
            String aadhar = taadhar.getText();

            try {
                conn c = new conn();

                String query = "update employee set name='" + name +
                        "', fname='" + fname +
                        "', salary='" + salary +
                        "', address='" + address +
                        "', phone='" + phone +
                        "', email='" + email +
                        "', designation='" + designation +
                        "', aadhar='" + aadhar +
                        "' where empId='" + empId + "'";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new View_Employee();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("1");
    }
}