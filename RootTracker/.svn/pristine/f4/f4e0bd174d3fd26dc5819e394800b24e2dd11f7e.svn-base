<title>${rc.getMessage("userList.title")}</title>

<button onclick="location.href='storeform'" style="float: right; margin-top: -30px; width: 100px">${rc.getMessage("item.add")}</button>
53w5
<table class="table" id="storeList">
<thead>
<tr>
    <th>${rc.getMessage("user.id")}</th>
    <th>${rc.getMessage("item.name")}</th>
    <th>${rc.getMessage("item.description")}</th>
</tr>
</thead>
<tbody>
<#list storelist!! as store>
<#if store_index % 2 == 0> <tr class="odd"> 
<#else> <tr class="even"> 
</#if>
    <td><a href="storeform?id=${store.id}">${store.id}</a></td>
    <td>${store.name?html}</td>
    <td>${store.name?html}</td>
</tr>
</#list>
</tbody>
</table>

<script type="text/javascript">highlightTableRows("storeList");</script>
