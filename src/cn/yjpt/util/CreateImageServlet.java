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
//		设置页面类型
		response.setContentType("image/jpeg");
//		设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expries", 0);
//		绘制动态图像
//		定义验证码图片大小
		int width=60;
		int height=20;
//		创建能在内存中修改的图片对象
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		获取绘制图片的Graphics对象
		Graphics g=image.getGraphics();
//		画图片
//		设置背景图片的颜色
		g.setColor(getRandColor(200, 250));
//		画背景图片
		g.fillRect(0, 0, width, height);
//		设置干扰线颜色
		g.setColor(getRandColor(160, 200));
//		画出干扰线
		Random random=new Random();
		for(int i=0;i<100;i++){
//			设置起始点坐标
			int x=random.nextInt(width);
			int y=random.nextInt(height);
//			设置结束点坐标，从起始到结束点画直线
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1,y+y1);
			
		}
//		定义变量codestr，用来表示在会话中保存的验证码
		String codestr="";
		String [] str={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","S","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};
//		画出随机字符
		for(int i=0;i<4;i++){
			String rand="";
			if(random.nextBoolean()){
				rand=String.valueOf(random.nextInt(10));
			}else{
//				获取一个随机整数作为要取整的数组元素的下标索引
				int index=random.nextInt(49);
				rand=str[index];
			}
//			设置字体颜色
			g.setColor(getRandColor(20, 130));
//			设置字体
			g.setFont(new Font("Times New Roman",Font.PLAIN,18));
//			画出表达式
			g.drawString(rand, 13*i+6, 16);
			codestr+=rand;
		}
//		3.把4位验证码字符串保存在session中
		HttpSession session=request.getSession();
		session.setAttribute("code", codestr);
//		4.把缓存图片输出到客户端，设置输出图片的格式
		ImageIO.write(image, "jpeg", response.getOutputStream());
//		5.清除缓存，释放资源
		response.getOutputStream().flush();
		response.getOutputStream().close();
		response.flushBuffer();
	}

}
