package Application;

import javax.swing.*;

public class main 
{

    public static void main(String[] args) 
    {

        try 
        {
            window window = new window();
            window.getFrame().setVisible(true);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}