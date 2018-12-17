<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>发布就业信息</title>    
	

  </head>  
  <body>    
    <form action="/xyjygl/employmentManage" method="post">
      <input type="hidden" name="action" value="add">
      <input type="hidden" name="id"  value="">
      <table width="500" border="0"  class="tb">  
         <tr>
            <td width="150" height="39" align="right">学生姓名：</td>
            <td width="350">
              <input type="text" name="studentusername"  size="35" />              
            </td>
         </tr> 
         <tr>
            <td height="39" align="right">毕业学校：</td>
            <td>
              <input type="text" name="school" size="35" />
            </td>
         </tr>
         <tr>
            <td height="39" align="right">就职公司：</td>
            <td>
               <input type="text" name="companyname" size="35" />
            </td>
         </tr>
         <tr>
            <td height="39" align="right">就职岗位：</td>
            <td>
               <input type="text" name="position"  size="35" />
            </td>
         </tr>        
         <tr>
            <td></td>
            <td height="57" >              
              <input type="submit" value="提交" />
              &nbsp;&nbsp;
              <input type="reset"  value="重置" />             
           </td>
        </tr>
      </table>
    </form>
  </body>
</html>
