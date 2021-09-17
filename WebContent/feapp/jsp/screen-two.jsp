<%--
	/**
	 *	Server status check
	 *  Take photo and upload file
	 */
--%>

<script src="js/processor.js"></script>
<html:form action="/qrProcessMgr" enctype="multipart/form-data" styleId="theForm">

<table class="NoBorderTable" width="1450" align="center">
	<tr>
		<td style="padding:10px">
			<img src="../common/images/server_status.png" height="16" width="16" alt=""> Check Server Status;&nbsp;
		</td>
	</tr>

    <tr>
        <td style="padding:10px">
            <img src="../common/images/take_upload.png" height="16" width="16" alt=""> Take Photo & Upload it;&nbsp;
        </td>
    </tr>

</table>
</td>
</tr>
</table>
</div>

<br>
<logic:equal value="Y" name="requestForm" property="isSubmitted">
</logic:equal>
</body>
