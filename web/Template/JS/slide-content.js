////const slides = document.querySelectorAll(".slide")
////console.log(slides);
////var counter = 0;
////slides.forEach(
////        (slide, index) => {
////    slide.style.left = `$(index * 100)%`
////}
////)
////
////const goPrev = () => {
////    counter--
////    slideImage()
////}
////
////const goNext = () => {
////    counter++
////    slideImage()
////}
////
////const slideImage = () => {
////    slides.forEach(
////            (slide) => {
////        slide.style.transform = `translateX(-${counter * 100}%)`
////    }
////    )
////}
////


  var counter = 0;
            const slides = document.getElementsByClassName("slide");

            function goNext() {
              
                if (counter == (-slides.length+1)) {
                    counter = 0;
                } else {
                    counter--
                }
                console.log(counter)
                slideImage()
            }

            function goPrev() {
                if (counter == (-slides.length)) {
                    counter = 0;
                } else {
                    counter++
                }
                console.log(counter)
                slideImage()
            }

            function slideImage() {
 
                
                var temp = counter;
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.left = temp * 100 + "%";
                    temp += 1;
                }
            }

