<#include "beginning.ftlh">
<#include "navbar.ftlh">


    <div class="container">

    <div class="card shadow text-center text-white bg-dark mb-3" style="padding : 5%">
        <form id="form-search" action="/explorer/products" method="get">
            <div class="searchbar">
                 <div class="mb-3">
                   <label for="name" class="form-label">Name</label>
                   <input type="text" class="form-control" id="name" placeholder="Name" name="productName">
                 </div>
            </div>

                <label for="categories" class="form-label">Category</label>
                <select name="category" class="form-select form-select-sm mb-3" aria-label=".form-select-sm example" id="categories">
                  <#list categories as category>
                    <option value = "${category.id}" name="">${category.name}</option>
                  </#list>
                </select>

                <div class="row bg-secondary rounded m-3 shadow p-3">
                    <div class="col col-6">
                        <input name="minPrice" id="minPrice" type="range" value="10" min="0" max="239990" step="1"/>
                        <div>
                            <div>Minimum price</div>
                            <input readonly class="form-control shadow" type="number" id="inputTextMinPrice" value="10" min="0" max="239990"/>
                        </div>
                    </div>
                    <div class="col col-6">
                        <input name="maxPrice" id="maxPrice" type="range" value="150000" min="0" max="239990" step="1"/>
                        <div>
                            <div>Maximum price</div>
                            <input readonly class="form-control shadow" type="number" id="inputTextMaxPrice" value="150000" min="0" max="239990"/>
                        </div>
                    </div>
                </div>

            <div class="row bg-secondary rounded m-3 shadow p-3">
                <div class="col col-6">
                    <input name="minRating" id="minRating" type="range" value="1" min="0" max="5" step="0.1"/>
                    <div>
                        <div>Minimum rating</div>
                        <input readonly class="form-control shadow" type="number" id="inputTextMinRating" value="1" min="0" max="5"/>
                    </div>
                </div>
                <div class="col col-6">
                    <input name="maxRating" id="maxRating" type="range" value="5" min="0" max="5" step="0.1"/>
                    <div>
                        <div>Maximum rating</div>
                        <input readonly class="form-control shadow" type="number" id="inputTextMaxRating" value="5" min="0" max="5"/>
                    </div>
                </div>
            </div>

                <input type="submit" data-inline="true" value="Filter search" class="mt-4 mb-4 shadow btn btn-primary" style = "width : 25%">
        </form>
    </div>

    <div style="display: flex; justify-content: center;" class="m-5">
        <h2 class="display-1">Recommended products</h2>
    </div>

    <div class="row row-cols-1 row-cols-md-5 g-4">
    <#list recommendedProducts as product>
      <div class="col">
        <div class="card h-100 shadow text-center">
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

    <script>

        const minPrice = document.getElementById("minPrice");
        const maxPrice = document.getElementById("maxPrice");
        const minRating = document.getElementById("minRating");
        const maxRating = document.getElementById("maxRating");

        const inputTextMinPrice = document.getElementById("inputTextMinPrice");
        const inputTextMaxPrice = document.getElementById("inputTextMaxPrice");
        const inputTextMinRating = document.getElementById("inputTextMinRating");
        const inputTextMaxRating = document.getElementById("inputTextMaxRating");

        const formSearch = document.getElementById("form-search");

        minRating.addEventListener("input", (event)=>{
            inputTextMinRating.value = event.target.value;
        });

        maxRating.addEventListener("input", (event)=>{
            inputTextMaxRating.value = event.target.value;
        });
        minPrice.addEventListener("input", (event)=>{
            inputTextMinPrice.value = event.target.value;
        });
        maxPrice.addEventListener("input", (event)=>{
            inputTextMaxPrice.value = event.target.value;
        });


        formSearch.addEventListener("submit", event=>{
            if(+minPrice.value >= +maxPrice.value){
                event.preventDefault();
                console.log("minprice: " + minPrice.value + "maxprice: " + maxPrice.value)
                alert("Minimum price cannot be greater or equal than maximum price");
            }

            if(+minRating.value >= +maxRating.value){
                event.preventDefault();
                console.log("minrating: " + minRating.value + "maxrating: " + maxRating.value)
                alert("Minimum rating cannot be greater  or equal than maximum rating");
            }
        })

    </script>
<#include "final.ftlh">