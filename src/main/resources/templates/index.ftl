<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <div class="jumbotron">
                <h1 class="display-4">${message}</h1>
                <h2>Створення нового платежа</h2>
                <form action="/makePayment" method="post" class="form-group">
                    <input type="text" name="description" placeholder="description"><br>
                    <input type="text" name="amount" placeholder="amount"><br>
                    <input type="submit" value="add">
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <div class="jumbotron">
                <h2>Список платежів</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>description</th>
                        <th>date</th>
                        <th>amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if payments??>
                        <#list payments as payment>
                        <tr>
                            <th>${payment.id}</th>
                            <td>${payment.description}</td>
                            <td>${payment.date}</td>
                            <td>${payment.amount}</td>
                        </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="card">
    <div class="card-footer">
        <p>Copyright 2025</p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>