<#import "/spring.ftl" as spring/>
<#assign xhtmlCompliant = true in spring>

<head>
    <title><@spring.message "userForm.title"/></title>
    <link href="styles/calendar.css" type="text/css" rel="stylesheet"/>
</head>

 

<p>Please fill in user's information below:</p>

<form method="post" action="<@spring.url '/userform'/>" id="userForm">
    <table>
        <tr>
            <th><label for="username"><@spring.message "user.username"/>:</label></th>
            <td>
            </td>
        </tr>
        <tr>
            <th><label for="password"><@spring.message "user.password"/>:</label></th>
            <td>
            </td>
        </tr>
        <tr>
            <th><label for="firstName"><@spring.message "user.firstName"/>:</label></th>
            <td>
            </td>
        </tr>
        <tr>
            <th><label for="lastName"><@spring.message "user.lastName"/>:</label></th>
            <td>
            </td>
        </tr>
        <tr>
            <th><label for="email"><@spring.message "user.email"/>:</label></th>
            <td>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" class="button" name="save" value="Save"/>
                <input type="submit" class="button" name="cancel" value="Cancel"/>
            </td>
    </table>
</form>

<script type="text/javascript">
    Form.focusFirstElement($('userForm'));
</script>
