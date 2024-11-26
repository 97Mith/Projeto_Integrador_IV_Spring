/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

var images = ["assets/BadSportLogoBlue.jpg", "assets/HeaderPhoto2.jpg", "assets/BadSportLogo.jpg"];
var currentIndex = 0;

function changeImage(direction) {
    if (direction === 'prox') {
        currentIndex = (currentIndex + 1) % images.length;
    } else if (direction === 'ant') {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
    }
    document.getElementById("headerImage").src = images[currentIndex];
}

setInterval(function () {
    changeImage('prox');
}, 10000);
