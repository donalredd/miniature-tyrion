<title>${rc.getMessage("userList.title")}</title>

<button onclick="location.href='categoryform'" style="float: right; margin-top: -30px; width: 100px">${rc.getMessage("category.add")}</button>

<table class="table" id="categoryList">
<thead>
<tr>
    <th>${rc.getMessage("user.id")}</th>
    <th>${rc.getMessage("category.name")}</th>
    <th>${rc.getMessage("category.description")}</th>
</tr>
</thead>
<tbody>
<#list categoryList!! as category>
<#if category_index % 2 == 0> <tr class="odd"> 
<#else> <tr class="even"> 
</#if>
    <td><a href="categoryform?id=${category.id}">${category.id}</a></td>
    <td>${category.name?html}</td>
    <td>${category.name?html}</td>
</tr>
</#list>
</tbody>
</table>

<script type="text/javascript">highlightTableRows("categoryList");</script>
