// Call the dataTables jQuery plugin
$(document).ready(function() {
    // no se hace nada cuando se carga el documento
    // las acciones se lanzan con eventos click
  //$('#tabla-empleados').DataTable();
});


async function registrarEmpleado(){

  let datosEmp = {};
  let repetirPassword = document.getElementById('RepeatPassword').value;

  //mismas propiedades de Model/Empleado
  // se puede usar un selector agregando #, así: documen.querySelector('#FirstName');
  datosEmp.nombre= document.getElementById('FirstName').value;
  datosEmp.apellido= document.getElementById('LastName').value;
  datosEmp.telefono= document.getElementById('Phone').value;
  datosEmp.correo= document.getElementById('InputEmail').value;
  datosEmp.passw= document.getElementById('InputPassword').value;

  // si entra al fin retorna para que pare la ejecucion del codigo
  if(repetirPassword!=datosEmp.passw){
    alert('La contraseña no coincide');
    return;
  }

  // en fetch se usa el valor del RequestMapping del metodo del controller 
  const respuesta = await fetch('api/empleados', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //capturar datos del formulario
    body: JSON.stringify(datosEmp)
  });

  alert('Empleado Agregado Correctamente!')
  window.location.href = 'EmpleadoLogin.html'

}


