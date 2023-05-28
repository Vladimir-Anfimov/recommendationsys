<#include "beginning.ftlh">

<#include "navbar.ftlh">

<h1>Products query</h1>
<h2 id="querystring"></h2>

<script>
    var params = new URLSearchParams(window.location.search);
    var obj = {};
    for (var key of params.keys()) {
        obj[key] = params.get(key);
    }

    document.getElementById("querystring").textContent = JSON.stringify(obj, null, 2);

</script>

<#include "final.ftlh">
