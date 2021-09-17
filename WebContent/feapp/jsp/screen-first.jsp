<%--

	welcome.jsp
	Use to display the SCAN QR CODE button and accept user action
	
--%>
<script src="js/processor.js"></script>
<form name="queryForm" action="welcome.do?command=showQR" method="post">
<div style="width:100%;height:30px;background-color:#000099">
<input size="15" name="requestId" style="font-family:arial;font-size:12px">
</div>
</form>
<table id="loading_table" style="display: none; background-color:#D4D4FF; border-collapse:collapse; border:2px solid blue; padding:5px">
	<tr>
		<td style="padding:10px">
			<img src="../common/images/scanqr.png" height="16" width="16" alt=""> SCAN QR CODE;&nbsp;
		</td>
	</tr>
</table>
<table id="loading_table" style="display: none; background-color:#D4D4FF; border-collapse:collapse; border:2px solid blue; padding:5px">
	<tr>
		<td style="padding:10px">
			<span style="font-family:sans-serif;font-size:12px">Page is loading....Please wait....</span>&nbsp;&nbsp;&nbsp;
			<img src="../common/images/circular_loader.gif" height="16" width="16" alt=""> &nbsp;&nbsp;&nbsp;&nbsp;
	</tr>
</table>

<!--
</div>
</body>
-->
