<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Edit Subject</title>
</head>
<body>
<form name="Subject name" action="main" method="post">

    <table>
        <thead>
        <tr>
            <th>x</th>
            <th>y</th>
            <th>Hits</th>
            <th>Shots</th>
        </tr>
        </thead>
        <tr>
            <td><input title="x" type="text" name="x"></td>
            <td><input title="y" type="text" name="y"></td>
            <td><input title="Hits" type="text" name="hits" value=${statistics.amountOfHits}></td>
            <td><input title="Shots" type="text" name="shots" value=${statistics.amountOfShots}></td>
        </tr>
        <br>
        <button class="btn btn-primary" type="submit">OK</button>
        <a role="button" class="btn btn-secondary" href="/">Cancel</a>
        <a role="button" class="btn btn-secondary" href="/reset">Reset Ships</a>
    </table>

    <div class="table-responsive-md">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">A</th>
                <th scope="col">B</th>
                <th scope="col">C</th>
                <th scope="col">D</th>
                <th scope="col">E</th>
            </tr>
            </thead>
            <tbody>
                <#list battlefield as line>
                <tr>
                    <td>${line.id}</td>
                    <td>${line.a}</td>
                    <td>${line.b}</td>
                    <td>${line.c}</td>
                    <td>${line.d}</td>
                    <td>${line.e}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>

    <div class="table-responsive-md">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">A</th>
                <th scope="col">B</th>
                <th scope="col">C</th>
                <th scope="col">D</th>
                <th scope="col">E</th>
            </tr>
            </thead>
            <tbody>
<#list field as line>
<tr>
    <td>${line.id}</td>
    <td>${line.a}</td>
    <td>${line.b}</td>
    <td>${line.c}</td>
    <td>${line.d}</td>
    <td>${line.e}</td>
</tr>
</#list>
            </tbody>
        </table>
    </div>

</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>