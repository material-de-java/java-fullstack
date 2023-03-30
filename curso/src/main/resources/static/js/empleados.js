// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarEmpleados();
  $('#tabla-empleados').DataTable();
});


async function cargarEmpleados(){
  // en fetch se usa el valor del RequestMapping del metodo del controller 
  const respuesta = await fetch('api/empleados', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  const empleados = await respuesta.json();

  console.log('#tabla-empleados');
  console.log(empleados);

  let listadoHtml= '';

  for (let emp of empleados) {
    let htmlOnClick=' onclick="eliminarEmpleado('+emp.id+')" ';
    let botonDelete='<a href="#"'+htmlOnClick+'class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a>';
    let empleadoHtml = '<tr> <td>'+emp.id+'</td> <td>'+emp.nombre+'</td> <td>'+emp.apellido+'</td> <td>'+emp.telefono+'</td> <td>'+emp.correo+'</td> <td> '+botonDelete+' </td> </tr>';

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
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    location.reload();
  }

}
