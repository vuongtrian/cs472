<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer Selection Advice</title>
    <style>
        /* Basic reset for consistency across browsers */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* Container to hold form and heading */
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        /* Headings styling */
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        /* Form label and select dropdown */
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 10px;
        }

        select {
            padding: 10px;
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        /* Submit button styling */
        .btn-submit {
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        /* Hover effect for the submit button */
        .btn-submit:hover {
            background-color: #2980b9;
        }

        /* Responsive adjustments */
        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }

            h2 {
                font-size: 18px;
            }

            select, .btn-submit {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select Your Beer Preference</h2>
        
        <form action="../selectBeer" method="post">
            <label for="color">Pick a beer color:</label>
            <select name="color" id="color">
                <option value="light">Light</option>
                <option value="amber">Amber</option>
                <option value="brown">Brown</option>
                <option value="dark">Dark</option>
            </select>
            
            <br><br>
            <input type="submit" value="Submit" class="btn-submit"/>
        </form>
    </div>
</body>
</html>