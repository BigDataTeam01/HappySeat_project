package com.javaproject.kioskFunction;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;

import com.javaproject.page.Page01_Splash;

public class BackSplashTimer extends JDialog {
	private static final long serialVersionUID = 1L;
	Timer timer;
	JDialog jDialog;

	// 몇초가 지나면 돌아가게 만들지 정하는 constructor
	public BackSplashTimer(int seconds, JDialog jDialog) {
		super();
		this.jDialog = jDialog;
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	// TimerTask를 쓰기 위한 class
	class RemindTask extends TimerTask {
		public void run() {
			dispose();
			backSplash();
			timer.cancel(); // Terminate the timer thread
		}
	}

	// splash창으로 보내기
	public void backSplash() {
		Page01_Splash page01_Splash = new Page01_Splash();
		page01_Splash.setVisible(true);
	}

	// 현재 창 닫기
	public void dispose() {
		jDialog.dispose();
	}

}
