<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Marketing Success</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Your existing CSS styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            position: relative; /* Position relative for absolute positioning of slides */
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        h2 {
            color: #4CAF50;
        }
        .section {
            margin-bottom: 20px;
        }
        .section p {
            margin: 10px 0;
        }
        .quote {
            font-style: italic;
            color: #555;
            border-left: 4px solid #4CAF50;
            padding-left: 10px;
            margin: 10px 0;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #777;
        }
        .topnav {
            overflow: hidden;
            background-color: #333;
        }
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
        .topnav .icon {
            display: none;
        }
        /* Slideshow button styles */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
            background-color: rgba(0, 0, 0, 0.5);
            text-decoration: none;
            display: inline-block;
        }

        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a grey background color */
        .prev:hover, .next:hover {
            background-color: #f1f1f1;
            color: black;
        }
        .elon-image, .tony-image , .job-image{
            max-width: 40%; /* Smaller size for the image on medium screens */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 6px; /* Adjusted margin to separate from the text */
        }

        @media screen and (min-width: 601px) {
            .elon-image, .tony-image , .job-image{
                float: right; /* Float the image to the right on larger screens */
                margin-left: 15px; /* Margin between image and text */
            }
        }

        /* Hide buttons on small screens */
        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child) { display: none; }
            .topnav a.icon {
                float: right;
                display: block;
            }
            .topnav.responsive { position: relative; }
            .topnav.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .topnav.responsive a {
                float: none;
                display: block;
                text-align: left;
            }
        }
    </style>
</head>
<body>
<div id="myTopnav" class="topnav">
    <a href="login.jsp">Home</a>
    <a href="MarketingClientPage.jsp">Marketing</a>
    <a href="CaseStudy.html" class="active">Case Study</a>
    <a href="SocmedClientPage.jsp">Social Media Marketing</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
</div>

<div class="container">
    <h1>Marketing Success</h1>
    <div class="slideshow">
        <!-- Slide for Steve Jobs content -->
        <div class="slide">
            <div class="section">
                <h2>Steve Jobs</h2>
                <img class="job-image" src="JobSteves.jpg" alt="Job Steves">
                <div>
                    <h3>Background</h3>
                    <p>Steve Jobs co-founded Apple Inc. in 1976 with Steve Wozniak and Ronald Wayne. He played a crucial role in the company's rise to becoming one of the most valuable and influential technology companies in the world.</p>
                </div>
                <div>
                    <h3>Key Marketing Strategies</h3>
                    <div>
                        <h4>1. Focus on Innovation and Design</h4>
                        <p>Jobs placed a strong emphasis on creating innovative and aesthetically pleasing products. This focus on design and user experience set Apple apart from its competitors. Products like the iPod, iPhone, and iPad were not just technologically advanced but also beautifully designed, making them highly desirable.</p>
                    </div>
                    <div>
                        <h4>2. Creating a Strong Brand Identity</h4>
                        <p>Jobs built a powerful brand identity for Apple. The Apple logo became synonymous with quality, innovation, and elegance. The ?Think Different? campaign in the late 1990s is a prime example of how Jobs used marketing to differentiate Apple and build a strong emotional connection with consumers.</p>
                    </div>
                    <div>
                        <h4>3. Exceptional Product Launches</h4>
                        <p>Jobs was known for his masterful product launches. His keynote presentations, often referred to as "Stevenotes," were highly anticipated events. These launches were meticulously planned and executed, generating immense media coverage and consumer excitement.</p>
                    </div>
                </div>
                <div>
                    <h3>Outcome</h3>
                    <p>Under Jobs' leadership, Apple introduced a series of groundbreaking products that redefined entire industries. The company?s market capitalization grew exponentially, and Apple became one of the most valuable companies in the world. Jobs? marketing strategies not only drove sales but also established Apple as a brand associated with innovation, quality, and exclusivity.</p>
                </div>
            </div>
        </div>
        <!-- Slide for Elon Musk content -->
        <div class="slide">
            <div class="section">
                <h2>Elon Musk</h2>
                <img class="elon-image" src="ElonMusk.jpg" alt="Elon Musk">
                <div>
                    <h3>Disruptive Innovation</h3>
                    <p>Musk's companies, especially Tesla and SpaceX, have focused on disruptive innovation in their respective industries?electric vehicles and space exploration. This focus on cutting-edge technology and sustainability has differentiated his brands.</p>
                </div>
                <div>
                    <h3>Visionary Leadership</h3>
                    <p>Musk is known for his bold vision and ability to communicate it effectively through various channels, including social media (like Twitter), product launches, and media interviews. His charismatic leadership style inspires both employees and consumers.</p>
                </div>
                <div>
                    <h3>Brand Ambassadors</h3>
                    <p>Tesla has leveraged enthusiastic customers and early adopters as brand ambassadors. Their testimonials and social media presence have contributed significantly to Tesla's marketing success without traditional advertising.</p>
                </div>
                <div>
                    <h3>Community Building</h3>
                    <p>Musk has cultivated a strong community around his brands, encouraging fan clubs, forums, and events. This community engagement fosters loyalty and advocacy among Tesla and SpaceX enthusiasts.</p>
                </div>
                <div>
                    <h3>Outcome</h3>
                    <p>Elon Musk's strategic marketing approach has propelled Tesla to become a leading electric vehicle manufacturer and SpaceX to revolutionize space travel. His ability to blend technological innovation with effective marketing has not only driven sales but also shaped industries and public perception.</p>
                </div>
            </div>
        </div>
        <!-- Slide for Tony Fernandes content -->
        <div class="slide">
            <div class="section">
                <h2>Tony Fernandes</h2>
                <img class="tony-image" src="TonyFernandes.jpeg" alt="Tony Fernandes">
                <div>
                    <h3>Background</h3>
                    <p>Anthony Francis Fernandes, commonly known as Tony Fernandes, is a Malaysian entrepreneur who is best known for co-founding AirAsia, a low-cost airline based in Malaysia. He has also ventured into various other industries, including telecommunications and sports.</p>
                </div>
                <div>
                    <h3>Key Achievements and Marketing Strategies</h3>
                    <div>
                        <h4>Founding AirAsia</h4>
                        <p>In 2001, Fernandes purchased AirAsia, then a struggling government-owned airline, for the token sum of RM1 (approximately USD 0.25). He transformed it into a successful low-cost carrier by implementing aggressive cost-cutting measures, embracing digital technology, and focusing on efficiency.</p>
                    </div>
                    <div>
                        <h4>Revolutionizing Air Travel</h4>
                        <p>Under Fernandes' leadership, AirAsia revolutionized air travel in Southeast Asia by making flying affordable for millions of people who previously could not afford it. This strategy included dynamic pricing, direct online bookings, and efficient operations.</p>
                    </div>
                    <div>
                        <h4>Bold Marketing Campaigns</h4>
                        <p>Fernandes and AirAsia became known for their bold and unconventional marketing campaigns. They used catchy slogans, humorous advertisements, and vibrant branding to attract customers and differentiate AirAsia from traditional airlines.</p>
                    </div>
                    <div>
                        <h4>Expanding Beyond Aviation</h4>
                        <p>Beyond AirAsia, Fernandes expanded his business interests into telecommunications (with Tune Talk) and sports (owning Queens Park Rangers Football Club). These ventures have further solidified his reputation as a diversified entrepreneur.</p>
                    </div>
                </div>
                <div>
                    <h3>Impact and Recognition</h3>
                    <p>Tony Fernandes' innovative approach to business and marketing has not only made AirAsia a household name in Asia but also earned him numerous accolades and recognition. He has been named among the "100 most influential people in the world" by Time magazine and received multiple awards for his contributions to the aviation industry and entrepreneurship in Malaysia.</p>
                </div>
            </div>
        </div>
        
        <!-- Slide for Add Content -->
        <div class="slide">
            <div class="container">
                <h2>Add Content</h2>
                <form action="addContent.jsp" method="post">
                    <label for="admin_id">Admin ID:</label>
                    <input type="text" id="admin_id" name="admin_id" required><br><br>

                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required><br><br>

                    <label for="log_date">Log Date:</label>
                    <input type="date" id="log_date" name="log_date" required><br><br>

                    <label for="description">Description:</label><br>
                    <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

                    <input type="submit" value="Add Content">
                </form>
            </div>
        </div>
        
    </div>
    <!-- End of Slideshow -->

    <!-- Slideshow navigation buttons -->
    <a class="prev" onclick="changeSlide(-1)">&#10094; </a>
    <a class="next" onclick="changeSlide(1)"> &#10095;</a>
</div>

<script>
    function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }

    // Slideshow functionality
    var slideIndex = 1;
    showSlide(slideIndex);

    function changeSlide(n) {
        showSlide(slideIndex += n);
    }

    function showSlide(n) {
        var slides = document.getElementsByClassName("slide");
        if (n > slides.length) { slideIndex = 1; }
        if (n < 1) { slideIndex = slides.length; }
        for (var i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slides[slideIndex - 1].style.display = "block";
    }
</script>
<div class="footer">
    <p>&copy; 2024 Marketing Success Stories</p>
</div>

</body>