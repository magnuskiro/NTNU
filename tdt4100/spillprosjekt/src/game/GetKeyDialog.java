package game;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GetKeyDialog{
	private GameKeys control;
	@SuppressWarnings("unused")
	private OptionMenu option;
	public GetKeyDialog(final OptionMenu option, final GameKeys control, int value, final char vei){
		this.control = control;
		this.option = option;
		final GetKeyPanel get = new GetKeyPanel(value);
		final JOptionPane optin = new JOptionPane(get,JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		final JDialog dialog = new JDialog();
		dialog.setContentPane(optin);
		get.requestFocusInWindow();
		optin.addPropertyChangeListener(
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						String prop = e.getPropertyName();
						if (dialog.isVisible() 
								&& (e.getSource() == optin)
								&& (prop.equals(JOptionPane.VALUE_PROPERTY))) {
							//If you were going to check something
							//before closing the window, you'd do
							//it here.
							System.out.println(get.getValue());
							if(Integer.parseInt(optin.getValue().toString()) == JOptionPane.OK_OPTION){
								if(isLegalKeyChange(get.getValue())){
									switch(vei){
									case 'l':
										control.setLeft1(get.getValue()); break;
									case 'r':
										control.setRight1(get.getValue()); break;
									case 'j':
										control.setJump1(get.getValue()); break;
									case 'a':
										control.setAction1(get.getValue()); break;
									case 'g':
										control.setGhost1(get.getValue()); break;
									case 'm':
										control.setMute(get.getValue()); break;
									case 's':
										control.setRestart(get.getValue()); break;
									}
									option.update();
									dialog.setVisible(false);
								} else {
									dialog.setVisible(false);
									JOptionPane.showMessageDialog(option, "The selected hotkey '"+KeyEvent.getKeyText(get.getValue())+ "' is already in use!", "Hotkey conflict", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							dialog.setVisible(false);
						}
					}
				});
		dialog.pack();
		dialog.setVisible(true);
	}
	private boolean isLegalKeyChange(int newKey){
		if(newKey == control.getLeft1()){
			return false;
		} else if(newKey == control.getRight1()){
			return false;
		} else if(newKey == control.getJump1()){
			return false;
		} else if(newKey == control.getAction1()){
			return false;
		} else if(newKey == control.getGhost1()){
			return false;
		} else {
			return true;
		}
	}
}
