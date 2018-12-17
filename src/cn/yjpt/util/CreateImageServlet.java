package cn.yjpt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateImageServlet
 */
@WebServlet("/CreateImageServlet")
public class CreateImageServlet extends HttpServlet {
	Color getRandColor(int fc,int bc){
		Random random=new Random();
		if(fc>255){
			fc=255;
		}
		if(bc>255){
			bc=255;
		}
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		����ҳ������
		response.setContentType("image/jpeg");
//		����ҳ�治����
		response.setHeader("Pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expries", 0);
//		���ƶ�̬ͼ��
//		������֤��ͼƬ��С
		int width=60;
		int height=20;
//		���������ڴ����޸ĵ�ͼƬ����
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		��ȡ����ͼƬ��Graphics����
		Graphics g=image.getGraphics();
//		��ͼƬ
//		���ñ���ͼƬ����ɫ
		g.setColor(getRandColor(200, 250));
//		������ͼƬ
		g.fillRect(0, 0, width, height);
//		���ø�������ɫ
		g.setColor(getRandColor(160, 200));
//		����������
		Random random=new Random();
		for(int i=0;i<100;i++){
//			������ʼ������
			int x=random.nextInt(width);
			int y=random.nextInt(height);
//			���ý��������꣬����ʼ�������㻭ֱ��
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1,y+y1);
			
		}
//		�������codestr��������ʾ�ڻỰ�б������֤��
		String codestr="";
		String [] str={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","S","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};
//		��������ַ�
		for(int i=0;i<4;i++){
			String rand="";
			if(random.nextBoolean()){
				rand=String.valueOf(random.nextInt(10));
			}else{
//				��ȡһ�����������ΪҪȡ��������Ԫ�ص��±�����
				int index=random.nextInt(49);
				rand=str[index];
			}
//			����������ɫ
			g.setColor(getRandColor(20, 130));
//			��������
			g.setFont(new Font("Times New Roman",Font.PLAIN,18));
//			�������ʽ
			g.drawString(rand, 13*i+6, 16);
			codestr+=rand;
		}
//		3.��4λ��֤���ַ���������session��
		HttpSession session=request.getSession();
		session.setAttribute("code", codestr);
//		4.�ѻ���ͼƬ������ͻ��ˣ��������ͼƬ�ĸ�ʽ
		ImageIO.write(image, "jpeg", response.getOutputStream());
//		5.������棬�ͷ���Դ
		response.getOutputStream().flush();
		response.getOutputStream().close();
		response.flushBuffer();
	}

}
