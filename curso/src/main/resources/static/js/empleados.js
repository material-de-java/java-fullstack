// Call the dataTables jQuery plugin
$(document).ready(function() {
    verificarSesion();
    contentProfileEmail();
    cargarEmpleados();
    //$('#tabla-empleados').DataTable();
});

function logoutEmpleado(varLog){
  localStorage.clear();
  if (varLog=='logout'){
    alert('Sesión cerrada!');
  }

  window.location.href = 'EmpleadoLogin.html';
}

function verificarSesion(){
  if(localStorage.token==null || localStorage.correo==null){
    alert('El Empleado aún no ha iniciado sesión!');
    window.location.href = 'EmpleadoLogin.html';
  }
}


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


  try {

    // respuesta del back
    const empleados = await respuesta.json();

    // si es null es porque java lo envio por la verificación fallida del token
    // en caso de que sea null cierra la sesion
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

  } catch (error) {
    //nunca deberia llegar aca ya que se verificar la sesion primero
    console.log('error token ---');
    logoutEmpleado('errorLogin');
  }
  
}

async function eliminarEmpleado(id){

  let mensajeDelete='¿Esta seguro que desea eliminar al Empleado?';

  if(confirm(mensajeDelete)){
        // en fetch se usa el valor del RequestMapping del metodo del controller 
    const respuesta = await fetch('api/empleados/'+id, {
      method: 'DELETE',
      headers: getHeaders()
    });

    try {
      const resultado = await respuesta.json();  
      location.reload();
    } catch (error) {
      console.log('error token ---');
      logoutEmpleado('errorLogin');
    }    
  }

}
