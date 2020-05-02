function limpiarRutAlFallar() {

    var rutLimpio = $.rut.formatear(document.getElementById("rut").value);

    var rutValido = $.rut.validar(rutLimpio);

    if (!rutValido && document.getElementById("rut").value != null && document.getElementById("rut").value != "") {
        document.getElementById("rut").value = "";
        document.getElementById("rut-error").innerHTML = "RUT no válido, ingresar de nuevo";
    }
    if (rutValido && document.getElementById("rut").value != null && document.getElementById("rut").value != "") {
        document.getElementById("rut-error").innerHTML = "<span style='color: green;'>RUT válido</span>";
    }
}

function validarCorreo(correo)
{
    if (esCorreoElectronico(correo))
    {
        document.getElementById('mjCorreo').innerHTML = '<span style="color: green;">Correo con formato correcto</span>';
    } else
    {
        novalido = '<span style="color: red;">No es un correo electrónico</span>';
        document.getElementById('correo').value = "";
        document.getElementById('mjCorreo').innerHTML = novalido;
    }
}

function esCorreoElectronico(correoElectronico) {
    var patron = /^([a-z]+[a-z1-9._-]*)@{1}([a-z1-9\.]{2,})\.([a-z]{2,3})$/;
    if (!correoElectronico.search(patron))
        return true;
    else
        return false;
}

function validaNombreEmpresa(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">El nombre de la empresa debe contener solamente letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">El nombre no puede comenzar ni terminar con espacios</span>';
        }

        document.getElementById('nombre').value = "";
        document.getElementById('mjNombre').innerHTML = novalido;
    } else
    {
        document.getElementById('mjNombre').innerHTML = "";
    }
}

function validaRazonSocialEmpresa(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">La razón social debe contener solamente letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">La razón social no puede comenzar ni terminar con espacios</span>';
        }

        document.getElementById('razonSocial').value = "";
        document.getElementById('mjRazonSocial').innerHTML = novalido;
    } else
    {
        document.getElementById('mjRazonSocial').innerHTML = "";
    }
}

function validaDireccion(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">La dirección debe contener solo letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">La dirección no puede comenzar ni terminar con espacios</span>';
        }

        document.getElementById('direccion').value = "";
        document.getElementById('mjDireccion').innerHTML = novalido;
    } else
    {
        document.getElementById('mjDireccion').innerHTML = "";
    }
}

function validaFono(input)
{
    var patron = /^[0-9]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">El fono puede contener solo números, sin espacios intermedios</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del fono</span>';
        }

        document.getElementById('fono').value = "";
        document.getElementById('mjFono').innerHTML = novalido;
    } else
    {
        document.getElementById('mjFono').innerHTML = "";
    }
}

function validaLetra(input, tipo)
{

    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        switch (tipo) {
            case 'pnombre':

                if (nom)
                {
                    novalido = '<span style="color: red;">El primer nombre debe contener solo letras</span>';
                }
                if (nom2)
                {
                    novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del primer nombre</span>';
                }

                document.getElementById('pnombre').value = "";
                document.getElementById('mjPnombre').innerHTML = novalido;

                break;
            case 'snombre':

                if (nom)
                {
                    novalido = '<span style="color: red;">El segundo nombre debe contener solo letras</span>';
                }
                if (nom2)
                {
                    novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del segundo nombre</span>';
                }

                document.getElementById('snombre').value = "";
                document.getElementById('mjSnombre').innerHTML = novalido;

                break;
            case 'appaterno':

                if (nom)
                {
                    novalido = '<span style="color: red;">El apellido paterno debe contener solo letras</span>';
                }
                if (nom2)
                {
                    novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del apellido paterno</span>';
                }

                document.getElementById('appaterno').value = "";
                document.getElementById('mjAppaterno').innerHTML = novalido;

                break;
            case 'apmaterno':

                if (nom)
                {
                    novalido = '<span style="color: red;">El apellido materno debe contener solo letras</span>';
                }
                if (nom2)
                {
                    novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del apellido materno</span>';
                }

                document.getElementById('apmaterno').value = "";
                document.getElementById('mjApmaterno').innerHTML = novalido;

                break;
            default:

                break;
        }
    } else
    {
        switch (tipo) {
            case 'pnombre':
                document.getElementById('mjPnombre').innerHTML = "";
                break;
            case 'snombre':
                document.getElementById('mjSnombre').innerHTML = "";
                break;
            case 'appaterno':
                document.getElementById('mjAppaterno').innerHTML = "";
                break;
            case 'apmaterno':
                document.getElementById('mjApmaterno').innerHTML = "";
                break;
            default:
                break;
        }
    }
}

function validaNombrePersona(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">El nombre debe contener solamente letras</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">El nombre no puede comenzar ni terminar con espacios</span>';
        }

        document.getElementById('nombre').value = "";
        document.getElementById('mjNombre').innerHTML = novalido;
    } else
    {
        document.getElementById('mjNombre').innerHTML = "";
    }
}

function validaNombres(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">Los nombres deben contener solamente letras</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">Los nombres no pueden comenzar ni terminar con espacios</span>';
        }

        document.getElementById('nombres').value = "";
        document.getElementById('mjNombres').innerHTML = novalido;
    } else
    {
        document.getElementById('mjNombres').innerHTML = "";
    }
}


function validaApellidos(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">Los apellidos deben contener solamente letras</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">Los apellidos no pueden comenzar ni terminar con espacios</span>';
        }

        document.getElementById('apellidos').value = "";
        document.getElementById('mjApellidos').innerHTML = novalido;
    } else
    {
        document.getElementById('mjApellidos').innerHTML = "";
    }
}

function cambiarEstadoFechaTermino()
{ 
    if (document.getElementById('r2').checked) 
    {
        var valorReservado = document.getElementById("fechaTerminoReservada").value;
        document.getElementById("fechaTermino").value =  valorReservado;  
        document.getElementById("fechaTermino").disabled = false;
    }
    else if (document.getElementById('r1').checked)
    {
        document.getElementById("fechaTermino").value = "INDEFINIDO";        
    }
}

function validarActualizarFoto()
{
    if (document.getElementById('r10').checked) 
    {
        document.getElementById("baha-fotoupdate").innerHTML = '<br><input type="hidden" name="status" value="part"> <label for="foto">Foto:</label><br><input type="file" class="form-control-file" id="foto" name="foto" accept=".gif,.jpg,.jpeg" required> <div id="mjLogo"></div><br>';
    }
    else if (document.getElementById('r11').checked)
    {
        document.getElementById("baha-fotoupdate").innerHTML = '<input type="hidden" name="status" value="non-part"> <br>';        
    }   
}

function validaCausa(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;

        if (nom)
        {
            novalido = '<span style="color: red;">La causa debe contener solo letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">La causa no puede comenzar ni terminar con espacios</span>';
        }

        document.getElementById('causa').value = "";
        document.getElementById('mjCausa').innerHTML = novalido;
    } else
    {
        document.getElementById('mjCausa').innerHTML = "";
    }
}