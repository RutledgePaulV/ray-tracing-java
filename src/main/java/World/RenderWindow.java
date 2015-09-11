package World;

import javax.swing.*;
import java.awt.*;

public class RenderWindow extends JFrame
{
	private static final long serialVersionUID = -9172651196190482850L;
	private JFrame window;
	public MyPanel pane;

	public RenderWindow(Dimension size, String title, Color background)
	{
		this.window = new JFrame();
		this.window.setSize(size.width+16,size.height+39);
		this.window.setTitle(title);
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pane = new MyPanel(size,background);
		this.window.add(this.pane);
	}

	public class MyPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private Color[][] buffer;
		
		public MyPanel(Dimension size, Color background)
		{
			buffer = new Color[size.width][size.height];
			for(int x = 0; x < buffer.length-1; x++)
				for(int y = 0; y < buffer[0].length; y++)
					buffer[x][y] = background;
		}
		
		public void SetPixel(Color c, int x, int y)
		{
			buffer[x][y]=c;
			this.repaint();
		}
		
		public void SwapBuffer(Color[][] buf)
		{
			buffer = buf;
			this.repaint();
		}

		public void paintComponent(Graphics g)
		{
			for(int x = 0; x < buffer.length-1; x++)
				for(int y = 0; y < buffer[0].length; y++)
				{
					g.setColor(buffer[x][y]);
					g.drawRect(x, y, 1, 1);
				}
		}
	}
}
