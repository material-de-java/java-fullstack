// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarEmpleados();
  $('#templeados').DataTable();
});


async function cargarEmpleados(){

      const respuesta = await fetch('empleados', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const empleados = await respuesta.json();

      let listadoHtml= '';
      for (let emp of empleados) {
        let empleadoHtml = '<tr> <td>'+emp.id+'</td> <td>'+emp.nombre+'</td> <td>'+emp.apellido+'</td> <td>'+emp.telefono+'</td> <td>'+emp.correo+'</td> <td> <a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a> </td> </tr>';

        listadoHtml += empleadoHtml;
        
      }

      console.log('templeados');
      console.log(empleados);
      
      document.querySelector('#templeados tbody').outerHTML = listadoHtml;
}
