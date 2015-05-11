<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>

<h2 class="columnHeading">Käyttäjätili.</h2>

<p>
    Uuden käyttäjätilin luominen käyttäjälle.
</p>

<spring:url value="/user/create" var="formAction" htmlEscape="true"/>


<form:form commandName="userCreateForm" id="personform" methodParam="POST">
<form:errors path="*" element="div"/>
<table>
    <tr>
        <td>Kirjautumistunnus</td>
        <td><form:input path="userName" /></td>
        <td><form:errors element="userName" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
        <td>Etunimi</td>
        <td><form:input path="firstName" /></td>
        <td><form:errors path="firstName" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
        <td>Sukunimi</td>
        <td><form:input path="lastName" /></td>
        <td><form:errors path="lastName" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
        <td>Sähköposti</td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
        <td>Maa</td>
        <td><form:input path="country" /></td>
        <td><form:errors path="country" cccStyle="color: #ff0000;"/></td>
    </tr>
	<tr>
        <td>Salasana</td>
        <td><form:password path="password1" /></td>
        <td><form:errors path="password1" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
        <td>Salasana varmistus</td>
        <td><form:password path="password2" /></td>
        <td><form:errors path="password2" cccStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
    	<td><form:button type="submit" id="formSubmit" name="formSubmit" value="save">Tallenna</form:button></td>
    </tr>
</table>
</form:form>
