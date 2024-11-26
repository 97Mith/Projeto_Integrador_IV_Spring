/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

document.getElementById('postForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const photo = formData.get('photo');
    const text = formData.get('text');

    const reader = new FileReader();
    reader.onload = function (e) {
        const imageUrl = e.target.result;
        addPost(imageUrl, text);
    };
    reader.readAsDataURL(photo);
});

function addPost(imageUrl, text) {
    const postContainer = document.getElementById('postContainer');
    const postDiv = document.createElement('div');
    postDiv.classList.add('post');

    const img = document.createElement('img');
    img.src = imageUrl;
    img.alt = "Foto do post";

    const p = document.createElement('p');
    p.textContent = text;

    postDiv.appendChild(img);
    postDiv.appendChild(p);

    postContainer.prepend(postDiv);
}
