<#import "/spring.ftl" as spring/>
<#assign xhtmlCompliant = true in spring>

<head>
    <title><@spring.message "itemList.title"/></title>
    <link href="styles/calendar.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
	<link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
	<link href="styles/jquery.fileupload-ui.css" type="text/css" rel="stylesheet"/>
	
</head>

<@spring.bind "store.*"/>
<#if spring.status.error>
<div class="error">
    <#list spring.status.errorMessages as error>
    ${error}<br/>
    </#list>
</div>
</#if>

<p>Please fill in information below:</p>
<form method="post" action="<@spring.url '/storeform'/>" id="storeForm"       enctype="multipart/form-data">
 <@spring.formHiddenInput "store.id"/>
    <table>
 
        <tr>
            <th><label for="name"><@spring.message "item.name"/>:</label></th>
            <td>
                <@spring.formInput "store.name", 'id="name"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
                
               
            </td>
        </tr>
         
        
        
        <tr>
            <td></td>
            <td>
                <input type="submit" class="button" name="save" value="Save"/>
                <#if store.id?exists>
                <input type="submit" class="button" name="delete" value="Delete"/>
                </#if>
                <input type="submit" class="button" name="cancel" value="Cancel"/>
            </td>
    </table>
</form>
  
   
