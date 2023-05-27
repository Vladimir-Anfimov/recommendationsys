<#include "beginning.ftlh">

<div class="container">
    <div class="row justify-content-center align-items-center" style="height: 100vh">
        <div class="col-12 col-lg-4">
            <div class="card">
                <div class="card-body text-center">
                    <img src="https://cdn-icons-png.flaticon.com/512/7477/7477881.png" alt="pc-login" width="100px" height="100px" style="margin-bottom: 20px;">
                    <form action="/signup" method="post">
                        <div class="mb-3">
                            <label class="form-label">Email address</label>
                            <input required type="email" class="form-control" name="email">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input required type="password" class="form-control" name="password">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Confirm Password</label>
                            <input required type="password" class="form-control" name="confirmPassword">
                        </div>
                        <button type="submit" class="btn btn-primary">Sign In</button>
                    </form>

                    <div id="errorMessage" class="alert alert-danger mt-3" role="alert"></div>

                    <div class="mt-3">
                        <a href="/signin">Already have an account? Sign In</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <script>
        const errorMessage = document.getElementById("errorMessage");
        errorMessage.style.display = "none";
        const urlParams = new URLSearchParams(window.location.search);
        const error = urlParams.get('error');
        if(error) {
            errorMessage.style.display = "block";
            errorMessage.innerHTML = error;
        }
    </script>

<#include "final.ftlh">