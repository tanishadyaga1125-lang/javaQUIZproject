import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

 class Quiz extends JFrame implements ActionListener {

    JLabel question;
    JRadioButton op1, op2, op3, op4;
    JButton nextBtn;
    ButtonGroup bg;

    int score = 0;
    String correctAnswer;

    ResultSet rs;

    public Quiz() {
        setTitle("Quiz");
        setSize(500, 300);
        setLayout(null);

        question = new JLabel();
        question.setBounds(20, 20, 450, 30);
        add(question);

        op1 = new JRadioButton();
        op1.setBounds(20, 60, 200, 30);
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(20, 90, 200, 30);
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(20, 120, 200, 30);
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(20, 150, 200, 30);
        add(op4);

        bg = new ButtonGroup();
        bg.add(op1); bg.add(op2); bg.add(op3); bg.add(op4);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(180, 200, 100, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        loadQuestions();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void loadQuestions() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM questions");

            loadNext();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void loadNext() {
        try {
            if (rs.next()) {
                question.setText(rs.getString("question"));
                op1.setText(rs.getString("option1"));
                op2.setText(rs.getString("option2"));
                op3.setText(rs.getString("option3"));
                op4.setText(rs.getString("option4"));
                correctAnswer = rs.getString("answer");
                bg.clearSelection();
            } else {
                new Result(score);
                dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String selected = "";

        if (op1.isSelected()) selected = op1.getText();
        if (op2.isSelected()) selected = op2.getText();
        if (op3.isSelected()) selected = op3.getText();
        if (op4.isSelected()) selected = op4.getText();

        if (selected.equals(correctAnswer)) {
            score++;
        }

        loadNext();
    }
}