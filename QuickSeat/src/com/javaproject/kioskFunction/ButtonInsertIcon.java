package com.javaproject.kioskFunction;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.javaproject.page.Page02_SelectMenu;



public class ButtonInsertIcon extends JButton{
	
	// Field
	private Color backgroundColor =new Color(183, 216, 107);
	private ImageIcon btnIcon = new ImageIcon(
			Page02_SelectMenu.class.getResource("/com/javaproject/image/BtnResvCheck_image.png"));
    private ImageIcon normalIcon;
    private ImageIcon pressedIcon;
    private ImageIcon brightenedIcon;
    private int fillet ;
	// Constructor
	public ButtonInsertIcon(ImageIcon icon, int iconFillet) {
		// TODO Auto-generated constructor stub
		super(icon); // JButton 의 생성자를 호출함. 
		
		this.btnIcon = icon ; // 생성자를 필드값에 다시 넣어줌. 
		this.fillet = iconFillet ; // 생성자를 필드값에 다시 넣어줌. 
		initIcons(); //초기화
		
		
		 // 아이콘 설정은 생성자에서 수행
        setIcon(btnIcon);

    
	}
	
	

	
	// Method
	
	
    private void initIcons() {
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
        // 일반 상태의 아이콘
    	normalIcon = btnIcon;

        // 눌려진 상태의 아이콘 (어둡게 표시)
    	pressedIcon = createDarkenedIcon(normalIcon);
    	brightenedIcon = createBrightenedIcon(normalIcon);
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
			setIcon(pressedIcon);
			//graphics.setColor(backgroundColor.darker());
			
		// 버튼 위에 마우스가 올라간 상태이면 밝게 한다.
		} else if (getModel().isRollover()) {
			setIcon(brightenedIcon);
			//graphics.setColor(backgroundColor.brighter());
		// 아니면 그냥 둔다. 
		} else {
			setIcon(normalIcon);
			//graphics.setColor(backgroundColor);
		}
		// 버튼시작_X 위치, Y위치, 폭, 높이, 모서리반지름x,y
		graphics.fillRoundRect(0, 0, btnWidth, btnHeight, fillet, fillet);
		
		graphics.setComposite(AlphaComposite.SrcOver.derive(1.0f)); // 예시로 0.5로 투명도 설정

//		
//		graphics.setColor(getForeground());
//		graphics.setFont(getFont());

		//graphics.dispose();
		super.paintComponent(g);
		
	
	}
	
    // 아이콘을 어둡게 만드는 유틸리티 메서드
    private ImageIcon createDarkenedIcon(ImageIcon icon) {
        Image image = icon.getImage();
        Image darkenedImage = manipulateImage(image, 0.5); // 예시로 0.7 정도로 어둡게 만듭니다.
        return new ImageIcon(darkenedImage);
    }
    
    // 아이콘을 밝게 만드는 유틸리티 메서드
    private ImageIcon createBrightenedIcon(ImageIcon icon) {
        Image image = icon.getImage();
        Image darkenedImage = manipulateImage(image, 0.1); // 
        return new ImageIcon(darkenedImage);
    }
	
	
 // 이미지를 조작하는 메서드 (색상을 어둡게 만드는 예시)
    private Image manipulateImage(Image image, double darkeningFactor) {
        // 여기에서 이미지를 조작하여 어둡게 만드는 로직을 추가할 수 있습니다.
        // 이 예제에서는 색상을 어둡게 만들지만, 실제로는 여러 방법으로 이미지를 조작할 수 있습니다.
        // 이 예시에서는 Graphics2D를 사용하여 이미지를 어둡게 만들었습니다.

        int width = image.getWidth(null);
        int height = image.getHeight(null);

        BufferedImage darkenedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = darkenedImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) darkeningFactor));
        g.fillRect(0, 0, width, height);
        g.dispose();

        return darkenedImage;
    }
	
	
	

}


	