<!DOCTYPE html>
<html>

<head>
    <title>Laravel</title>
</head>

<body>
    <h2>Laravel</h2>
    <p>Welcome to Laravel</p>

    <div>
        @foreach ($employees as $user)
        Hello, {{ $user->name }} <br />
        @endforeach
    </div>
</body>

</html>