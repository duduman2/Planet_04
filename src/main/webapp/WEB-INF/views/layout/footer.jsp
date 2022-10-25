<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
</div><!-- .container end -->
<style>
#topButton {position: fixed; right: 2%; bottom: 50px; display: none; z-index: 999;}
</style>

<script type="text/javascript">
	$(window).scroll(function() {
	    if ($(this).scrollTop() > 300) {
	        $('#topButton').fadeIn();
	    } else {
	        $('#topButton').fadeOut();
	    }
	});
	function goTop(){
		$('html').scrollTop(0);
	}
</script>
<button type="button" id="topButton" onclick="goTop()">맨 위로 ↑</button>
<footer id="footer" class="text-center">


	<small>
		ⓒ 2022 PLanet All Rights Reserved.<br>
		<span>상호명 : PLanet</span>
		<span>팀원 : 남향희, 이소빈, 이주철, 이준우, 서혜리, 최지은</span>
	</small>

</footer>

</body>
</html>