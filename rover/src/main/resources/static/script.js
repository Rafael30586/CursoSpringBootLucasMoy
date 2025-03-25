function createMap(){
    moveRover(2,3);
    createRock(4,5);
    createRock(1,1);
    createRock(4,7);
    createRock(8,8);
}

function moveRover(x,y){
    document.getElementById("rover").style.left = (x * 100) + 'px';
    document.getElementById("rover").style.top = (y * 100) + 'px';
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

function clickBtnRotateLeft(){
    alert("LEFT");

}

function clickBtnRotateRight(){
    alert("RIGHT");

}

function clickBtnMoveForward(){
    alert("FORWARD");

}

function clickBtnMoveBack(){
    alert("BACK");

}