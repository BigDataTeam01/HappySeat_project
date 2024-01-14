package com.javaproject.kioskFunction;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.*;


public class ButtonDesign_ver1 extends JButton{
	
	// Field
	private Color backgroundColor =new Color(183, 216, 107);
	
	// Constructor
	// button 에 넣을 text 와 색깔을 생성자로 받는다. 
	public ButtonDesign_ver1(String text_in_btn, Color btnColor) {
		// TODO Auto-generated constructor stub
		super(text_in_btn); // JButton 의 생성자를 호출함. 
		
		this.backgroundColor = btnColor ; // 생성자를 필드값에 다시 넣어줌. 
		init(); //초기화
		
	}
	
	// Method
	
	
	private void init() {
		
		// Jbutton 의 함수를 사용하여 내용을 안보이게, 버튼을 투명하게 함. 
		setContentAreaFilled(false); // 버튼의 내용이 안보임 
		setOpaque(false); // 배경이 투명해짐 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int btnWidth 	= getWidth(); 	// button width
		int btnHeight 	= getHeight();	// button height 
		
		Graphics2D graphics = (Graphics2D) g;
		
		// Rendering hint : 그림을 그리는 픽셀을 계산하는것을 렌더링이라하고
		// 그 렌더링할때의 옵션을 줄수있는데 옵션을 주는 행위를 힌트라고 한다. 
		graphics.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, //안티엘리어싱(부드러운그림)
				RenderingHints.VALUE_ANTIALIAS_ON); // 안티엘리어싱 on
		
		// 버튼이 현재 눌려진 상태라면 어둡게 한다. 
		if (getModel().isArmed()) {
			graphics.setColor(backgroundColor.darker());
			
		// 버튼 위에 마우스가 올라간 상태이면 밝게 한다.
		} else if (getModel().isRollover()) {
			graphics.setColor(backgroundColor.brighter());
		// 아니면 그냥 둔다. 
		} else {
			graphics.setColor(backgroundColor);
		}
		// 버튼시작_X 위치, Y위치, 폭, 높이, 모서리반지름x,y
		graphics.fillRoundRect(0, 0, btnWidth, btnHeight, 20, 20);
		
		
		// font 메트릭스를 가져온다. 메트릭스? 텍스트의 자간, 줄 간격, 크기, 위치, 등을 나타냄. 
		FontMetrics fontMetrics = graphics.getFontMetrics();
		
		
		// 가져온 버튼에 입력된 텍스트를 감싸는 바운딩박스를 가져온다. 
		Rectangle textBoundingBox = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		
		// 텍스트를 가로방향으로 가운데 정렬하기 위한 계산
		int textX = (btnWidth  - textBoundingBox.width) / 2;
		
		// 텍스트를 가로방향으로 가운데 정렬하기 위한 계산 + 텍스트가 위치하는 곳의 기준선을 더해주어서 살짝 위에 오게 된다.

		int textY = (btnHeight - textBoundingBox.height) / 2 + fontMetrics.getAscent();

		
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	
	}
	
	
	
	
	
	
	

}


	