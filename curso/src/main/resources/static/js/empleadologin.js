// Call the dataTables jQuery plugin
$(document).ready(function() {
    // no se hace nada cuando se carga el documento
    // las acciones se lanzan con eventos click
  //$('#tabla-empleados').DataTable();
});


async function iniciarSesion(){

  let datosLogin = {};

  //mismas propiedades de Model/Empleado
  // se puede usar un selector agregando #, así: documen.querySelector('#FirstName');
   
  datosLogin.correo= document.getElementById('InputEmail').value;
  datosLogin.passw= document.getElementById('InputPassword').value;

  // en fetch se usa el valor del RequestMapping del metodo del controller 
  const respuesta = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //capturar datos del formulario
    body: JSON.stringify(datosLogin)
  });

  const consulta = await respuesta.text();

  console.log('EMPLEADO LOGIN: consulta ->');
  console.log(consulta);
  
  if(consulta != "null"){

    // guarda localmente el token enviado desde el servidor
    localStorage.token=consulta;
    localStorage.correo=datosLogin.correo;

    window.location.href = 'templeados.html'
  }
  else{
    alert('Datos Incorrectos!')
  }
  
}


