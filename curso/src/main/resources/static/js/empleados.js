// Call the dataTables jQuery plugin
$(document).ready(function() {
    contentProfileEmail();
    cargarEmpleados();
    //$('#tabla-empleados').DataTable();
});


function getHeaders() {
  return {
   'Accept': 'application/json',
   'Content-Type': 'application/json',
   'Authorization': localStorage.token
 };
}

//actualiza el email del usuario en la barra
function contentProfileEmail(){
  document.getElementById('txt-id-empleado').outerHTML = ' '+localStorage.correo+' ';
}

async function cargarEmpleados(){
  // en fetch se usa el valor del RequestMapping del metodo del controller 
  const respuesta = await fetch('api/empleados', {
    method: 'GET',
    headers: getHeaders()
  });

  const empleados = await respuesta.json();

  console.log('#tabla-empleados');
  console.log(empleados);

  let listadoHtml= '';

  for (let emp of empleados) {


    // en caso de que algun campo mostrado sea null muestra un guion
    let nombre = emp.nombre == null ? '-' : emp.nombre
    let apellido = emp.apellido == null ? '-' : emp.apellido
    let telefono = emp.telefono == null ? '-' : emp.telefono
    let correo = emp.correo == null ? '-' : emp.correo

    let htmlOnClick=' onclick="eliminarEmpleado('+emp.id+')" ';
    let botonDelete='<a href="#"'+htmlOnClick+'class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a>';
    let empleadoHtml = '<tr> <td>'+emp.id+'</td> <td>'+nombre+'</td> <td>'+apellido+'</td> <td>'+telefono+'</td> <td>'+correo+'</td> <td> '+botonDelete+' </td> </tr>';

    listadoHtml += empleadoHtml;    
  }

  document.querySelector('#tabla-empleados tbody').outerHTML = listadoHtml;
}

async function eliminarEmpleado(id){

  let mensajeDelete='¿Esta seguro que desea eliminar al Empleado?';

  if(confirm(mensajeDelete)){
        // en fetch se usa el valor del RequestMapping del metodo del controller 
    const respuesta = await fetch('api/empleados/'+id, {
      method: 'DELETE',
      headers: getHeaders()
    });
    location.reload();
  }

}
