<#include "beginning.ftlh">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"  media="screen">

    <h1>Hello explorer</h1>
    <div class="container">

    <form action="/signin" method="post">
        <div class="searchbar">
            <input type="text">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
        <div class="filters">
            <select class="form-select" aria-label="filters">
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

    <h1>Recommended products</h1>
    <div class="recommended-products">
    <ul>
        <#list recommendedProducts as product>
            <li>${product.name}</li>
        </#list>
    </ul>
    </div>
</div>
<#include "final.ftlh">