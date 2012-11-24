<#import "/spring.ftl" as spring/>
<#assign xhtmlCompliant = true in spring>

<head>
    <title><@spring.message "userForm.title"/></title>
</head>

<@spring.bind "category.*"/>
<#if spring.status.error>
<div class="error">
    <#list spring.status.errorMessages as error>
    ${error}<br/>
    </#list>
</div>	
</#if>


<p>Please fill in user's information below:</p>

<form method="post" action="<@spring.url '/categoryform'/>" id="categoryForm">
 <@spring.formHiddenInput "category.id"/>
    <table>
        <tr>
            <th><label for="email"><@spring.message "item.name"/>:</label></th>
            <td>1
                <@spring.formInput "category.name", 'id="email"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         
        
        <tr>
            <td></td>
            <td>
                <input type="submit" class="button" name="save" value="Save"/>
                <#if category.id?exists>
                <input type="submit" class="button" name="delete" value="Delete"/>
                </#if>
                <input type="submit" class="button" name="cancel" value="Cancel"/>
            </td>
    </table>
</form> 
