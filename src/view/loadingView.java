package view;

import javax.swing.*;

import java.awt.*;
import view.loginView;

public class loadingView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
	private Thread loadingThread;
	private Timer disposeTimer;
	
	public loadingView() {
		setTitle("Loading Bar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(427, 171);
		setLocationRelativeTo(null);

		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(42, 54, 312, 26);
		progressBar.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		progressBar.setStringPainted(true);
		progressBar.setString("Loading...");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(progressBar);
		getContentPane().add(panel, BorderLayout.CENTER);

		startLoading();

		disposeTimer = new Timer(2100, e -> {
			dispose();
			new loginView();

		});
		disposeTimer.setRepeats(false);
		disposeTimer.start();
		this.setVisible(true);
	}

	private void startLoading() {
		loadingThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 100;) {
					progressBar.setValue(i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i += 3;
				}
			}
		});
		loadingThread.start();
	}

}
