<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>

<h2 class="columnHeading">Käyttäjätili.</h2>

<p>
    Uuden käyttäjätilin luominen käyttäjälle.
</p>

<spring:url value="/user/create" var="formAction" htmlEscape="true"/>


<form:form commandName="userCreateForm" methodParam="POST">
<table class="tableWithNoBorders">
    <tr>
        <td>Kirjautumistunnus</td>
        <td><form:input path="userName" /></td>
        <td><form:errors path="userName"/></td>
    </tr>
    <tr>
        <td>Etunimi</td>
        <td><form:input path="firstName" /></td>
        <td><form:errors path="firstName"/></td>
    </tr>
    <tr>
        <td>Sukunimi</td>
        <td><form:input path="lastName" /></td>
        <td><form:errors path="lastName"/></td>
    </tr>
    <tr>
        <td>Sähköposti</td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email"/></td>
    </tr>
    <tr>
        <td>Maa</td>
        <td><form:input path="country" /></td>
        <td><form:errors path="country"/></td>
    </tr>
	<tr>
        <td>Salasana</td>
        <td><form:password path="password1" /></td>
        <td><form:errors path="password1"/></td>
    </tr>
    <tr>
        <td>Salasana varmistus</td>
        <td><form:password path="password2" /></td>
        <td><form:errors path="password2"/></td>
    </tr>
    <tr>
    	<td></td>
    	<td><form:button type="submit" id="formSubmit" name="formSubmit" value="save">Tallenna</form:button></td>
    </tr>
</table>
</form:form>
