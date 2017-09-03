<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ymb.domain.*,java.util.*" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/servlet/updateBookServlet" method="post"
		enctype="multipart/form-data">
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong>
					<input type="hidden" name="id" value="${param.id }">
					</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg" value='<c:out value="${param.name }"></c:out>' /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="price" class="bg" value="${param.price }" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pnum" class="bg" value="${param.pnum }" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category" 
					id="category">
						<option value="">--选择商品类加--</option>
						<option value="文学" <c:if test='${"文学" eq param.category }'>selected</c:if> >文学</option>
						<option value="生活" <c:if test='${"生活" eq param.category }'>selected</c:if>  >生活</option>
						<option value="计算机" <c:if test='${"计算机" eq param.category }'>selected</c:if> >计算机</option>
						<option value="外语" <c:if test='${"外语" eq param.category }'>selected</c:if>  >外语</option>
						<option value="经营" <c:if test='${"经营" eq param.category }'>selected</c:if>  >经营</option>
						<option value="励志" <c:if test='${"励志" eq param.category }'>selected</c:if>  >励志</option>
						<option value="社科" <c:if test='${"社科" eq param.category }'>selected</c:if>  >社科</option>
						<option value="学术" <c:if test='${"学术" eq param.category }'>selected</c:if>  >学术</option>
						<option value="少儿" <c:if test='${"少儿" eq param.category }'>selected</c:if>  >少儿</option>
						<option value="艺术" <c:if test='${"艺术" eq param.category }'>selected</c:if> >艺术</option>
						<option value="原版" <c:if test='${"原版" eq param.category }'>selected</c:if> >原版</option>
						<option value="科技" <c:if test='${"科技" eq param.category }'>selected</c:if> >科技</option>
						<option value="考试" <c:if test='${"考试" eq param.category }'>selected</c:if> >考试</option>
						<option value="生活百科" <c:if test='${"生活百科" eq param.category }'>selected</c:if> >生活百科</option>
				</select></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file" name="upload" size="30" value="" /></td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
						name="description" cols="30" rows="3" style="WIDTH: 96%">${param.description}</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>