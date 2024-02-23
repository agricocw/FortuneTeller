import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private JLabel titleLabel;
    private ArrayList<String> fortunes;
    private String lastFortune;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/FortuneTellerIcon.png");
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        JPanel topPanel = new JPanel();
        titleLabel = new JLabel("Fortune Teller", icon, SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        fortuneTextArea = new JTextArea(10, 30);
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        readFortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        readFortuneButton.addActionListener(e -> readFortune());
        quitButton.addActionListener(e -> quit());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation((screenWidth - getWidth()) / 4, (screenHeight - getHeight()) / 4);

        fortunes = new ArrayList<>();
        fortunes.add("You will find great fortune soon.");
        fortunes.add("Good luck will come your way.");
        fortunes.add("Expect exciting news in the near future.");
        fortunes.add("Opportunities are waiting for you.");
        fortunes.add("Your hard work will pay off handsomely.");
        fortunes.add("Adventure awaits around the corner.");
        fortunes.add("A pleasant surprise is coming your way.");
        fortunes.add("Your creativity will be your greatest asset.");
        fortunes.add("Happiness is just around the corner.");
        fortunes.add("A new friendship will enrich your life.");
        fortunes.add("You will overcome obstacles with ease.");
        fortunes.add("Unexpected joy will brighten your day.");

        lastFortune = "";
    }

    private void readFortune() {
        Random random = new Random();
        String newFortune = lastFortune;
        while (newFortune.equals(lastFortune)) {
            newFortune = fortunes.get(random.nextInt(fortunes.size()));
        }
        lastFortune = newFortune;
        fortuneTextArea.append(newFortune + "\n");
    }

    private void quit() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
