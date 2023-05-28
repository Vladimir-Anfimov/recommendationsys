<#include "beginning.ftlh">

<#include "navbar.ftlh">

<div class="container">

    <div style="display: flex; justify-content: center;" class="m-5">
        <h2 class="display-1">Products</h2>
    </div>

    <div class="row row-cols-1 row-cols-md-5 g-4">
        <#list products as product>
            <div class="col">
                <div class="card h-100 shadow text-center">
                    <img src="${product.image}" style="height: 300px;" class="card-img-top" >
                    <div class="card-body">
                        <h6 class="card-title">${product.name}</h6>
                        <p class="card-text">Actual Price : ${product.actualPrice}</p>
                        <p class="card-text">Discount Price : ${product.discountPrice}</p>
                        <p class="card-text">Rating : ${product.ratings} (${product.numberOfRatings} ratings)</p>
                        <p class="card-text">Category : ${product.category}</p>
                        <a href="/explorer/products/${product.id?c}" class="btn btn-primary">Details</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>

</div>

<#include "final.ftlh">
