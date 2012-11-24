<#import "/spring.ftl" as spring/>
<#assign xhtmlCompliant = true in spring>

<head>
    <title><@spring.message "itemList.title"/></title>
	<link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
	<link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
	<script src="scripts/js/fileuploader.js" type="text/javascript"></script>
</head>
	 
<@spring.bind "item.*"/>
<#if spring.status.error>
<div class="error">
    <#list spring.status.errorMessages as error>
    ${error}<br/>
    </#list>
</div>
</#if>

<p>Please fill in information below:</p>
<form method="post" action="<@spring.url '/addItem'/>" id="itemForm"	 enctype="multipart/form-data">
    <table>
        <tr>
            <th><label for="name"><@spring.message "item.name"/>:</label></th>
            <td>
                <@spring.formInput "item.name", 'id="name"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="name"><@spring.message "item.description"/>:</label></th>
            <td>
                <@spring.formInput "item.description", 'id="description"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="name"><@spring.message "item.category"/>:</label></th>
            <td>
                <@spring.formSingleSelect "item.category", categories/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <th><label for="name"><@spring.message "item.store"/>:</label></th>
            <td>
                <@spring.formSingleSelect "item.store", stores/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="datepurchased"><@spring.message "item.date.purchased"/>:</label></th>
            <td>
                <@spring.formInput "item.datePurchased", 'id="datePurchased"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
        <tr>
            <th><label for="email"><@spring.message "item.date.expires"/>:</label></th>
            <td>
				<@spring.formInput "item.dateWarrantyExpires",'id="dateWarrantyExpires"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="email"><@spring.message "item.reminder.status"/>:</label></th>
            <td>
				<@spring.formInput "item.remindWhenExpires",'id="remindWhenExpires"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="email"><@spring.message "item.reminder.nodays"/>:</label></th>
            <td>
				<@spring.formInput "item.numDaysToRemindBeforeExp", 'id="numDaysToRemindBeforeExp"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         <tr>
            <th><label for="tags"><@spring.message "item.searchtags"/>:</label></th>
            <td>
				<@spring.formInput "item.tags", 'id="tags"'/>
                <@spring.showErrors "<br/>", "fieldError"/>
            </td>
        </tr>
         
        
        <tr>
            <td></td>
            <td>
                <input type="submit" class="button" name="save" value="Save"/>
                <#if item.id?exists>
                <input type="submit" class="button" name="delete" value="Delete"/>
                </#if>
                <input type="submit" class="button" name="cancel" value="Cancel"/>
            </td>
    </table>

One

<p>To upload a file, click on the button below. Drag-and-drop is supported in FF, Chrome.</p>
	<p>Progress-bar is supported in FF3.6+, Chrome6+, Safari4+</p>
	
	<div id="file-uploader-demo1">		
		<noscript>			
			<p>Please enable JavaScript to use file uploader.</p>
			<!-- or put a simple form for upload here -->
		</noscript>         
	</div>
    <script src="fileuploader.js" type="text/javascript"></script>
    <script>        
        function createUploader(){            
            var uploader = new qq.FileUploader({
                element: document.getElementById('file-uploader-demo1'),
                action: 'do-nothing.htm',
                debug: true
            });           
        }
        // in your app create uploader as soon as the DOM is ready
        // don't wait for the window to load  
        window.onload = createUploader;     
    </script>    
    
    Two
</form>
  
   
