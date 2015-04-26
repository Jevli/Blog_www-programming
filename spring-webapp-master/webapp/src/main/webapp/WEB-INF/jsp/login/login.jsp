<%@ include file="../../init.jspf" %>
<c:if test="${not empty param.direct}" >
<c:remove scope="session" var="SPRING_SECURITY_REQUEST_KEY"/>
</c:if>

<c:if test="${not empty param.error}">
<div class="error-message">
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
</div>
</c:if>

<spring:url value="/user/create" var="register" htmlEscape="true"/>

<h1>Kirjaudu</h1>


<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" id="loginForm">
    <div id="passwordLoginOption" class="form">
        <div class="row">
                <label for="j_username">Tunnus:</label>
                <input type="text" id="j_username" name="j_username"/>
        </div>
        <div class="row">
                <label for="j_password">Salasana:</label>
                <input type="password" id="j_password" name="j_password"/>
        </div>
        <div class="row">
            <div class="right">
                <label hidden style="display:none" class="forCheckbox" for='_spring_security_remember_me'>
                    Remember me:
                    <input hidden style="display:none" type='checkbox' id="_spring_security_remember_me" name='_spring_security_remember_me'/>
                </label>
            </div>
        </div>
        <div class="buttons">
            <input type="submit" value="Kirjaudu" id="loginFormSubmit"/>
        </div>
    </div>
</form>

<button onclick="location.href='${register}'"><spring:message code="form.register.th" text="Don't have account yet? Register here!"/></button>