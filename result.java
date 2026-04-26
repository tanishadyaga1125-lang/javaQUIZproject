import javax.swing.*;

 class Result extends JFrame {

    public Result(int score) {
        setTitle("Result");
        setSize(300, 200);
        setLayout(null);

        JLabel result = new JLabel("Your Score: " + score);
        result.setBounds(80, 60, 150, 30);
        add(result);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}