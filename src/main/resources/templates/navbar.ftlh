<nav class="navbar navbar-expand-lg navbar-light bg-light shadow mb-5">
    <div class="container-fluid p-4">
        <a class="navbar-brand" href="/explorer">Recsys</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page"  href="/explorer">Explorer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/wishlist">Wishlist</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="logout-user" aria-current="page" href="#">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script>
    document.getElementById('logout-user').addEventListener('click', function(event) {
        event.preventDefault();
        document.cookie = 'token=; path=/; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
        window.location.href = '/signin';
    });

</script>