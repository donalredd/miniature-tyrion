<title>${rc.getMessage("userList.title")}</title>

<button onclick="location.href='itemform'" style="float: right; margin-top: -30px; width: 100px">${rc.getMessage("item.add")}</button>

<table class="table" id="itemList">
<thead>
<tr>
    <th>${rc.getMessage("user.id")}</th>
    <th>${rc.getMessage("item.name")}</th>
    <th>${rc.getMessage("item.description")}</th>
    <th>${rc.getMessage("user.email")}</th>
</tr>
</thead>
<tbody>
<#list itemList!! as item>
<#if item_index % 2 == 0> <tr class="odd"> 
<#else> <tr class="even"> 
</#if>
    <td><a href="itemform?id=${item.id}">${item.id}</a></td>
    <td>${item.name?html}</td>
    <td>${item.name?html}</td>
    <td>${item.description?html}</td>
</tr>
</#list>
</tbody>
</table>

<script type="text/javascript">highlightTableRows("itemList");</script>
