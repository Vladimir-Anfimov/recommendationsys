<#include "beginning.ftlh">
<#include "navbar.ftlh">

<div style="display: flex; justify-content: center;" class="m-5">
    <h2 class="display-1">Wishlist</h2>
</div>

<div class="container-fluid">
    <div class="row row-cols-1 row-cols-md-5 g-4">
        <#list wishlist as product>
          <div class="col">
            <div class="card h-100 shadow text-center border-success mb-3">
              <img src="${product.image}" style="height: 200px;" class="card-img-top" >
              <div class="card-body">
                <h6 class="card-title">${product.name}</h6>
                <p class="card-text">Actual Price : ${product.actualPrice}</p>
                <p class="card-text">Discount Price : ${product.discountPrice}</p>
                <p class="card-text">Rating : ${product.ratings} (${product.numberOfRatings} ratings)</p>
                <p class="card-text">Category : ${product.category}</p>
              </div>
              <div class="card-footer">
                <a href="/explorer/products/${product.id?c}" class="btn btn-primary">Details</a>
              </div>
            </div>
          </div>
        </#list>
   </div>
</div>
<#include "final.ftlh">