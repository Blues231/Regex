package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex 
{

    private JFrame frame;
    private JTextField regularExpression;
    private JTextArea testString;
    private JTextArea matchInformation;

    public JFrame getFrame() 
    {
        return frame;
    }

    public void setFrame(JFrame frame) 
    {
        this.frame = frame;
    }

    public regex() 
    {
        initialize();
    }

    private void initialize() 
    {

        setFrame(new JFrame("Regular Expression"));
        getFrame().getContentPane().setBackground(new Color(34, 228, 202));
        getFrame().setBounds(600, 250, 800, 500);
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getFrame().getContentPane().setLayout(null);

        JLabel labelRegularExpression = new JLabel("Enter your regex");
        labelRegularExpression.setBounds(50, 50, 300, 35);
        getFrame().add(labelRegularExpression);

        regularExpression = new JTextField();
        regularExpression.setBounds(50, 100, 300, 30);
        getFrame().getContentPane().add(regularExpression);
        regularExpression.setColumns(10);

        JLabel labelTestString = new JLabel("Test string :");
        labelTestString.setBounds(50, 150, 300, 35);
        getFrame().add(labelTestString);

        testString = new JTextArea();
        testString.setBounds(50, 200, 300, 65);
        getFrame().getContentPane().add(testString);
        testString.setColumns(10);

        JLabel labelMatchInfo = new JLabel("MatchInfo");
        labelMatchInfo.setBounds(400, 0, 220, 150);
        getFrame().add(labelMatchInfo);

        matchInformation = new JTextArea();
        matchInformation.setEditable(false);
        JScrollPane scroll = new JScrollPane(matchInformation);
        matchInformation.setBounds(350, 85, 350, 200);
        scroll.setBounds(400, 85, 350, 206);
        getFrame().getContentPane().add(scroll);

        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(this::actionButtonSubmit);

        btnCheck.setBounds(50, 300, 100, 30);
        getFrame().getContentPane().add(btnCheck);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(this::actionButtonClear);

        btnClear.setBounds(250, 300, 100, 30);
        getFrame().getContentPane().add(btnClear);
    }

    private void actionButtonSubmit(ActionEvent arg0) 
    {

        String regex = regularExpression.getText();
        String string = testString.getText();
        matchInformation.setText(null);
        try {
            if (!regex.isEmpty() && !string.isEmpty()) 
            {
                boolean isRegexInvalid = false;
                Pattern pattern = null;
                
                try 
                {
                	pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
                } 
                catch (Exception x)
                {
                	isRegexInvalid = true;
                }
                
                if (isRegexInvalid)
                {
                	matchInformation.setForeground(Color.RED);
                	matchInformation.append("\n\n Invalid pattern! \n\n");
                }
                else
                {
                	final Matcher matcher = pattern.matcher(string);
                
                	if (matcher.find()) 
                	{
                		matchInformation.setForeground(Color.GREEN);
                		matchInformation.append("\n\n Match found! \n\n");
                	} 
                	else 
                	{
                		matchInformation.setForeground(Color.RED);
                		matchInformation.append("\n\n No match was found! \n\n");
                	}
                }

            }
            else
            {
            	matchInformation.setForeground(Color.RED);
            	matchInformation.append("\n\n RegEx or string missing \n\n");
            }
            
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
        }
    }

    private void actionButtonClear(ActionEvent arg0) 
    {
        matchInformation.setText(null);
        regularExpression.setText(null);
        testString.setText(null);
    }
    
}