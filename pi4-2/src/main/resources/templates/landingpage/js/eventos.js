/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

document.getElementById('eventForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const eventTitle = formData.get('eventTitle');
    const startDate = formData.get('startDate');
    const endDate = formData.get('endDate');
    const eventDescription = formData.get('eventDescription');

    addEvent(eventTitle, startDate, endDate, eventDescription);
});

function addEvent(title, start, end, description) {
    const postContainer = document.getElementById('postContainer');
    const postDiv = document.createElement('div');
    postDiv.classList.add('post');

    const titleElement = document.createElement('h3');
    titleElement.textContent = title;

    const startElement = document.createElement('p');
    startElement.textContent = 'Início: ' + new Date(start).toLocaleString();

    const endElement = document.createElement('p');
    endElement.textContent = 'Fim: ' + new Date(end).toLocaleString();

    const descriptionElement = document.createElement('p');
    descriptionElement.textContent = description;

    postDiv.appendChild(titleElement);
    postDiv.appendChild(startElement);
    postDiv.appendChild(endElement);
    postDiv.appendChild(descriptionElement);

    postContainer.prepend(postDiv);
}

