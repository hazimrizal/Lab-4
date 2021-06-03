package translationClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import translation.translation;
import javax.swing.JButton;

public class clientFrame extends JFrame {
	translation t = new translation();
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public clientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("TEXT: ");
		text.setBounds(42, 89, 40, 20);
		contentPane.add(text);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setPhrase(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Good Morning", "Good Night", "How are you?", "Thank you ", "Goodbye ", "What's up?"}));
		comboBox.setBounds(87, 89, 176, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("LANGUAGE:");
		lblNewLabel.setBounds(294, 93, 76, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox combol = new JComboBox();
		combol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setLang(combol.getSelectedItem().toString());
			}
		});
		combol.setModel(new DefaultComboBoxModel(new String[] {"", "Malay", "Arabic", "Korean"}));
		combol.setBounds(380, 89, 76, 21);
		contentPane.add(combol);
		
		JButton btntrans = new JButton("Translate");
		btntrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					release();
				} catch (InterruptedException e1) {
					System.out.print("failed to sent. Too bad ");
					e1.printStackTrace();
				}
			}
				
			
		});
		btntrans.setBounds(214, 219, 135, 21);
		contentPane.add(btntrans);
	}

	public String getPhraseExtract() throws InterruptedException
	{
		waitForInput();
		return t.getPhrase();
	}
	
	public String getLangExtract() {
		return t.getLang();
	}
	
	public void waitForInput() throws InterruptedException {
        synchronized(this) {
            wait();
        }
    }
	
	//release after button clicked
	public void release() throws InterruptedException {
        synchronized(this) {
            notifyAll();
        }
    }

}
