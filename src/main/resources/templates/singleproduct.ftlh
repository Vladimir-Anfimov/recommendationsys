<#include "beginning.ftlh">

<#include "navbar.ftlh">

<div class="container-fluid bg-white p-5 mt-5 rounded shadow-lg" style="width: 80%; display: flex; justify-content: center">
    <div class="row">
        <div class="col-6" style="display: flex; justify-content: center; align-items: center;">
            <img src="${product.image}" class="img-fluid" alt="${product.name}" width="100%">
        </div>
        <div class="col-6">
            <h1>${product.name}</h1>
            <p>Category: ${product.category}</p>
            <p>Rating: ${product.ratings} (${product.numberOfRatings} ratings)</p>
            <h4 class="text-danger">Discounted Price: $${product.discountPrice}</h4>
            <del>Original Price: $${product.actualPrice}</del>
            <br>
            <button class="btn btn-lg btn-primary mt-2">Add to Wishlist</button>
        </div>
    </div>
</div>

<#include "final.ftlh">