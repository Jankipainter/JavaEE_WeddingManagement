//window.onload=function (){
//    document.getElementById("download").addEventListener("click",()=>{
//        const invoice=document.getElementById("invoice");
//        console.log(invoice)
//        html2pdf().from(invoice).save();
//    })
//}
//
//jQuery(document).ready(function (){
//   $('#btn-print').click(function () {
//       let wcontent=document.getElementById('invoice').content;
////    
//        window.print();
//        
////        $(window).print
//    }) ;
//});
function printPage(){
    var body=document.getElementById('body').innerHTML;
    var data=document.getElementById('invoice').innerHTML;
    document.getElementById('body').innerHTML=data;
    window.print();
}