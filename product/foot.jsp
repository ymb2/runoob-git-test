<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
    function footerPosition(){
        $("footer").removeClass("fixed-bottom");
        var contentHeight = document.body.scrollHeight,//网页正文全文高度
            winHeight = window.innerHeight;//可视窗口高度，不包括浏览器顶部工具栏
        if(!(contentHeight > winHeight)){
            //当网页正文高度小于可视窗口高度时，为footer添加类fixed-bottom
            $("divfoot").addClass("fixed-bottom");
        }
    }
    footerPosition();
    $(window).resize(footerPosition);
});
</script>

<div id="divfoot" style="z-index:1;position:fixed;bottom:0;width:100%;" class="fixed-bottom">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/logo.png" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px">
					<font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; BookStore All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>
