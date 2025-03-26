createMap();

async function createMap(){
    //Obtener la informacion del rover
    let roverResponse = await fetch('/api/rover',{ 
        method: 'GET',
        headers: {
            'content-type':'application/json'
        }
    })

    let roverJson = await roverResponse.json();
    moveRover(roverJson.x,roverJson.y);

    //Obtener la informacion de los obstaculos

    let obstacleResponse = await fetch('/api/obstacle',{
        method: 'GET',
        headers: {
            'content-type':'application/json'
        }
    })

    let obstaclesJson = await obstacleResponse.json();
    

    obstaclesJson.forEach(element => {
        createRock(element.x,element.y)
    });
    
}

function moveRover(x,y){
    document.getElementById("rover").style.left = (x * 100) + 'px';
    document.getElementById("rover").style.top = (y * 100) + 'px';

    playMoveSound();
}

function createRock(x,y){
    var rock = document.createElement("img");
    rock.setAttribute("src","images/rock.png");
    rock.setAttribute("class","rock");
    var container = document.getElementById("container");
    container.appendChild(rock);

    rock.style.left = (x*100) + 'px';
    rock.style.top = (y*100) + 'px';
}

var posX = 0;
var posY = 0;

function clickBtnRotateLeft(){
    posX--;
    moveRover(posX, posY);
}

function clickBtnRotateRight(){
    posX++;
    moveRover(posX, posY);
}

function clickBtnMoveForward(){
    posY++;
    moveRover(posX, posY);
}

function clickBtnMoveBack(){
    posY--;
    moveRover(posX, posY);
}

function playMoveSound(){
    var audioElement = document.getElementById("audio");
    audioElement.src = "sounds/move.wav";

    audioElement.controls = true;
    audioElement.autoplay = true;

    document.getElementById("container").appendChild(audioElement);
}