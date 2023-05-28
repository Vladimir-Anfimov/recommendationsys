<#include "beginning.ftlh">
<#--    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">-->
<#include "navbar.ftlh">


    <h1>Hello explorer</h1>
    <div class="container">

    <div class="card shadow text-center text-white bg-dark mb-3" style="padding : 5%">
        <form action="" method="post">
            <div class="searchbar">
                 <div class="mb-3">
                   <label for="name" class="form-label">Name</label>
                   <input type="text" class="form-control" id="name" placeholder="Name">
                 </div>
            </div>

                <label for="categories" class="form-label">Category</label>
                <select class="form-select form-select-sm mb-3" aria-label=".form-select-sm example" id="categories">
                  <#list categories as category>
                    <option value = "${category.id}">${category.name}</option>
                  </#list>
                </select>

                <label for="min-rating" class="form-label">Minimum Rating</label>
                <input type="range" class="form-range" min="0" max="5" step="0.1" id="min-rating">

                <label for="max-rating" class="form-label">Maximum Rating</label>
                <input type="range" class="form-range" min="0" max="5" step="0.1" id="max-rating">

                <label for="min-price" class="form-label">Minimum Price</label>
                <input type="range" class="form-range" min="0" max="1000000" step="1000" id="min-price">

                <label for="max-price" class="form-label">Maximum Price</label>
                <input type="range" class="form-range" min="0" max="1000000" step="1000" id="max-price">

                <input type="submit" data-inline="true" value="Filter" class="btn btn-primary" style = "width : 25%">
        </form>
    </div>

    <h2>Recommended products</h2>

    <div class="row row-cols-1 row-cols-md-5 g-4">
    <#list recommendedProducts as product>
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