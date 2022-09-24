const imagenGrande = document.getElementById("Imagen")
const texto = document.getElementById("Texto")
const imagenes = document.getElementById("imagenes")

///INDEX
imagenes.addEventListener("click", function(e){
    console.log(e.srcElement.alt)
    console.log(Imagenes[e.srcElement.alt].src)
    console.log(imagenGrande.src = Imagenes[e.srcElement.alt].src)
    console.log(texto.innerHTML = Imagenes[e.srcElement.alt].texto)
})

//LOGIN


const imagen1 = document.getElementById("imagenFondo1")
const imagen2 = document.getElementById("imagenFondo2")
const imagen3 = document.getElementById("imagenFondo3")
const body = document.getElementsByTagName("body")

/* botones = [imagen1, imagen2, imagen3] */

function Superadministrador(i){
    console.log(i)
    const imagen1 = document.getElementById("imagenFondo1")
    const imagen2 = document.getElementById("imagenFondo2")
    const imagen3 = document.getElementById("imagenFondo3")

    if(i === 1){
        console.log(imagen1)
        imagen1.style.display = "none";
        imagen2.style.display = "block";
        imagen3.style.display = "block";
    }

    else if(i === 2){
        console.log(imagen1)
        imagen1.style.display = "block";
        imagen2.style.display = "none";
        imagen3.style.display = "block";
    }

    else if(i === 3){
        console.log(imagen1)
        imagen1.style.display = "block";
        imagen2.style.display = "block";
        imagen3.style.display = "none";
    }
}

function Plataforma1(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/plataformaSuperadministrador.html")
}

function Plataforma2(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/plataformaAdministrador.html")
}

function Plataforma3(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/plataformaEmpleado.html")
}

//Plataformas

function Nuevo1(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/NuevoSuperadministrador.html")
}

function Nuevo2(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/NuevoAdministrador.html")
}

function Nuevo3(){
    alert("Correcto", window.location.href = "http://127.0.0.1:5500/NuevoEmpleado.html")
}

//HAMBURGUESA
let menu = document.getElementsByClassName("Menu-hamburguesa-pop-up")

function menuhamburguesa(){
    menu[0].style.display = "block"
    body[0].style.overflow = "hidden"
}
function cerrarmenu(){
    menu[0].style.display = "none"
    body[0].style.overflow = "auto"
}

//FIN HAMBURGUESA
