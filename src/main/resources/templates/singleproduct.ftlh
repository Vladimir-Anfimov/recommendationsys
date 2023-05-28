<#include "beginning.ftlh">

<#include "navbar.ftlh">

<div class="container-fluid bg-white p-5 mt-5 rounded shadow-lg" style="width: 80%; display: flex; justify-content: center">
    <div class="row">
        <div class="col-6" style="display: flex; justify-content: center; align-items: center;">
            <img src="${product.image}" class="img-fluid" alt="${product.name}" style="height: 500px;">
        </div>
        <div class="col-6">
            <h1>${product.name}</h1>
            <p>Category: ${product.category}</p>
            <p>Rating: ${product.ratings} (${product.numberOfRatings} ratings)</p>
            <h4 class="text-danger">Discounted Price: ${product.discountPrice}</h4>
            <del>Original Price: ${product.actualPrice}</del>
            <br>
            <#if product.isInWishlist == 0>
              <form action="/wishlist/add/${product.id?c}" method="post">
                  <input type="submit" data-inline="true" value="Add to Wishlist" class="btn btn-primary" style = "width : 25%">
              </form>
              <#else>
              <form action="/wishlist/add/${product.id?c}" method="post">
                  <input disabled type="submit" data-inline="true" value="Add to Wishlist" class="btn btn-primary" style = "width : 25%">
               </form>
            </#if>
        </div>
    </div>
</div>

<#include "final.ftlh">