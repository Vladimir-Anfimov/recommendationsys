<#include "beginning.ftlh">
<#--    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">-->
<#include "navbar.ftlh">


    <h1>Hello explorer</h1>
    <div class="container">

    <form action="" method="post">
        <div class="searchbar">
             <label for="prod_name">Name</label>
            <input type="text" name="prod_name">
        </div>
        <div class="filters">
            <select aria-label="filters">
              <option selected>Category</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
            <div data-role="rangeslider">
                    <label for="price-min">Price:</label>
                    <input type="range" name="price-min" id="price-min" value="200" min="0" max="100000">
                    <label for="price-max">Price:</label>
                    <input type="range" name="price-max" id="price-max" value="800" min="0" max="100000">
            </div>
            <div data-role="rangeslider">
                    <label for="price-min">Rating:</label>
                    <input type="range" name="price-min" id="price-min" value="200" min="0" max="5">
                    <label for="price-max">Price:</label>
                    <input type="range" name="price-max" id="price-max" value="800" min="0" max="5">
           </div>
            <input type="submit" data-inline="true" value="Filter">
        </div>
    </form>

    <h2>Recommended products</h2>

    <div class="row row-cols-1 row-cols-md-5 g-4">
    <#list recommendedProducts as product>
      <div class="col">
        <div class="card h-100 shadow">
          <img src="${product.image}" style="height: 300px;" class="card-img-top" >
          <div class="card-body">
            <h5 class="card-title"><a href="/explorer/products/${product.id?c}">${product.name}</a></h5>
            <p class="card-text">Actual Price : ${product.actualPrice}</p>
            <p class="card-text">Discount Price : ${product.discountPrice}</p>
            <p class="card-text">Rating : ${product.ratings} (${product.numberOfRatings} ratings)</p>
          </div>
        </div>
      </div>
    </#list>
    </div>
</div>
<#include "final.ftlh">