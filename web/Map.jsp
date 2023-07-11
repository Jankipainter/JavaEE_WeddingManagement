

<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>
        <!--<link href="User/header.jsf"/>-->

         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css" />

        <!-- Custom styles for this template -->
        <link href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="User/JS/map.js"></script>
<style>
            .place-picker{
                width: 100%;
                max-width: 630px;
                padding: 15px;
                margin: 0 auto;
            }
            
            .placePickerUIButton{
                margin-right: 20%;
            }
        </style>
      

    </head>
    <body>
        <div class="container" style="margin-left: 0px;height: 100%;margin-top: 0px;width: 100%">
        <div>
            <!--<img src="resources/image/header.png" style="margin-bottom: 10%;width: 100%;height: 30%"/>-->
        </div>
        
        <br/>
        <div style="margin-left: 20%;margin-bottom: 50%">
          <form action="mapServlet" method="POST">
           
            <h1 class="h3 mb-3 font-weight-normal">Wedding Location</h1>
            <label class="sr-only">Address</label>
            <input type="text" name="address" id="pickup_country" onclick="alert('Location Added..')" class="form-control" placeholder="Address"  autofocus="true" required="true" style="width: 1000px;height: 70px;font-size: 19px" ><br/>
            
            <input type="submit" name="addPlace" class="btn btn-primary" value="Add Place" style="background-color: #3b7771;color: #ffffff;font-size: 2rem;border: none"/>
            
            <a href="User/Event.jsf" class="btn btn-primary" style="background-color: #3b7771;color: #ffffff;-webkit-text-decorations-in-effect: none; font-size: 2rem;margin-left: 63%;border: none"> Next </a>
        </form> 
        </div>
        </div>
    </body>
</html>