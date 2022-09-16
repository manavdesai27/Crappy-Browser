import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame implements ActionListener{
    private JTextField addressBar;
    private JEditorPane display;

    public void actionPerformed(ActionEvent e) {
        loadWebPage(e.getActionCommand()); 
    }
    
    public ReadFile(){
        super("Simple Browser");

        // Address Bar
        addressBar = new JTextField("Enter a URL");
        addressBar.addActionListener(this);
        addressBar.setFont(new Font("Courier", Font.BOLD, 50));

        add(addressBar, BorderLayout.NORTH);

        // Display web page
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
            new HyperlinkListener(){
                public void hyperlinkUpdate(HyperlinkEvent event){
                    if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                        loadWebPage(event.getURL().toString());
                    }
                }
            }
        );

        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(1800, 1200);
        setVisible(true);
    }

    private void loadWebPage(String url){
        try{
            display.setPage(url);
            addressBar.setText(url);
        }
        catch(Exception err){
            System.out.println("Bad URL");
        }
    }
}