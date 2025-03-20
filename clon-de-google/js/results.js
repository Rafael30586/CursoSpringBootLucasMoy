const URL_API = 'http://localhost:8080/api/';

let jsonExample = [
    {
      "id": 1660,
      "domain": "elpais.com",
      "url": "https://elpais.com/smoda/famosos/2025-03-18/nicole-wallace-ana-rujas-o-blanca-suarez-de-dia-y-de-noche-todos-los-looks-del-festival-de-malaga.html",
      "title": "Nicole Wallace, Ana Rujas o Blanca Suárez, de día y de noche: todos los ‘looks’ del Festival de Málaga | Fotos | Famosos | S Moda | EL PAÍS",
      "description": "La edición número 28 del festival de cine malagueño reúne a rostros conocidos, de Maria de Medeiros a Mario Casas",
      "picture": "https://imagenes.elpais.com/resizer/v2/MNM7VQNNZJDUZAW364VDDXQ5BE.jpg?auth=019b3fb346b8e387202719b471fde780156c1023caf767ffa562a50571122cd1&width=1200",
      "pageRank": null
    },
    {
      "id": 1661,
      "domain": "elpais.com",
      "url": "https://elpais.com/smoda/famosos/2025-03-18/nicole-wallace-ana-rujas-o-blanca-suarez-de-dia-y-de-noche-todos-los-looks-del-festival-de-malaga.html",
      "title": "Nicole Wallace, Ana Rujas o Blanca Suárez, de día y de noche: todos los ‘looks’ del Festival de Málaga | Fotos | Famosos | S Moda | EL PAÍS",
      "description": "La edición número 28 del festival de cine malagueño reúne a rostros conocidos, de Maria de Medeiros a Mario Casas",
      "picture": "https://imagenes.elpais.com/resizer/v2/MNM7VQNNZJDUZAW364VDDXQ5BE.jpg?auth=019b3fb346b8e387202719b471fde780156c1023caf767ffa562a50571122cd1&width=1200",
      "pageRank": null
    }
]    

function onClickSearch(){
    let query = document.getElementById('txtSearch').value;
    search(query);
}

async function search(query){

    let url = URL_API + "search?query="+query;
    let result = await fetch(url);
    let jsonResult = await result.json();

    let html = '';
    for(let json of jsonResult){
        let description = json.description.substring(0,200)+"...";
        
        html += `<div class="result">
                <div class="title">
                    <img src="${json.picture}" alt="" class="picture">
                    <a href="${json.url}" target="_blank">${json.title}</a>
                </div>
                <div class="description">
                    <p>${description}</p>
                </div>
                
            </div>`;

    }

    document.getElementById('results').outerHTML = html;
 
}

function load(){
    let query = window.location.href.split('?query=')[1];
    document.getElementById('txtSearch').value = query;
    search(query);
}

load();

