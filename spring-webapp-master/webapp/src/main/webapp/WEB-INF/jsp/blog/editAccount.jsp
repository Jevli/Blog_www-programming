<!DOCTYPE html>
<%@ include file="../../init.jspf" %>


<body>

<div class="table">
    <table class="userDataTable">
        <tr><td colspan= "3" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
        <tr><td>Nimi</td><td class="editable" id="first name">${editUser.firstName} </td> <td class="editable" id="last name"> ${editUser.lastName}</td></tr>
        <tr><td>S-posti</td><td colspan= "2" class="editable" id="email address">${editUser.email}</td></tr>
        <tr><td>Puhelin</td><td colspan= "2" class="editable" id="mobile number">${editUser.mobile}</td></tr>

        <tr><td colspan="3" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
        <tr><td>Luotu </td><td colspan= "2"><joda:format pattern="dd.MM.yyyy" value="${editUser.createdOn}" /></td></tr>

        <tr><td>Muokattu </td><td colspan= "2"><joda:format pattern="dd.MM.yyyy" value="${editUser.modifiedOn}" /></td></tr>

    </table>
</div>

<script type="text/javascript" src="<c:url value='/resources/js/userInfoUpdate.js' />"></script>
<script>
    $('.editable')
        .css('cursor', 'pointer')
        .click(
            function(e){
                input = prompt("Change: " + e.target.id);
                if(input === null) {
                    return;
                }

                switch(e.target.id) {
                    case "first name":
                        updateFirstName(${editUser.id}, input);
                        break;
                    case "last name":
                        updateLastName(${editUser.id}, input);
                        break;
                    case "email address":
                        updateEmail(${editUser.id}, input);
                        break;
                    case "mobile number":
                        updateMobile(${editUser.id}, input);
                        break;
                }
            }
        )
        .hover(
            function () {
                $(this).css('background', '#ff00ff');
            },
            function(){
                $(this).css('background', '');
            }
        );
</script>

</body>