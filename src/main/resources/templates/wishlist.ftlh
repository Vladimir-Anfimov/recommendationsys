<#include "beginning.ftlh">
<#include "navbar.ftlh">

    <h1>Wishlist</h1>

<div class="container">
    <div class="row row-cols-1 row-cols-md-1 g-4">
        <#list wishlist as product>
          <div class="col">
            <div class="card w-50 h-100 shadow text-center">
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