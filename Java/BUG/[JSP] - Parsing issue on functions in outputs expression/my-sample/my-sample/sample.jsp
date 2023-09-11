
<html>
  <c:choose>
    <c:if test="${auth:target()}">
      <fmt:setLocale value="${cookie.lang.value}" />
    </c:if>
  </c:choose>

  <!-- sample-a -->
  <c:choose>
    <c:when test="${!empty sessionScope[contentTitleSubItem]}">
    	<c:set var="contentTitleSubItemString" value="${contentTitleSubItemString}${sessionScope[contentTitleSubItem]}" />
    </c:when>
  </c:choose>

  <!-- sample b -->
  <c:if test="${auth:target(agent, 'securityConfiguration.do', PERMISSION_TYPE_VIEW)}">
		<td class="ledger">
			<c:out value="${permIdValue}"/>	
		</td>															
	</c:if>

  <!-- sample-c -->
  <td class="formButtonCell">
    <c:if test="${auth:target(agent, 'productConfigurationLoanPaymentApplication.do?method=paymentApplicationEditForm', PERMISSION_TYPE_FULL)}">
      <input type="submit" class="formButton" name="submit" value="<fmt:message key="label.submit"/>"> 
    </c:if>
  </td>

  <!-- sample-d > line 20: syntax issue-->
  <td class="formButtonCell">
    <c:if test="${auth:target(agent, 'productConfigurationLoanTransactionCodesFees.do?method=transactionCodesFeesEditForm', PERMISSION_TYPE_FULL)}">
      <input type="submit" class="formButton" name="submit" value="<fmt:message key="label.submit"/>">
    </c:if>
    <input type="button" class="formButton" name="cancel" onclick="location.href='productConfigurationList.do?method=list&${token:getTokenParameter(pageContext.request, pageContext.session)}';" value="<fmt:message key="label.cancel" />">
  </td>

   <!-- sample-e -->
  <c:choose>
		<c:when test="${auth:checkFieldAuth(agent,protectionRow,'UTBLCMPLP_CMPLSTAT')}">
			<td class="ledger"><fmt:message key="label.tableCompilationStatus.${process.status}" /></td>
		</c:when>
	</c:choose>



</html>

