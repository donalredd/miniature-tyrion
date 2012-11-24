<#import "/spring.ftl" as spring/>
<#assign xhtmlCompliant = true in spring>

<head>
    <title><@spring.message "userForm.title"/></title>
    <link href="styles/calendar.css" type="text/css" rel="stylesheet"/>
</head>

<@spring.bind "user.*"/>
<#if spring.status.error>
<div class="error">
    <#list spring.status.errorMessages as error>
    ${error}<br/>
    </#list>
</div>
</#if>

<p>Please fill in user's information below:</p>

<form method="post" action="<@spring.url '/userform'/>" id="userForm"       enctype="multipart/form-data">
    <@spring.formHiddenInput "user.id"/>
   
    <table>
        <tr>
            <th><label for="email"><@spring.message "user.email"/>:</label></th>
            <td>
                <@spring.formInput "user.email", 'id="email"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <th><label for="password"><@spring.message "user.password"/>:</label></th>
            <td>
                <@spring.formPasswordInput "user.password", 'id="password"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <th><label for="name"><@spring.message "user.lastName"/>:</label></th>
            <td>
               <input type="file" id="image" name="image" value="">

            </td>
        </tr>
        <tr>
            <th><label for="lastName"><@spring.message "user.lastName"/>:</label></th>
            <td>
                <@spring.formInput "user.name", 'id="lastName"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <th><label for="email"><@spring.message "user.email"/>:</label></th>
            <td>
                <@spring.showErrors "<br>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" class="button" name="save" value="Save"/>
                <#if user.id?exists>
                <input type="submit" class="button" name="delete" value="Delete"/>
                </#if>
                <input type="submit" class="button" name="cancel" value="Cancel"/>
            </td>
    </table>
</form>

<script type="text/javascript">
    Form.focusFirstElement($('userForm'));
</script>
