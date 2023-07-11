/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var counter = 0;
            const slides = document.getElementsByClassName(".slide");

            function goPrev() {
                if (counter === (-slides.length)) {
                    counter = 0;
                } else {
                    counter--;
                }
                console.log(counter);
                slideImage();
            }

            function goNext() {
                if (counter === (slides.length)) {
                    counter = 0;
                } else {
                    counter++;
                }
                console.log(counter);
                slideImage();
            }

            function slideImage() {
                var temp = counter;
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.left = temp * 300 + "px";
                    temp += 1;
                }
            }

